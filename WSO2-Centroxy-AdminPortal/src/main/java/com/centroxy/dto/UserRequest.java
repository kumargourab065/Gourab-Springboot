package com.centroxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;
    private String firstName;
    private String lastName;
    private String country;
    private String email;
    private String mobile;
    private String password;
    private String role;
    private Long groupId;

}
