package ua.lviv.lgs.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.AccountDao;
import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.FriendService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Apple on 08.03.2017.
 */
@Service("userDetailService")
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private FriendService friendService;

    public void add(String surname, String name, Date date, String email, String phone, String login, String password) {
        Account account = new Account(surname, name, date, email, phone, login, password);
        accountDao.add(account);
    }

    public void edit(int id, String surname, String name, Date date, String email, String phone, String login, String password) {
        Account account = accountDao.findById(id);
        if (surname != null && !surname.equalsIgnoreCase("")) {
            account.setSurname(surname);
        }
        if (name != null && !name.equalsIgnoreCase("")) {
            account.setName(name);
        }
        if (email != null && !email.equalsIgnoreCase("")) {
            account.setEmail(email);
        }
        if (phone != null && !phone.equalsIgnoreCase("")) {
            account.setPhone(phone);
        }
        if (login != null && !login.equalsIgnoreCase("")) {
            account.setLogin(login);
        }
        if (password != null && !password.equalsIgnoreCase("")) {
            account.setPassword(password);
        }
        accountDao.edit(account);
    }

    public void editKey(String login, String key) {
        Account account = accountDao.findByLogin(login);
        account.setKey(key);
        accountDao.editKey(account);
    }

    @Override
    public void editPassword(String login, String password) {
        Account account = accountDao.findByLogin(login);
        account.setPassword(password);
        accountDao.editPassword(account);
    }

    public void delete(int id) {
        accountDao.delete(accountDao.findById(id));
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountDao.findByLogin(login);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(account.getLogin(), account.getPassword(), authorityList);
    }

    public Account findByLogin(String login) {
        return accountDao.findByLogin(login);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Transactional
    public void sendMailWithSecretKey(String login, String text) {
        final String username = "andrianlarson@gmail.com";
        final String password = "qwertyuiop[]";

        Properties props = new Properties();
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            MimeMessage message = new MimeMessage(session);
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(new InternetAddress(login));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(findByLogin(login).getEmail()));
            helper.setSubject("Support service The public");
            helper.setText("This is key for recover password, do not give it anyone " + text, true);

            synchronized (this) {
                Transport.send(message);
            }

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomGeneratedString() {
        char[] chars = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    @Override
    public List<Account> searchPeople(String login) {
        Account account = findByLogin(login);
        List<Account> accountsList = findAll();
        accountsList.remove(account.getId() - 1);
        List<Friends> friendsList = friendService.findAllFriendId(account.getId());
        Iterator<Account> accountIterator = accountsList.iterator();
        Iterator<Friends> friendsIterator = friendsList.iterator();
        while (friendsIterator.hasNext()) {
            Friends friend = friendsIterator.next();
            while (accountIterator.hasNext()) {
                Account user1 = accountIterator.next();
                int userId = user1.getId();
                int friendId = friend.getIdFriend();
                if (userId == friendId) {
                    accountIterator.remove();
                }
            }
        }
        return accountsList;
    }

}
