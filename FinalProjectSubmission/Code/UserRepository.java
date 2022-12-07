package com.example.csci360teamproject;

import org.springframework.data.repository.CrudRepository;

//Class that is used to actually do something to the database
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserID(int userID);
    User findByUsername(String username);
    User deleteUserByUsername(String username);
}
