package com.example.csci360teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
public class PaymentInfoTest {
    PaymentInfo info = new PaymentInfo("5314507896735572", "2/27", "925", "29464");
    @Test
    void getCardNum() {
        Assertions.assertEquals(info.getCardNum(), "5314507896735572");
        Assertions.assertNotEquals(info.getCardNum(), null);
        Assertions.assertNotEquals(info.getCardNum(), "5314507896735573");
    }

    @Test
    void getExpDate() {
        Assertions.assertEquals(info.getExpDate(), "2/27");
        Assertions.assertNotEquals(info.getExpDate(), null);
        Assertions.assertNotEquals(info.getExpDate(), "3/27");
    }

    @Test
    void getCvv() {
        Assertions.assertEquals(info.getCvv(), "925");
        Assertions.assertNotEquals(info.getCvv(), null);
        Assertions.assertNotEquals(info.getCvv(), "924");
    }

    @Test
    void getZipCode() {
        Assertions.assertEquals(info.getZipCode(), "29464");
        Assertions.assertNotEquals(info.getZipCode(), null);
        Assertions.assertNotEquals(info.getZipCode(), "39464");
    }
}
