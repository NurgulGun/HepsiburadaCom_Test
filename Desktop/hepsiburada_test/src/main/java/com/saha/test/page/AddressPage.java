package com.saha.test.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasketPage{

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage registerAddress() throws InterruptedException {

        if (isElementPresent(driver, By.className("col delivery-addresses"))) {
            sendKey(By.id("first-name"), FIRST_NAME);
            sendKey(By.id("last-name"), LAST_NAME);
            sendKey(By.id("country"), COUNTRY);
            sendKey(By.id("city"), CITY);
            sendKey(By.id("town"), TOWN);
            sendKey(By.id("district"), DISTRICT);
            sendKey(By.id("address"), ADDRESS);
            sendKey(By.id("address-name"), ADDRESS_NAME);
            sendKey(By.id("zip-code"), ZIP_CODE);
            sendKey(By.id("phone"), PHONE_NUMBER);
        }

        clickByClassName("proceed-container");
        setWait(3);
        Assert.assertTrue("Adres kayıt işlemi başarısız!!", driver.getCurrentUrl().contains("https://www.hepsiburada.com/ayagina-gelsin/odeme"));
        return new PaymentPage(driver);
    }
}
