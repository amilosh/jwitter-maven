package by.it.milosh.controllers;

import by.it.milosh.pojo.Tweet;
import by.it.milosh.service.TweetService;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonalController {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addNewTweet", method = RequestMethod.POST)
    public String addNewTweet(@ModelAttribute("tweet") Tweet tweet, Model model) {
        String userNickname = tweet.getUserNickname();
        userService.addTweetToUserByNickname(userNickname, tweet);
        //userService.addTweetToUserByUsername(userService.findUserByNickname(userNickname).getUsername(), tweet);
        tweetService.save(tweet);

        return "redirect:/personal/" + userNickname;

    }

}
