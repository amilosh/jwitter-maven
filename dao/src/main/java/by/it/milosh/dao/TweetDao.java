package by.it.milosh.dao;

import by.it.milosh.pojo.Tweet;

import java.util.List;

public interface TweetDao {

    void save(Tweet tweet);

    List getAllTweetsByNicknameOfUser(String nickname);

}
