package com.example.csci360teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class Csci360TeamProjectApplicationTests {
    @Test
    void contextLoads() {
    }

    @Autowired
    private CSCI360TeamProjectService csci360TeamProjectService;
    @Test
    public void createReceipt() {
        Receipt receipt = new Receipt();
        Assertions.assertNotNull(receipt);
        Assertions.assertEquals(0, receipt.getPaymentTotal(), 0.0);
        LocalDate now = LocalDate.now();
        long transactionId = 12309432;
        Receipt receipt1 = new Receipt(20, 13, 39, now, transactionId, csci360TeamProjectService);
        Assertions.assertEquals(20, receipt1.getPaymentTotal(), 0.0);
        Assertions.assertNotEquals(15, receipt1.getPaymentTotal(), 0.0);
        Assertions.assertEquals(13, receipt1.getEventId());
        Assertions.assertNotEquals(19, receipt1.getEventId());
        Assertions.assertEquals(39, receipt1.getCustomerId());
        Assertions.assertNotEquals(1, receipt1.getCustomerId());
        Assertions.assertEquals(receipt1.getDate(), now);
        Assertions.assertNotEquals(receipt1.getDate(), LocalDate.of(2022,11, 1));
        Assertions.assertEquals(12309432, receipt1.getTransactionId());
        Assertions.assertNotEquals(12309422, receipt1.getTransactionId());
    }

    @Test
    public void setReceiptTest() {
        LocalDate now = LocalDate.now();
        long transactionId = 12309432;
        Receipt receipt1 = new Receipt(20, 13, 39, now, transactionId, csci360TeamProjectService);
        receipt1.setPaymentTotal(30);
        receipt1.setEventId(20);
        receipt1.setCustomerId(19);
        receipt1.setDate(now.plusMonths(1));
        receipt1.setTransactionId(3248958);
        Assertions.assertEquals(30, receipt1.getPaymentTotal(), 0.0);
        Assertions.assertNotEquals(20, receipt1.getPaymentTotal(), 0.0);
        Assertions.assertEquals(20, receipt1.getEventId());
        Assertions.assertNotEquals(13, receipt1.getCustomerId());
        Assertions.assertEquals(19, receipt1.getCustomerId());
        Assertions.assertNotEquals(39, receipt1.getCustomerId());
        Assertions.assertEquals(receipt1.getDate(), now.plusMonths(1));
        Assertions.assertNotEquals(receipt1.getDate(), now);
        Assertions.assertEquals(3248958, receipt1.getTransactionId());
        Assertions.assertNotEquals(12309432, receipt1.getTransactionId());
    }

    @Test
    public void buildReceiptTest() throws IOException {
        Receipt newReceipt = new Receipt(67.23, 13, 21, LocalDate.of(2022, 11, 2), 435673461, csci360TeamProjectService);
        File file = new File("src/test/java/com/example/csci360teamproject/ExampleReceipt.txt");
        //Scanner scan = new Scanner(file);
        String fileText = Files.readString(Paths.get(file.toURI()));
        Assertions.assertEquals(newReceipt.buildReceipt(), fileText);
    }
    //    @Test
//    public void testPayementTotal() {
//        Receipt receipt = new Receipt();
//        assertTrue(receipt.getPaymentTotal() == 0 );
//    }
    @Test
    public void logInTest() {
        GuiController gui = new GuiController();
        Assertions.assertTrue(gui.confirmLogin("Brooke", "helloWorld"));
        assertFalse(gui.confirmLogin("yeaMan69", "aVeryBadPassword"));
    }

    @Test
    public void hashFunctionTest() throws NoSuchAlgorithmException {
        //String passwordHash(String password) in GuiController
        GuiController gui = new GuiController();
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
}


