package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.AccountDao;
import ua.lviv.lgs.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Apple on 08.03.2017.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext(name = "public")
    private EntityManager entityManager;
    @Transactional
    public void add(Account account) {
        entityManager.persist(account);
    }

    @Transactional
    public void edit(Account account) {
        entityManager.merge(account);
    }

    @Transactional
    public void editKey(Account account) {
        entityManager.merge(account);
    }

    @Transactional
    public void editPassword(Account account) {
        entityManager.merge(account);
    }

    @Transactional
    public void delete(Account account) {
        entityManager.remove(account);
    }

    @Transactional
    public Account findById(int id) {
        return entityManager.find(Account.class,id);
    }


    @Transactional
    public Account findByLogin(String login) {
        return (Account)entityManager.createQuery("select c from Account c where c.login=:login").setParameter("login",login).getSingleResult();
    }

    @Transactional
    public List<Account> findAll() {
        return entityManager.createQuery("select c from Account c").getResultList();
    }
}
