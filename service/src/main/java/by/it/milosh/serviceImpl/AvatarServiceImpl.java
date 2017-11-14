package by.it.milosh.serviceImpl;

import by.it.milosh.dao.AvatarDao;
import by.it.milosh.pojo.Avatar;
import by.it.milosh.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

@Service
@Transactional
public class AvatarServiceImpl implements AvatarService{

    @Autowired
    private AvatarDao avatarDao;

    @Override
    public void save(Avatar avatar) {
        avatarDao.save(avatar);
    }

    @Override
    public void save(Avatar avatar, FileInputStream inputStream, File file) {
        avatarDao.save(avatar, inputStream, file);
    }

    @Override
    public Avatar get(Class clazz, Serializable id) {
        return avatarDao.get(Avatar.class, id);
    }
}
