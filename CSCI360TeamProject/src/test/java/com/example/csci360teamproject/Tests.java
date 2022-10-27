package com.example.csci360teamproject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class Tests {
    @Test
    public void createReceipt() {
        Receipt receipt = new Receipt();
        assertFalse(receipt == null);
        assertTrue(receipt.getPaymentTotal() == 0 );
        Receipt receipt1 = new Receipt(20);
        assertTrue(receipt1.getPaymentTotal() == 20);
        assertFalse(receipt1.getPaymentTotal()==15);
    }
//    @Test
//    public void testPayementTotal() {
//        Receipt receipt = new Receipt();
//        assertTrue(receipt.getPaymentTotal() == 0 );
//    }
    @Test
    public void logInTest() {
        GuiController gui = new GuiController();
        assertTrue(gui.confirmLogin("Brooke", "helloWorld") == true);
        assertTrue(gui.confirmLogin("yeaMan69", "aVeryBadPassword") == false);
    }

    @Test
    public void hashFunctionTest() {
        //int passwordHash(String password) in GuiController

    }
}
