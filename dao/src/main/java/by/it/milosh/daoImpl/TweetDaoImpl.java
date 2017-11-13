package by.it.milosh.daoImpl;

import by.it.milosh.dao.TweetDao;
import by.it.milosh.pojo.Tweet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TweetDaoImpl implements TweetDao {

    private final static String GET_ALL_TWEETS_BY_NICKNAME_OF_USER = "select t from Tweet t left join t.user u where u.nickname=:nickname order by t.tweetId desc";

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Tweet tweet) {
        getSession().saveOrUpdate(tweet);
    }

    @Override
    public List<Tweet> getAllTweetsByNicknameOfUser(String nickname) {
        return getSession().createQuery(GET_ALL_TWEETS_BY_NICKNAME_OF_USER).setParameter("nickname", nickname).list();
    }
}
