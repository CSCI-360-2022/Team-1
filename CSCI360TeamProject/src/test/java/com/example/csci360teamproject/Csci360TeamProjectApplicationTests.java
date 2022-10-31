package com.example.csci360teamproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class Csci360TeamProjectApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    void createReceipt(){
        Receipt receipt = new Receipt();
        assertFalse(receipt == null);
    }

}


