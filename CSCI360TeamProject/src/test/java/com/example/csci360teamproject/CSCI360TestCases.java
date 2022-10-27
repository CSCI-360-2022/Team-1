package com.example.csci360teamproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CSCI360TestCases {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void addNewUser() {
        User user = new User();
        user.setEmail("bob@example.com");
        user.setUsername("bobIsCool");
        user.setPassword("bobertBoberlyCool");
        userRepository.save(user);
        assertEquals(userRepository.findByUsername("bobIsCool"), user);
        userRepository.deleteUserByUsername("bobIsCool");
    }
}
