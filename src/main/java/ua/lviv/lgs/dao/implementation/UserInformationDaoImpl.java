package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.UserInformationDao;
import ua.lviv.lgs.entity.UserInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Apple on 24.03.17.
 */
@Repository
public class UserInformationDaoImpl implements UserInformationDao {

    @PersistenceContext(name = "public")
    private EntityManager entityManager;

    @Transactional
    public void add(UserInformation userInformation) {
        entityManager.persist(userInformation);
    }

    @Transactional
    public void edit(UserInformation userInformation) {
        entityManager.merge(userInformation);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(UserInformation.class, id));
    }

    @Transactional
    public UserInformation findById(int id)
    {
        return entityManager.find(UserInformation.class, id);
    }

    public UserInformation showByLogin(String login) {
        return (UserInformation) entityManager.createQuery("select u from UserInformation u where account.login =:login").setParameter("login", login).getSingleResult();
    }
}
