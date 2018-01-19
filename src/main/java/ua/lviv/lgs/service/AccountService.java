package ua.lviv.lgs.service;

import ua.lviv.lgs.entity.Account;

import java.util.Date;
import java.util.List;

/**
 * Created by Apple on 08.03.2017.
 */
public interface AccountService {
    void add(String surname, String name, Date date, String email, String phone, String login, String password);

    void edit(int id, String surname, String name, Date date, String email, String phone, String login, String password);

    void editKey(String login, String key);

    void editPassword(String login, String password);

    void delete(int id);

    Account findById(int id);

    Account findByLogin(String login);

    void sendMailWithSecretKey(String login, String secretKey);

    List<Account> findAll();

    List<Account> searchPeople(String login);

    String getRandomGeneratedString();
}
