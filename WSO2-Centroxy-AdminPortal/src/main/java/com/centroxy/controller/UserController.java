package com.centroxy.controller;

import com.centroxy.dto.LoginRequest;
import com.centroxy.dto.UserRequest;
import com.centroxy.entity.User;
import com.centroxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/login")
    public String login(){
          return "login";
    }

//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
//        try {
//            User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
//            if (user != null) {
//                return ResponseEntity.ok(user);
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//            }
//        } catch (HttpMessageNotReadableException ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }



    @PostMapping("/addUserByAdmin")
    public ResponseEntity<User> addUser(@RequestParam("userName") String userName,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                        @RequestParam("country") String country,
                                        @RequestParam("email") String email,
                                        @RequestParam("mobile") String mobile,
                                        @RequestParam("password") String password,
                                        @RequestParam("role") String role,
                                        @RequestParam("groupId") Long groupId,
                                        @RequestParam("image") MultipartFile image) {

        // Check if the current user has ADMIN role
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));

        if (isAdmin) {
            try {
                User savedUser = userService.addUser(userName, firstName, lastName,
                        country, email, mobile, password, role, groupId, image);
                return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            // Return 403 Forbidden if the user is not an admin
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


    @PostMapping("/add/user")
    public String saveUser(@RequestBody User user){

        return  userService.saveUser(user);
    }

    }



