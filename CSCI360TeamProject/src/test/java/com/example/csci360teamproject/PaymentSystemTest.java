package com.example.csci360teamproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentSystemTest {
    PaymentInfo info = new PaymentInfo("5314507896735572", "2/27", "925", "29464");
    @Test
    void checkPaymentTest() {
        Assertions.assertTrue(PaymentSystem.checkPayment(info));
        info.cvv = "ABC";
        Assertions.assertFalse(PaymentSystem.checkPayment(info));
        info.cvv = "925";
        info.cardNum = "5314507896735573";
        Assertions.assertFalse(PaymentSystem.checkPayment(info));
        info.cardNum = "12";
        Assertions.assertFalse(PaymentSystem.checkPayment(info));
        info.cardNum = "ABCD";
        Assertions.assertFalse(PaymentSystem.checkPayment(info));
        info.cardNum = "5314507896735572";
        info.expDate = "CoolDate";
        Assertions.assertFalse(PaymentSystem.checkPayment(info));
        info.expDate = "13/22";
        Assertions.assertFalse(PaymentSystem.checkPayment(info));
        info.expDate = "1/21";
        Assertions.assertFalse(PaymentSystem.checkPayment(info));

    }
}
