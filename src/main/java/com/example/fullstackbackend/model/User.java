package com.example.fullstackbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//entity antonation will auto genrate user table in database once we connect spring boot with mysql database
@Entity 
public class User {

    @Id //marks the id field as the primary key of the User entity. *remember to put it at top of variable
    @GeneratedValue //indicates that the value for the primary key (id) will be automatically generated.
    private Long id;

    private String username;
    private String email;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



}
