package by.it.milosh.service;

import by.it.milosh.pojo.Tweet;
import by.it.milosh.pojo.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void saveByRole(User user, String roleName);

    User findUserByUsername(String username);

    User findUserByNickname(String nickname);

    void addTweetToUserByUsername(String username, Tweet tweet);

    void addTweetToUserByNickname(String nickname, Tweet tweet);

    List<Tweet> getAllTweetsByUser(String nickname);

    void saveAvatarToUser(String nickname, byte[] bytes);
}
