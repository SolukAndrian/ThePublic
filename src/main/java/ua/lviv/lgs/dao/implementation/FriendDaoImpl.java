package ua.lviv.lgs.dao.implementation;


import org.springframework.stereotype.Repository;
import ua.lviv.lgs.dao.FriendDao;
import ua.lviv.lgs.entity.Friends;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
@Repository
public class FriendDaoImpl implements FriendDao {

    @PersistenceContext(unitName = "public")
    EntityManager entityManager;

    @Transactional
    public void add(Friends friends) {
        entityManager.persist(friends);
    }

    @Transactional
    public void edit(Friends friends) {
        entityManager.merge(friends);
    }

    @Transactional
    public void delete(Friends friends) {
        entityManager.remove(friends);
    }

    @Transactional
    public Friends findById(int id) {
        return entityManager.find(Friends.class,id);
    }


    @Transactional
    public List<Friends> findAll() {
        return entityManager.createQuery("select c from Friends c").getResultList();
    }

    @Transactional
    public List<Friends> findAllFriendId(int id) {
        return entityManager.createQuery("select c from Friends c where c.account.id=:id").setParameter("id",id).getResultList();
    }
}
