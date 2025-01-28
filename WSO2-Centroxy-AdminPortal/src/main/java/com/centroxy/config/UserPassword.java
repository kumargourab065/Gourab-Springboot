//package com.centroxy.config;
//
//import com.centroxy.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class UserPassword implements UserDetails {
//
//    private User user;
//
//    public UserPassword(User user) {
//        this.user = user;
//
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
//        return List.of(authority);
//    }
//        @Override
//        public String getPassword(){
//           return user.getPassword();
//        }
//        @Override
//        public String getUsername(){
//        return user.getEmail();
//        }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    @Override
//    public  boolean isAccountNonLocked() {
//        return true;
//    }
//    @Override
//    public  boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
//
