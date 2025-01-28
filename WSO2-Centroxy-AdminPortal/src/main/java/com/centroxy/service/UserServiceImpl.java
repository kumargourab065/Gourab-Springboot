
package com.centroxy.service;
import com.centroxy.dto.UserRequest;
import com.centroxy.entity.Group;
import com.centroxy.entity.User;
import com.centroxy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GroupService groupService;


    /**
     * @param user
     * @return
     */
    @Override
    public String saveUser(User user) {
       userRepository.save(user);
       return "user save sucessfully";
    }

    @Override
    public User addUser(String userName, String firstName, String lastName,
                        String country, String email, String mobile, String password,
                        String role, Long groupId, MultipartFile image) {
        try {
            User user = new User();
            user.setUsername(userName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setCountry(country);
            user.setEmail(email);
            user.setMobile(mobile);
            user.setPassword(passwordEncoder.encode(password)); // Encode the password
            user.setImage(image.getBytes());

            // Retrieve the group by ID
            Group group = groupService.getGroupById(groupId);
            user.setGroups(group);

            // Set the role
            user.setRole(User.Role.valueOf(role.toUpperCase()));

            // Save the user
            return userRepository.save(user);
        } catch (Exception e) {
            // Handle exceptions or rethrow as necessary
            throw new RuntimeException("Error adding user", e);
        }
    }
//    @Override
//    public User login(String email, String password) {
//        User user = userRepository.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//        return null;
//    }
//    @Override
//    public User addUser(UserRequest userRequest, MultipartFile image) {
//        try {
//            User user = new User();
//            user.setUserName(userRequest.getUserName());
//            user.setFirstName(userRequest.getFirstName());
//            user.setLastName(userRequest.getLastName());
//            user.setCountry(userRequest.getCountry());
//            user.setEmail(userRequest.getEmail());
//            user.setMobile(userRequest.getMobile());
//            user.setPassword(passwordEncoder.encode(userRequest.getPassword())); // Encode the password
//            user.setImage(image.getBytes());
//
//            // Retrieve the group by ID
//            Group group = groupService.getGroupById(userRequest.getGroupId());
//            user.setGroup(group);
//
//            // Set the role
//            user.setRole(User.Role.valueOf(userRequest.getRole().toUpperCase()));
//
//            // Save the user
//            return userRepository.save(user);
//        } catch (Exception e) {
//            // Handle exceptions or rethrow as necessary
//            throw new RuntimeException("Error adding user", e);
//        }
//    }




}
