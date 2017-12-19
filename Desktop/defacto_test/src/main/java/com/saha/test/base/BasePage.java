package com.saha.test.base;

import com.saha.test.Constant.GeneralConstant;
import com.saha.test.page.ProductPage;
import com.saha.test.page.RegisterPage;
import com.saha.test.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends BasePageUtil implements GeneralConstant{

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage callRegisterPage() throws InterruptedException {
        setWait(3);
        clickByPartialLinkText("Yeni Üye");
        Assert.assertTrue("Kayıt sayfasına erişilemedi!!", driver.getCurrentUrl().contains("Register"));

        return new RegisterPage(driver);
    }

    public ProductPage selectCategory() throws InterruptedException {
        mouseMove(getElement(By.partialLinkText("ERKEK")));
        setWait(3);

        //Gömlek
        clickByCss("#navbar-collapse-grid > ul:nth-child(1) > li:nth-child(2) > ul > li > div > div:nth-child(1) > ul > li:nth-child(4) > a");

        setWait(1);
        Assert.assertTrue("Kategori seçilemedi!!", find(By.cssSelector("#fixed > div.page-root-nav > ol > li:nth-child(4) > span")).getText().contains("Gömlek"));
        return new ProductPage(driver);
    }
}
