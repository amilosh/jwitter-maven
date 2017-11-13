package by.it.milosh.serviceImpl;

import by.it.milosh.dao.TweetDao;
import by.it.milosh.pojo.Tweet;
import by.it.milosh.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetDao tweetDao;

    @Override
    public void save(Tweet tweet) {
        tweet.setReTweets(0);
        tweet.setComments(0);
        tweet.setLikes(0);
        tweetDao.save(tweet);
    }

    @Override
    public List<Tweet> getAllTweetsByNicknameOfUser(String nickname) {
        return tweetDao.getAllTweetsByNicknameOfUser(nickname);
    }
}
