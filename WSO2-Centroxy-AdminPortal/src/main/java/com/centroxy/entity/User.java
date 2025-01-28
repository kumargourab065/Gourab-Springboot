package com.centroxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String country;
    private String email;
    private String mobile;
    private String password;
    private byte[] image;
    // private MultipartFile data;


    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groups;


    public enum Role {
        ADMIN, USER
    }


}
