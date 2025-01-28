package com.centroxy.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserPasswordService userPasswordService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

     @Override
    protected void configure(HttpSecurity http) throws Exception {
          http.csrf().disable()
                 .authorizeRequests()
                  .antMatchers(HttpMethod.POST,"/api/users//addUserByAdmin").hasAnyRole("ADMIN","USER")
          .antMatchers(HttpMethod.POST,"/api/users/add/user").hasAnyRole("ADMIN","USER");
  super.configure(http);
    }
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//    http.csrf().disable()
//            .authorizeRequests()
//            .antMatchers("/api/users/addUserByAdmin").hasRole("ADMIN") // Allow only ADMIN role
//            .antMatchers("/api/users/login").permitAll() // Allow all users
//            .anyRequest().authenticated() // All other requests require authentication
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            .permitAll();
//}
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userPasswordService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}