package by.it.milosh.authentication;

import by.it.milosh.pojo.Role;
import by.it.milosh.pojo.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }

}
