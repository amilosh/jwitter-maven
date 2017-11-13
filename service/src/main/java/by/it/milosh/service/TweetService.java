package by.it.milosh.service;

import by.it.milosh.pojo.Tweet;

import java.util.List;

public interface TweetService {

    void save(Tweet tweet);

    public List<Tweet> getAllTweetsByNicknameOfUser(String nickname);

}
