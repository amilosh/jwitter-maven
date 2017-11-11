package by.it.milosh.controllers;

import by.it.milosh.RESTmodel.Response;
import by.it.milosh.RESTmodel.UserRequest;
import by.it.milosh.enumeration.RoleEnum;
import by.it.milosh.pojo.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            User user = userService.findUserByUsername(username);
            model.addAttribute("user", user);
        }
        return "start";
    }

    @RequestMapping(value = "/{nickname}", method = RequestMethod.GET)
    public String personalPage(@PathVariable String nickname, Model model) {
        User user = userService.findUserByNickname(nickname);
        model.addAttribute("user", user);
        return "personal";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "error");
        }
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        Cookie cookie = new Cookie("remember-me", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @RequestMapping(value = "/access_denied1", method = RequestMethod.GET)
    public String accessDenied() {
        return "access_denied1";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveByRole(user, RoleEnum.USER.getName());
        return "redirect:/";
    }

    @RequestMapping(value = "/main")
    public String showEmployeePage() {
        return "main";
    }

    @RequestMapping(value = "/getResponse", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Response getResponse(@RequestBody UserRequest userRequest) {
        Response response = new Response();
        User user = userService.findUserByUsername(userRequest.getUsername());
        if (user == null) {
            response.setMessage("false");
        } else {
            response.setMessage("true");
        }
        return response;
    }

    @RequestMapping(value = "/checkNickname", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Response checkNickname(@RequestBody UserRequest userRequest) {
        Response response = new Response();
        User user = userService.findUserByNickname(userRequest.getUsername());
        if (user == null) {
            response.setMessage("false");
        } else {
            response.setMessage("true");
        }
        return response;
    }

}
