package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void editCreditCard() throws InterruptedException {
        scrollPage(100);
        sendKey(By.id("card-no"), CREDIT_CARD_NUMBER);
        sendKey(By.id("holder-Name"), HOLDER_NAME);
        clickByCss(".controls:nth-of-type(1) .filter-option");    // Ay
        clickByCss(".controls:nth-of-type(1) [rel=\"1\"] .text"); // seçimi
        clickByCss(".controls:nth-of-type(2) .filter-option");                 // Yıl
        clickByCss(".controls:nth-of-type(2) [rel=\"2\"] .text");              // seçimi
        sendKey(By.id("cvc"), CARD_CVV);
        clickByCss(".proceed-container .full:nth-of-type(1) .text"); //
        setWait(3);
        Assert.assertTrue("Kart bilgi girişi başarısız!!", driver.getCurrentUrl().contains("siparis-ozeti"));

    }
}
