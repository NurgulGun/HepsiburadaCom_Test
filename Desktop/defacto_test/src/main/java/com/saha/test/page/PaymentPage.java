package com.saha.test.page;

import com.saha.test.Constant.GeneralConstant;
import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void editCreditCard() throws InterruptedException {
        scrollPage(100);
        sendKey(By.id("Payment_CardNumber1"), CREDIT_CARD_NUMBER);
        clickByXpath("//*[@id=\"Payment_ExpireMonth\"]/option[2]"); // Ay
        clickByXpath("//*[@id=\"Payment_ExpireYear\"]/option[3]");  // Yıl
        sendKey(By.id("Payment_SecurityCode"), CARD_CVV);
        Assert.assertTrue("Sipariş onaylamaya hazır değil !", isElementPresent(driver, By.id("installment")));

    }
}
