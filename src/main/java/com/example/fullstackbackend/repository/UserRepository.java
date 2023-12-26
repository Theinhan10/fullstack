package com.example.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fullstackbackend.model.User;


/*
 * Repositories provide methods for querying and managing data in the database, and 
 * they abstract the details of the underlying data store.
 */

//JpaRepository<User, Long>:
//JpaRepository is an interface provided by Spring Data JPA that includes CRUD (Create, Read, Update, Delete) methods for working with entities.
//User is the type of entity managed by this repository. The repository provides methods to perform database operations on User entities.
//Long is the type of the primary key of the User entity.
public interface UserRepository extends JpaRepository<User, Long> {
    
}
