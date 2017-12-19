package com.saha.test.base;

import com.saha.test.Constant.Constants;
import com.saha.test.page.*;
import com.saha.test.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage extends BasePageUtil implements Constants{

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage callLoginPage() throws InterruptedException {

        popUpClose();
        mouseMove(By.id("myAccount"));
        clickById("login");
        setWait(1);
        Assert.assertTrue("Sayfa yüklenemedi!!", isElementPresent(driver, By.xpath("//*[@id=\"form-login\"]/div[4]/button")));
        return new LoginPage(driver);
    }

    public RegisterPage callRegisterPage() throws InterruptedException {

        popUpClose();
        mouseMove(By.id("myAccount"));
        clickByLinkText("Üye Ol");
        setWait(3);
        Assert.assertTrue("Sayfa yüklenemedi!!", isElementPresent(driver, By.xpath("//*[@id=\"form-user\"]/div[6]/button")));
        return new RegisterPage(driver);
    }

    public ElectronicPage selectElectronicMenu() throws InterruptedException {

        callLoginPage().login();
        mouseMove(getElement(By.id("elektronik"))); // Elektronik menüsü
        setWait(1);
        mouseMove(getElement(By.xpath("//*[@id=\"elektronik\"]/div/div/div/div[1]/ul/li[1]/a"))); // Bilgisayar
        setWait(1);
        clickByXpath("//li[@id='elektronik']//ul[@class='nav-home']/li[1]/ul/ul[2]/li[3]/a[@href='/cevre-birimleri-c-3013120']"); // Çevre birimleri seçimi
        Assert.assertTrue("Sayfa yüklenemedi!!", getElement(By.id("breadcrumbFor-3013120")).getText().contains("Çevre Birimleri"));
        return  new ElectronicPage(driver);
    }

    public BasketPage researchProductForMouse() throws InterruptedException {

        callLoginPage().login();
        sendKey(By.id("productSearch"), MOUSE_PRODUCT_CODE);
        clickById("buttonProductSearch");
        Assert.assertTrue("Sayfa yüklenemedi!!", find(By.className("search-results-title")).getText().contains(MOUSE_PRODUCT_CODE));
        return new BasketPage(driver);
    }

    public BasketPage researchProductForIPhone() throws InterruptedException {

        callLoginPage().login();

            if (isElementPresent(driver,By.xpath("/html/body/div[@class='insider-opt-in-notification']//div[.='Daha sonra']"))){
                popUpClose();
            }

        sendKey(By.id("productSearch"), IPHONE_PRODUCT_CODE);
        clickByClassName("rfk_image");

            if (isElementPresent(driver, By.id("ins-notification"))) {
                clickById("ins-submit");
            }

        Assert.assertTrue("Ürün seçilemedi!!", driver.getCurrentUrl().contains(IPHONE_PRODUCT_CODE));
        return new BasketPage(driver);
    }

    public ProductPage researchProductForShoes() throws InterruptedException {

        callLoginPage().login();
        sendKey(By.id("productSearch"), SEARCH_KEY_FOR_SHOES);
        clickById("buttonProductSearch");
        Assert.assertTrue("Sayfa yüklenemedi!!", driver.getCurrentUrl().contains("ayakkabi"));
        return new ProductPage(driver);
    }

    public void clearTheBasket() {
        new BasketPage(driver).clickByCss(".btn-delete");
    }


}
