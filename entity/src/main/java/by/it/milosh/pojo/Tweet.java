package by.it.milosh.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tweet")
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweetId")
    private Long tweetId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "comments", columnDefinition = "int default 0")
    private Integer comments;

    @Column(name = "reTweets", columnDefinition = "int default 0")
    private Integer reTweets;

    @Column(name = "likes", columnDefinition = "int default 0")
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Transient
    private String userNickname;

    public Tweet() {
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getReTweets() {
        return reTweets;
    }

    public void setReTweets(Integer reTweets) {
        this.reTweets = reTweets;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
