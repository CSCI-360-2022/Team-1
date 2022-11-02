package com.example.csci360teamproject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.*;

@SpringBootTest
public class CSCI360Tests {
    @Test
    public void createReceipt() {
        Receipt receipt = new Receipt();
        assertNotNull(receipt);
        assertEquals(0, receipt.getPaymentTotal(), 0.0);
        LocalDate now = LocalDate.now();
        Receipt receipt1 = new Receipt(20, 13, 39, now, 12309432);
        assertEquals(20, receipt1.getPaymentTotal(), 0.0);
        assertNotEquals(15, receipt1.getPaymentTotal(), 0.0);
        assertEquals(13, receipt1.getEventId());
        assertNotEquals(19, receipt1.getEventId());
        assertEquals(39, receipt1.getCustomerId());
        assertNotEquals(1, receipt1.getCustomerId());
        assertEquals(receipt1.getDate(), now);
        assertNotEquals(receipt1.getDate(), LocalDate.now());
        assertEquals(12309432, receipt1.getTransactionId());
        assertNotEquals(12309422, receipt1.getTransactionId());
    }

    @Test
    public void setRecieptTest() {
        LocalDate now = LocalDate.now();
        Receipt receipt1 = new Receipt(20, 13, 39, now, 12309432);
        receipt1.setPaymentTotal(30);
        receipt1.setEventId(20);
        receipt1.setCustomerId(19);
        receipt1.setDate(now.plusMonths(1));
        receipt1.setTransactionId(3248958);
        assertEquals(30, receipt1.getPaymentTotal(), 0.0);
        assertNotEquals(20, receipt1.getPaymentTotal(), 0.0);
        assertEquals(20, receipt1.getEventId());
        assertNotEquals(13, receipt1.getCustomerId());
        assertEquals(19, receipt1.getCustomerId());
        assertNotEquals(39, receipt1.getCustomerId());
        assertEquals(receipt1.getDate(), now.plusMonths(1));
        assertNotEquals(receipt1.getDate(), now);
        assertEquals(3248958, receipt1.getTransactionId());
        assertNotEquals(12309432, receipt1.getTransactionId());
    }

    @Test
    public void buildRecieptTest() {

    }
//    @Test
//    public void testPayementTotal() {
//        Receipt receipt = new Receipt();
//        assertTrue(receipt.getPaymentTotal() == 0 );
//    }
    @Test
    public void logInTest() {
        GuiController gui = new GuiController();
        assertTrue(gui.confirmLogin("Brooke", "helloWorld"));
        assertFalse(gui.confirmLogin("yeaMan69", "aVeryBadPassword"));
    }

    @Test
    public void hashFunctionTest() {
        //String passwordHash(String password) in GuiController
        GuiController gui = new GuiController();
        assertEquals("2e99758548972a8e8822ad47fa1017ff72f06f3ff6a016851f45c398732bc50c", gui.passwordHash("this is a test"));
        assertNotEquals("", gui.passwordHash("this is a test"));
        assertNotEquals("this is a test", gui.passwordHash("this is a test"));
        assertEquals("b8c8b9cba172641105a24acb50dc08c2af5dba5f077aac3e0508d95b281d269e", gui.passwordHash("reghjrenvkjercgjkggmnjrtwlxfghjkxhvfamxhkbjfl"));
        assertEquals("31535f30b66aefbad771bddc267325e70d9ac33b909924cbd8cacebc3df00e22", gui.passwordHash("t415 I5 A C00l pA55w0rd"));
        assertEquals("d87bfbe8f5dceda0dd34eb872e47bd46eb7adb957f81d029154cb05d65164142", gui.passwordHash("8e5T p@ss0rd 3v3R 0_0"));
        assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", gui.passwordHash("password"));
        assertEquals("95f82d7b761cd80c7a75ffc9b30a535bad667a3115bd751aa2db2e95ab92214f", gui.passwordHash("testingIsAnImportantPartofAnyCodingProject"));
        assertEquals("35e43dcf32c99b601158de7dae315a8939894ea45d6daa5dd1c31154e77c8805", gui.passwordHash("According to all known laws of aviation, there is no way that a bee should be able to fly. Its wings are too small to get its fat little body off the ground. The bee, of course, flies anyway. Because bees don’t care what humans think is impossible."));

    }
}
