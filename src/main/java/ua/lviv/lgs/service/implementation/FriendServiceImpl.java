package ua.lviv.lgs.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.FriendDao;
import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.FriendService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendDao friendDao;

    @Autowired
    private AccountService accountService;

    public void add(Friends friends) {
        friendDao.add(friends);
    }

    public void edit(int id, Friends friends) {
        friends = friendDao.findById(id);
        if (friends.getIdFriend() != 0) {
            friends.setIdFriend(friends.getIdFriend());
        }
        if (friends.getAccount().getId() != 0) {
            friends.setAccount(friends.getAccount());
        }
        friendDao.edit(friends);
    }

    @Transactional
    public void delete(int id) {
        friendDao.delete(friendDao.findById(id));
    }

    public Friends findById(int id) {
        return friendDao.findById(id);
    }

    public List<Friends> findAll() {
        return friendDao.findAll();
    }

    @Override
    public List<Account> getAllMyFriends(String login) {
        Account account = accountService.findByLogin(login);
        List<Account> accountList = new ArrayList<Account>();
        List<Friends> friendsList = findAll();
        for (Friends friends : friendsList) {
            if (friends.getAccount().getId() == account.getId()) {
                accountList.add(accountService.findById(friends.getIdFriend()));
            }
        }
        return accountList;
    }

    public List<Friends> findAllFriendId(int id) {
        return friendDao.findAllFriendId(id);
    }
}
