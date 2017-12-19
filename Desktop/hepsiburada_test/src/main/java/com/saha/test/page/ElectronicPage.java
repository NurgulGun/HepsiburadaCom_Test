package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElectronicPage extends BasePage {

    public ElectronicPage(WebDriver driver) {
        super(driver);
    }

    public BasePage selectProduct() throws InterruptedException {

        clickByCss("[href=\"\\/mouse-c-52\"]");
        Assert.assertTrue("Sayfa yüklenemedi!!", isElementPresent(driver, By.id("breadcrumbFor-52")));

        for (int i = 2; i <= 7; i++){
            if (isElementPresent(driver, By.className("insider-opt-in-notification-title")))
                popUpClose();

            scrollPage(3600);
            clickByClassName("page-"+i);
            Assert.assertTrue("Bir sonraki sayfa görüntülenemedi "+i, driver.getCurrentUrl().contains("http://www.hepsiburada.com/mouse-c-52?sayfa="+i));

        }
        if (isElementPresent(driver, By.className("insider-opt-in-notification-title"))) {
            popUpClose();
        }
        clickByCss("[data-index=\"1\"] .product");
        Assert.assertTrue("Ürün seçilemedi!!", isElementPresent(driver, By.className("addToCartButton")));
        return new BasePage(driver);
    }
}
