package by.it.milosh.service;

import by.it.milosh.pojo.Avatar;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

public interface AvatarService {

    void save(Avatar avatar);

    void save(Avatar avatar, FileInputStream inputStream, File file);

    Avatar get(Class clazz, Serializable id);

}
