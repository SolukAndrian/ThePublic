package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.MessageDao;
import ua.lviv.lgs.entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Apple on 30.03.17.
 */
@Repository
@Transactional
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext(name = "public")
    EntityManager entityManager;

    @Transactional
    public void add(Message message) {
        entityManager.persist(message);
    }

    @Transactional
    public void edit(Message message) {
        entityManager.merge(message);
    }

    @Transactional
    public void delete(Message message) {
        entityManager.remove(message);
    }

    @Transactional
    public Message findById(int id) {
        return entityManager.find(Message.class, id);
    }

    @Transactional
    public Message findByUserId(int userId_id) {
        return entityManager.find(Message.class, userId_id);
    }

    @Transactional
    public Message findByLogin(String login) {
        return entityManager.find(Message.class, login);
    }

    public List<Message> showAll(int id, int idi) {
        return entityManager.createQuery("select m from Message m where m.myId.id =:id or m.userId.id = :id").setParameter("id", id).getResultList();
    }

    public List<Message> showAllToMe(int id, int idi) {
        return entityManager.createQuery("select m from Message m where (m.userId.id = :id and m.myId.id = :idi) or (m.userId.id = :idi and m.myId.id = :id)").setParameter("id", id).setParameter("idi", idi).getResultList();
    }

    @Override
    public List<Message> showAllMessageFromFriends(int myId) {
        return entityManager.createQuery("SELECT m FROM Message m WHERE(m.myId.id = :myId) OR (m.userId.id = :myId)").setParameter("myId", myId).getResultList();
    }

    @Override
    public Message getLastMessageWithUser(int myId, int idUser) {
        return (Message)entityManager.createQuery("SELECT m FROM Message m WHERE (m.myId.id = :myId and m.userId.id = :userId) or (m.myId.id = :userId and m.userId.id = :myId) GROUP BY m.id HAVING COUNT(m.myId.id)>=1 AND COUNT(m.userId.id)>=1 order by m.date desc").setParameter("myId", myId).setParameter("userId", idUser).getResultList().get(0);
    }


}
