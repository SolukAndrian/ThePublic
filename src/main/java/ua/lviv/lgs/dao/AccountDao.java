package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Account;

import java.util.List;

/**
 * Created by Apple on 08.03.2017.
 */
public interface AccountDao {
    void add(Account account);

    void edit(Account account);

    void editKey(Account account);

    void editPassword(Account account);

    void delete(Account account);

    Account findById(int id);

    Account findByLogin(String login);

    List<Account> findAll();
}
