package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.entity.UserInformation;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.UserInformationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Apple on 24.03.17.
 */
@Controller
public class UserInformationController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserInformationService userInformationService;

    @RequestMapping(value = "/inf", method = RequestMethod.GET)
    private String getInformationPage() {
        return "information";
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    private String changeInformation(@RequestParam(value = "inf") String sex,
                                     @RequestParam(value = "maritalStatus") String maritalStatus,
                                     @RequestParam(value = "age") int age,
                                     @RequestParam(value = "country") String country,
                                     @RequestParam(value = "city") String city,
                                     @RequestParam(value = "language") String language,
                                     @RequestParam(value = "image") MultipartFile image, Principal principal) throws IOException {
        byte[] bytes = image.getBytes();
        userInformationService.edit(accountService.findByLogin(principal.getName()).getId(), sex, maritalStatus, age, country, city, language, bytes);
        return "redirect:/";
    }


    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam(value = "id") Integer id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        UserInformation userInformation = userInformationService.findById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(userInformation.getImage());
        response.getOutputStream().close();

    }

}
