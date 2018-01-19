package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.MessageService;

import java.security.Principal;

/**
 * Created by Apple on 13.01.2018.
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "writeMessage/{id}", method = RequestMethod.GET)
    public String getPageForSendingMessage(Principal principal, Model model, @PathVariable Integer id) {
        model.addAttribute("friendData", accountService.findById(id));
        model.addAttribute("allMessagesWithFriend", messageService.showAllToMe(accountService.findByLogin(principal.getName()).getId(), id));
        return "writeMessage";
    }

    @RequestMapping(value = "/sendMessage/{friendId}", method = RequestMethod.POST)
    private String sendMessage(@PathVariable int friendId, @RequestParam(value = "text") String text, Principal principal) {
        messageService.add(text, accountService.findByLogin(principal.getName()), accountService.findById(friendId));
        return "redirect:/myMessages";
    }


    @RequestMapping(value = "/myMessages", method = RequestMethod.GET)
    public String getAllMessages(Model model, Principal principal) {
        model.addAttribute("userId", accountService.findByLogin(principal.getName()).getId());
        model.addAttribute("friendsMessage", messageService.showAllSortedMessageFromFriends(accountService.findByLogin(principal.getName()).getId()));
        return "allMyMessages";
    }
}
