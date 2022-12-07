package com.example.csci360teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class Csci360TeamProjectApplicationTests {
    @Test
    void contextLoads() {
    }

    @Autowired
    private Service csci360TeamProjectService;
    @Autowired
    private System system;

    //    @Test
//    public void testPayementTotal() {
//        Receipt receipt = new Receipt();
//        assertTrue(receipt.getPaymentTotal() == 0 );
//    }
    @Test
    public void logInTest() {
        System gui = new System();
        Assertions.assertTrue(gui.confirmLogin("Brooke", "helloWorld", csci360TeamProjectService));
        assertFalse(gui.confirmLogin("yeaMan69", "aVeryBadPassword", csci360TeamProjectService));
    }

    @Test
    public void hashFunctionTest() {
        //String passwordHash(String password) in GuiController
        System gui = new System();
        Assertions.assertEquals("2e99758548972a8e8822ad47fa1017ff72f06f3ff6a016851f45c398732bc50c", gui.passwordHash("this is a test"));
        Assertions.assertNotEquals("", gui.passwordHash("this is a test"));
        Assertions.assertNotEquals("this is a test", gui.passwordHash("this is a test"));
        Assertions.assertEquals("1d0cf815e4bd4d034215ad23a594d61cb755dd59859885484def1cfe4dc6738e", gui.passwordHash("reghjrenvkjercgjkggmnjrtwlxfghjkxhvfamxhkbjfl"));
        Assertions.assertEquals("31535f30b66aefbad771bddc267325e70d9ac33b909924cbd8cacebc3df00e22", gui.passwordHash("t415 I5 A C00l pA55w0rd"));
        Assertions.assertEquals("d87bfbe8f5dceda0dd34eb872e47bd46eb7adb957f81d029154cb05d65164142", gui.passwordHash("8e5T p@ss0rd 3v3R 0_0"));
        Assertions.assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", gui.passwordHash("password"));
        Assertions.assertEquals("95f82d7b761cd80c7a75ffc9b30a535bad667a3115bd751aa2db2e95ab92214f", gui.passwordHash("testingIsAnImportantPartofAnyCodingProject"));
        Assertions.assertEquals("35e43dcf32c99b601158de7dae315a8939894ea45d6daa5dd1c31154e77c8805", gui.passwordHash("According to all known laws of aviation, there is no way that a bee should be able to fly. Its wings are too small to get its fat little body off the ground. The bee, of course, flies anyway. Because bees don’t care what humans think is impossible."));

    }


    @Test
    public void createUserTest() {
        //System gui = new System();
        User newUser = new User("CoolGuy25", system.passwordHash("aVery5curePa55word!"), "coolguy25@yahoo.com");
        User badUser = new User("CoolGuy25", "aVery5curePa55word!", "coolguy25@yahoo.com");
        system.createUser("coolguy25@yahoo.com", "CoolGuy25", "aVery5curePa55word!", null);
        User retrievedUser = csci360TeamProjectService.findUser("CoolGuy25");
        Assertions.assertEquals(newUser, retrievedUser);
        Assertions.assertNotEquals(badUser, retrievedUser);
        csci360TeamProjectService.deleteUserById(retrievedUser.getUserID());
    }

    //Not a unit test, but designed to see what sort of results the search gives back
    @Test
    public void searchEventTest() {
        List<Event> basketball = csci360TeamProjectService.findEvents("Basketball", new String[0]);
        String[] tags = new String[1];
        tags[0] = "Sports";
        List<Event> sports = csci360TeamProjectService.findEvents(null, tags);
    }


}


