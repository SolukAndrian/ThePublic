package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.RequestToFriends;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.FriendService;
import ua.lviv.lgs.service.RequestToFriendsService;

import java.security.Principal;

/**
 * Created by Apple on 02.04.2017.
 */
@Controller
public class AddingFriendController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private RequestToFriendsService requestToFriendsService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPeople(Principal principal, Model model) {
        model.addAttribute("people", accountService.searchPeople(principal.getName()));
        return "searchPeople";
    }


    @RequestMapping(value = "/addToFriend/{id}")
    public String sendRequestToUser(@PathVariable Integer id, Principal principal) {
        Account user = accountService.findById(id);
        RequestToFriends request =
                new RequestToFriends(accountService.
                        findById(accountService.findByLogin(principal.getName()).getId()),
                        accountService.findById(id));
        request.setAccountId(user);
        requestToFriendsService.add(request);
        return "redirect:/";
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String getPageWithAllRequests(Model model, Principal principal) {
        model.addAttribute("requests", requestToFriendsService.getAllMyRequest(principal.getName()));
        return "yourRequest";
    }

    @RequestMapping(value = "/yourFriends")
    public String getPageWithAllUserFriends(Model model, Principal principal) {
        model.addAttribute("listFriend", friendService.getAllMyFriends(principal.getName()));
        return "yourFriends";
    }

    @RequestMapping(value = "/acceptRequest/{id}")
    public String acceptRequest(@PathVariable Integer id, Principal principal) {
        requestToFriendsService.acceptRequest(id, principal.getName());
        return "redirect:/yourFriends";
    }

    @RequestMapping(value = "/rejectRequest/{id}")
    public String rejectRequest(@PathVariable Integer id, Principal principal) {
        requestToFriendsService.rejectRequest(id, principal.getName());
        return "redirect:/yourFriends";
    }
}
