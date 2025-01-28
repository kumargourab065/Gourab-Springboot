package com.centroxy.service;

import com.centroxy.dto.UserRequest;
import com.centroxy.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

   //User addUser(UserRequest userRequest, MultipartFile image);

   // User login(String email, String password);

  String saveUser(User user);
    User addUser(String userName, String firstName, String lastName, String country, String email, String mobile, String password, String role, Long groupId, MultipartFile image);
}

