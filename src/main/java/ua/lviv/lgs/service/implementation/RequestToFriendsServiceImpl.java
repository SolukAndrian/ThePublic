package ua.lviv.lgs.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.RequestToFriendsDao;
import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.RequestToFriends;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.FriendService;
import ua.lviv.lgs.service.RequestToFriendsService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
@Service
public class RequestToFriendsServiceImpl implements RequestToFriendsService {


    @Autowired
    private RequestToFriendsDao requestToFriendsDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private FriendService friendService;

    public void add(RequestToFriends requestToFriends) {
        requestToFriendsDao.add(requestToFriends);
    }

    @Transactional
    public void delete(int id) {
        requestToFriendsDao.remove(requestToFriendsDao.findById(id));
    }

    public RequestToFriends findById(int id) {
        return requestToFriendsDao.findById(id);
    }

    public List<RequestToFriends> findAll() {
        return requestToFriendsDao.findAll();
    }

    @Override
    public List<Account> getAllMyRequest(String login) {
        Account user = accountService.findByLogin(login);
        List<Account> accountList = new ArrayList<>();
        List<RequestToFriends> requests = findAll();
        for (RequestToFriends requestToFriends : requests) {
            if (requestToFriends.getAccountId().getId() == user.getId()) {
                accountList.add(accountService.findById(requestToFriends.getIdFriend().getId()));
            }
        }
        return accountList;
    }

    @Override
    @Transactional
    public void acceptRequest(Integer id, String login) {
        Account account = accountService.findByLogin(login);
        Account account2 = accountService.findById(id);
        Friends friend = new Friends(id, account);
        Friends friend2 = new Friends(account.getId(), accountService.findById(id));
        friend.setAccount(account);
        friend2.setAccount(account2);
        friendService.add(friend);
        friendService.add(friend2);

        List<RequestToFriends> requestToFriendsList = findAll();
        for (RequestToFriends requestToFriends : requestToFriendsList) {
            if (account2.getId() == requestToFriends.getIdFriend().getId() && account.getId() == requestToFriends.getAccountId().getId()) {
                delete(requestToFriends.getId());
            }
        }
    }

    @Override
    @Transactional
    public void rejectRequest(Integer id, String login) {
        Account account = accountService.findByLogin(login);
        Account account2 = accountService.findById(id);
        List<RequestToFriends> requestToFriendsList = findAll();
        for (RequestToFriends requestToFriends : requestToFriendsList) {
            if (account2.getId() == requestToFriends.getIdFriend().getId() && account.getId() == requestToFriends.getAccountId().getId()) {
                delete(requestToFriends.getId());
            }
        }
    }
}
