package ua.lviv.lgs.service;

import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.UserInformation;

/**
 * Created by Apple on 24.03.17.
 */
public interface UserInformationService {
    void add(String sex, String meritalStatus, int age, String counntry, String city, String languish, byte[] image, Account account);

    void edit(int id, String sex, String meritalStatus, int age, String counntry, String sity, String languish, byte[] image);

    void delete(int id);

    UserInformation showByLogin(String login);

    UserInformation findById(int id);
}
