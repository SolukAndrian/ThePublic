package ua.lviv.lgs.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.UserInformationDao;
import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.UserInformation;
import ua.lviv.lgs.service.UserInformationService;

/**
 * Created by Apple on 24.03.17.
 */
@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    private UserInformationDao userInformationDao;

    public void add(String sex, String meritalStatus, int age, String counntry, String city, String languish, byte[] image, Account account) {
        userInformationDao.add(new UserInformation(sex, meritalStatus, age, counntry, city, languish, image, account));
    }

    public void edit(int id, String sex, String meritalStatus, int age, String counntry, String city, String languish, byte[] image) {
        UserInformation userInformation = userInformationDao.findById(id);
        if (sex.length() != 0 || !sex.equals("") || sex != null) {
            userInformation.setSex(sex);
        }
        if (meritalStatus.length() != 0 || !meritalStatus.equals("") || meritalStatus != null) {
            userInformation.setMaritalStatus(meritalStatus);
        }
        if (age != 0) {
            userInformation.setAge(age);
        }
        if (counntry.length() != 0 || !counntry.equals("") || counntry != null) {
            userInformation.setCity(city);
        }

        if (city.length() != 0 || !city.equals("") || city != null) {
            userInformation.setCity(city);
        }

        if (languish.length() != 0 || !languish.equals("") || languish != null) {
            userInformation.setLanguage(languish);
        }
        if (image.length != 0 || image.equals("") || image != null) {
            userInformation.setImage(image);
        }
        userInformationDao.edit(userInformation);
    }

    public void delete(int id) {
        userInformationDao.delete(id);
    }

    public UserInformation findById(int id) {
        return userInformationDao.findById(id);
    }

    public UserInformation showByLogin(String login) {
        return userInformationDao.showByLogin(login);
    }
}
