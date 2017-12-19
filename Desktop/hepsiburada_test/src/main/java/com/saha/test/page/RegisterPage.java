package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public BasePage register() throws InterruptedException {

        sendKey(By.id("firstname"), FIRST_NAME);
        sendKey(By.id("lastname"), LAST_NAME);
        sendKey(By.id("email-register"), randomEmail());
        sendKey(By.id("password-register"), PASSWORD_REGISTER);
        sendKey(By.id("password-repeat"), PASSWORD_REGISTER);
        clickByCss("[for=\"subscribe-email\"]");  // email ile bilgilendirme seçimi
        clickByXpath("//*[@id=\"form-user\"]/div[6]/button");
        setWait(3);
        Assert.assertTrue("Giriş yapılamadı!!", getElement(By.xpath("//*[@id=\"myAccount\"]/a[1]")).getText().contains("Hesabım"));

        return  new BasePage(driver);
    }
}
