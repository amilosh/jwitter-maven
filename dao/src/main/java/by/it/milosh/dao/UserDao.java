package by.it.milosh.dao;

import by.it.milosh.pojo.User;

import java.io.File;

public interface UserDao {

    void save(User user);

    User findUserByUsername(String username);

    User findUserByNickname(String nickname);

    void saveAvatarToUser(User user, byte[] bytes);

}
