package by.it.milosh.controllers;

import by.it.milosh.pojo.Tweet;
import by.it.milosh.pojo.User;
import by.it.milosh.service.TweetService;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/personal/changeProfile1", method = RequestMethod.GET)
    public String changeProfile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        User userFromDB = userService.findUserByUsername(user.getUsername());
        model.addAttribute("user", userFromDB);

        return "changeProfile";
    }

    @RequestMapping(value = "/personal/changeProfile1", method = RequestMethod.POST)
    public String changeProfile(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User userFromSession = (User) session.getAttribute("user");
        User userFromDB = userService.findUserByUsername(userFromSession.getUsername());
        userFromDB.setMessage(user.getMessage());
        userFromDB.setLocation(user.getLocation());
        userFromDB.setSite(user.getSite());
        userService.save(userFromDB);
        model.addAttribute("user", userFromDB);

        return "redirect:/personal/" + userFromDB.getNickname();
    }




}
