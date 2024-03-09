package com.easepass.easepass; //(check controller.java pade to confirm its correct)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    public String username;
    public String password;
    public String usertype;
    public String phonenumber;
    public String identitynumber;
    public String status;

    public User() {}

    public User(String username, String phonenumber, String password, String usertype, String identitynumber, String status) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.phonenumber = phonenumber;
        this.identitynumber = identitynumber;
        this.status = status;
    }

}