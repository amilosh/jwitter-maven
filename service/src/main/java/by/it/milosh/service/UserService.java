package by.it.milosh.service;

import by.it.milosh.pojo.User;

public interface UserService {

    void save(User user);

    void saveByRole(User user, String roleName);

    User findUserByUsername(String username);
}
