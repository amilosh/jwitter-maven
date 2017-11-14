package by.it.milosh.daoImpl;

import by.it.milosh.dao.AvatarDao;
import by.it.milosh.pojo.Avatar;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;

@Repository
public class AvatarDaoImpl implements AvatarDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Avatar avatar) {
        //getSession().saveOrUpdate(avatar);
    }

    @Override
    public void save(Avatar avatar, FileInputStream inputStream, File file) {
        Blob blob = Hibernate.getLobCreator(getSession()).createBlob(inputStream, file.length());
        avatar.setImage(blob);
        getSession().save(avatar);
        try {
            blob.free();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Avatar get(Class clazz, Serializable id) {
        return (Avatar) getSession().get(Avatar.class, id);
    }
}
