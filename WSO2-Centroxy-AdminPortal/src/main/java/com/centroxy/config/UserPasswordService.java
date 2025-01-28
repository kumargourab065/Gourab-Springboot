package com.centroxy.config;

import com.centroxy.entity.User;
import com.centroxy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserPasswordService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUserName(username);
        if(user ==null){

            throw new UsernameNotFoundException("invalid user");
        }



//       // User.Role roles=user.getRole();
//      // String roless= roles.toString();
//        String password=user.getPassword();
//        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

        return new MyUserDetails(user);



    }

}
