package com.example.csci360teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

@SpringBootTest
public class ReceiptTest {
    @Autowired
    Service csci360TeamProjectService;
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
}
