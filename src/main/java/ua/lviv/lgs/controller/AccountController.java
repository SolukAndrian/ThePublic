package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.dto.RegistrationDto;
import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.UserInformation;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.FriendService;
import ua.lviv.lgs.service.UserInformationService;

import java.io.IOException;
import java.security.Principal;
import java.util.Random;

/**
 * Created by Apple on 09.03.2017.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserInformationService userInformationService;

    private static String loginUserForNextStepRegistration;
    private static String loginUserForRestoringPassword;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Principal principal, Model model) {
        Account account = accountService.findByLogin(principal.getName());
        model.addAttribute("accountData", account);
        UserInformation information = userInformationService.showByLogin(principal.getName());
        model.addAttribute("informationAboutMe", information);
        return "home";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String login() {
        return "registration";
    }

    @RequestMapping(value = "/nextStepRegistration", method = RequestMethod.GET)
    public String getNextStepRegistrationPage() {
        return "registration2";
    }

    @RequestMapping(value = "/nextStepRegistration", method = RequestMethod.POST)
    public String registrationNextStep(
            @RequestParam(value = "inf") String sex,
            @RequestParam(value = "maritalStatus") String maritalStatus,
            @RequestParam(value = "age") int age,
            @RequestParam(value = "country") String country,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "language") String language,
            @RequestParam(value = "image") MultipartFile image) throws IOException {
        byte[] bytes = image.getBytes();
        userInformationService.add(sex, maritalStatus, age, country, city, language, bytes, accountService.findByLogin(loginUserForNextStepRegistration));
        return "redirect:/";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String settingChangeData() {
        return "information";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registration(@RequestBody RegistrationDto registrationDto) {
        accountService.add(registrationDto.getSurname(), registrationDto.getName(), registrationDto.getDate(), registrationDto.getEmail(), registrationDto.getPhone(), registrationDto.getLogin(), registrationDto.getPassword());
        loginUserForNextStepRegistration = registrationDto.getLogin();
    }

    @RequestMapping(value = "notRemember", method = RequestMethod.GET)
    public String rememberPassword() {
        return "rememberPassword";
    }


    @RequestMapping(value = "notRemember", method = RequestMethod.POST)
    public String rememberPassword(@RequestParam(value = "login") String login) {
        loginUserForRestoringPassword = login;
        String secretKey = accountService.getRandomGeneratedString();
        accountService.editKey(login, secretKey);
        accountService.sendMailWithSecretKey(login, secretKey);
        return "newPassword";
    }

    @RequestMapping(value = "newPassword", method = RequestMethod.GET)
    public String getRecoveryPasswordPage() {
        return "newPassword";
    }

    @RequestMapping(value = "newPassword", method = RequestMethod.POST)
    public String recoverPassword(@RequestParam(value = "key") String key, @RequestParam(value = "password") String password) {
        Account account = accountService.findByLogin(loginUserForRestoringPassword);
        if (account.getKey().equals(key)) {
            accountService.editPassword(loginUserForRestoringPassword, password);
            accountService.editKey(loginUserForRestoringPassword, "");
            return "redirect:/";
        } else {
            return "rememberPassword";
        }
    }
}
