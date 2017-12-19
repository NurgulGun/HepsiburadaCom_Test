package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void addBasketForMouse() {
        clickByCss("[data-index=\"1\"] .product");
        clearProductNumber();
        sendKey(By.id("quantity"), NUMBER_OF_MOUSE);
        clickById("addToCart");
        Assert.assertTrue("Ürün seçiminde hata oluştu!!", getElement(By.cssSelector(".free-shipping .text")).getText().contains("Kargo Bedava"));
        clearTheBasket();

    }

    public AddressPage addBasketForIPhone() throws InterruptedException {

        clickById("addToCart");
        Assert.assertTrue("Sepete ekleme sırasında hata oluştu!!", getElement(By.cssSelector(".free-shipping .text")).getText().contains("Kargo Bedava"));
        clickByCss(".btn-primary");
        setWait(3);
        Assert.assertTrue("Teslimat sayfasına erişim başarısız!!", driver.getCurrentUrl().contains("teslimat"));
        return new AddressPage(driver);
    }

    public void addBasketForShoes() {
        clickByCss("[data-index=\"1\"] .product");
        Assert.assertTrue("Ürün seçilemedi!!", isElementPresent(driver, By.className("addToCartButton")));
        clickById("addToCart");
        Assert.assertTrue("Ürün seçiminde hata oluştu!!", getElement(By.cssSelector(".free-shipping .text")).getText().contains("Kargo Bedava"));

    }
}
