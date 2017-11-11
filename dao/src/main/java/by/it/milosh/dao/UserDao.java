package by.it.milosh.dao;

import by.it.milosh.pojo.User;

public interface UserDao {

    void save(User user);

    User findUserByUsername(String username);

    User findUserByNickname(String nickname);

}
