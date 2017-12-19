package com.saha.test.test;

import com.saha.test.base.BasePage;
import com.saha.test.base.BaseTest;
import org.junit.Test;

import java.awt.*;

public class PaymentTest extends BaseTest {

    @Test
    public void paymentTestForIPhone() throws AWTException, InterruptedException {

        //Ürün kodu ile arama yapıp, ödeme aşamalarını tamamlama . . .

        new BasePage(driver).researchProductForIPhone().addBasketForIPhone().registerAddress().editCreditCard();
    }
}
