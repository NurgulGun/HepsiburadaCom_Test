package com.saha.test.page;

import com.saha.test.Constant.GeneralConstant;
import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage{

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public AddressPage addressRegister() throws InterruptedException {
        clickByXpath("//*[@id=\"Address_AddressTypeId\"]/option[2]");  // Adres tipi
        clickByXpath("//*[@id=\"Address_AddressCityId\"]/option[2]");  // Sehir
        clickByXpath("//*[@id=\"Address_AddressCountyId\"]/option[4]");// Ilce
        sendKey(By.id("Address_AddressPostalCode"), ZIP_CODE);
        sendKey(By.id("Address_AddressText"), ADDRESS);
        scrollPage(600);
        sendKey(By.id("Address_AddressFirstName"), FIRST_NAME);
        sendKey(By.id("Address_AddressLastName"), LAST_NAME);
        sendKey(By.id("Address_AddressMobilePhone"), PHONE_NUMBER);
        sendKey(By.id("Address_AddressIdentityNumber"), TC_NUMBER);
        find(By.className("button-loading-submit-content")).click();  // Kaydet
        setWait(13);
        Assert.assertTrue("Adres kaydedilemedi!!", isElementPresent(driver, By.name("ShippingAddress")));
        return new AddressPage(driver);
    }
    public PaymentPage continueForPayment() throws InterruptedException {
        find(By.name("ClickCollectID")).click();
        setWait(3);
        Assert.assertTrue("Ödeme sayfasına geçiş başarısız!!", find(By.className("current")).getText().contains("Ödeme"));
        return new PaymentPage(driver);
    }
}
