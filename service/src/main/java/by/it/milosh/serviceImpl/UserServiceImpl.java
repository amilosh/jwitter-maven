package by.it.milosh.serviceImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.dao.UserDao;
import by.it.milosh.pojo.Role;
import by.it.milosh.pojo.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findUserByNickname(String nickname) {
        return userDao.findUserByNickname(nickname);
    }

    @Override
    public void saveByRole(User user, String roleName) {
        Role role = roleDao.findRoleByRoleName(roleName);
        user.getRoles().add(role);
        userDao.save(user);
    }

}
