package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.UserInformation;

/**
 * Created by Apple on 24.03.17.
 */
public interface UserInformationDao {
    void add(UserInformation userInformation);

    void edit(UserInformation userInformation);

    void delete(int id);

    UserInformation findById(int id);

    UserInformation showByLogin(String login);
}
