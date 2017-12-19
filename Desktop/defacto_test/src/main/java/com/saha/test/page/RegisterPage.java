package com.saha.test.page;

import com.saha.test.Constant.GeneralConstant;
import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public BasePage register() throws InterruptedException {
        sendKey(By.id("RegisterModel_CustomerFirstName"), FIRST_NAME);
        sendKey(By.id("RegisterModel_CustomerLastName"), LAST_NAME);
        sendKey(By.id("RegisterModel_CustomerEmail"), randomEmail());
        sendKey(By.id("RegisterModel_CustomerMobilePhone"), PHONE_NUMBER);
        clickByCss("#RegisterModel_CustomerBirthDateDay > option:nth-child(2)"); // Gün
        clickByCss("#RegisterModel_CustomerBirthDateMonth > option:nth-child(8)"); // Ay
        clickByCss("#RegisterModel_CustomerBirthDateYear > option:nth-child(9)"); // Yıl
        // Cinsiyet
        clickByCss("#RegisterForm > div.col-lg-8.col-md-8.col-sm-10.col-xs-12.no-padding-mobil > div > div.form-group.col-lg-3.col-md-3.col-sm-3 > select > option:nth-child(1)");
        sendKey(By.id("RegisterModel_CustomerPassword"), PASSWORD_REGISTER);
        sendKey(By.id("RegisterModel_CustomerPasswordConfirm"), PASSWORD_REGISTER);
        scrollPage(100);
        find(By.id("RegisterModel_CustomerIsSmsSubscriberAndIsSubscriber")).click(); // Onay
        find(By.id("RegisterModel_CustomerIsApprovedContract")).click(); // Sözleşme
        clickById("RegisterBtn"); // Kayıt butonu
        setWait(5);
        Assert.assertTrue("Kayıt işlemi başarısız!!", find(By.cssSelector("body > div.row-offcanvas.row-offcanvas-left > header > section > nav > div > div.collapse.navbar-collapse.navbar-top-collapse > div.btn-toolbar.pull-right.user-btns.col-lg-8.col-md-9.col-sm-8.col-xs-12 > div.pull-right.header-customer-menu.header-customer-menu-item.dropdown")).getText().contains("Hoşgeldiniz"));
        return new BasePage(driver);
    }

}
