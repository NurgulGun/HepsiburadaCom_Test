package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public BasePage login() throws InterruptedException {
        sendKey(By.id("email"), EMAIL);
        sendKey(By.id("password"), PASSWORD);
        clickByXpath("//*[@id=\"form-login\"]/div[4]/button");
        setWait(3);
        Assert.assertTrue("Giriş yapılamadı!!", getElement(By.xpath("//*[@id=\"myAccount\"]/a[1]")).getText().contains("Hesabım"));

        return new BasePage(driver);
    }
}
