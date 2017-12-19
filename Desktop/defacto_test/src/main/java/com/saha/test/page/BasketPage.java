package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public AddressPage continueForAddressPage() throws InterruptedException {
        clickById("ComplateShoppingDown");
        setWait(2);
        Assert.assertTrue("Adres sayfasına geçiş başarısız!!", find(By.className("current")).getText().contains("Adres"));
        return new AddressPage(driver);
    }
}
