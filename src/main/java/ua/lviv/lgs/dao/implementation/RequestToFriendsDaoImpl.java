package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.lgs.dao.RequestToFriendsDao;
import ua.lviv.lgs.entity.RequestToFriends;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
@Repository
public class RequestToFriendsDaoImpl implements RequestToFriendsDao {
    @PersistenceContext(unitName = "public")
    private EntityManager entityManager;

    @Transactional
    public void add(RequestToFriends requestToFriends) {
        entityManager.persist(requestToFriends);
    }

    @Transactional
    public void edit(RequestToFriends requestToFriends) {
        entityManager.merge(requestToFriends);
    }

    @Transactional
    public void remove(RequestToFriends requestToFriends) {
        entityManager.remove(requestToFriends);
    }

    @Transactional
    public RequestToFriends findById(int id) {
        return entityManager.find(RequestToFriends.class, id);
    }

    @Transactional
    public List<RequestToFriends> findAll() {
        return entityManager.createQuery("select c from RequestToFriends c").getResultList();
    }
}
