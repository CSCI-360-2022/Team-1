package com.example.csci360teamproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {
    User newUser = new User("CoolGuy25", "password", "coolguy25@yahoo.com");

    @Test
    void getUsername() {
        assertEquals(newUser.getUsername(), "CoolGuy25");
        assertNotEquals(newUser.getUsername(), null);
        assertNotEquals(newUser.getUsername(), "CoolGuy24");
    }

    @Test
    void getEmail() {
        assertEquals(newUser.getEmail(), "coolguy25@yahoo.com");
        assertNotEquals(newUser.getEmail(), null);
        assertNotEquals(newUser.getEmail(), "coolguy25@gmail.com");
    }

    @Test
    void getPassword() {
        assertEquals(newUser.getPassword(), "password");
        assertNotEquals(newUser.getPassword(), null);
        assertNotEquals(newUser.getPassword(), "Password");
    }

    @Test
    void setUserID() {
        int oldId = newUser.getUserID();
        newUser.setUserID(1);
        assertEquals(newUser.getUserID(), 1);
        assertNotEquals(newUser.getUserID(), oldId);
    }

    @Test
    void setUsername() {
        String oldUsername = newUser.getUsername();
        newUser.setUsername("CoolestGuy");
        assertEquals(newUser.getUsername(), "CoolestGuy");
        assertNotEquals(newUser.getUsername(), null);
        assertNotEquals(newUser.getUsername(), oldUsername);
    }

    @Test
    void setEmail() {
        String oldEmail = newUser.getEmail();
        newUser.setEmail("CoolestGuy@gmail.com");
        assertEquals(newUser.getEmail(), "CoolestGuy@gmail.com");
        assertNotEquals(newUser.getEmail(), null);
        assertNotEquals(newUser.getEmail(), oldEmail);
    }

    @Test
    void setPassword() {
        String oldPassword = newUser.getPassword();
        newUser.setPassword("iAm50v3ry_C00L");
        assertEquals(newUser.getPassword(), "iAm50v3ry_C00L");
        assertNotEquals(newUser.getPassword(), null);
        assertNotEquals(newUser.getPassword(), oldPassword);
    }

    @Test
    void testEquals() {
       User equalsTestUser = new User("CoolGuy25", "password", "coolguy25@yahoo.com");
       assertEquals(newUser, equalsTestUser);
       equalsTestUser.setUsername("CoolGuy24");
       assertNotEquals(newUser, equalsTestUser);
    }
}