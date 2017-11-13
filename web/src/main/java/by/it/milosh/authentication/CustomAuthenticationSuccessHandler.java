package by.it.milosh.authentication;

import by.it.milosh.pojo.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = userService.findUserByUsername(authentication.getName());

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String contextPath = request.getContextPath();
        String nickname = user.getNickname();
        response.sendRedirect(contextPath + "/personal/" + nickname);

    }
}
