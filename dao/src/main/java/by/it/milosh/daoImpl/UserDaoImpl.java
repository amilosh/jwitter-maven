package by.it.milosh.daoImpl;

import by.it.milosh.dao.UserDao;
import by.it.milosh.pojo.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.sql.Blob;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return (User) getSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("username", username))
                .uniqueResult();
    }

    @Override
    public User findUserByNickname(String nickname) {
        return (User) getSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("nickname", nickname))
                .uniqueResult();
    }

    @Override
    public void saveAvatarToUser(User user, byte[] bytes) {
        Blob blob = null;
        try {
            blob = Hibernate.getLobCreator(getSession()).createBlob(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setAvatar(blob);
        getSession().saveOrUpdate(user);
    }
}
