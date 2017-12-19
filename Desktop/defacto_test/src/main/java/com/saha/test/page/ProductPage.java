package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage filteringForShirtSColour() throws InterruptedException {
        scrollPage(500);
        clickByCss("#facetAccordion > div:nth-child(5) > div.panel-heading > div > a"); // Renk listesi
        setWait(2);
        clickByPartialLinkText("Çivit Mavisi"); // Renk seçimi
        Assert.assertTrue("Renk(çivit mavisi) seçimi başarısız!!", find(By.cssSelector("#fixed > div.boutique-list > div.row > div.col-lg-9.col-md-9.col-sm-9.m-t-5 > div.col-lg-12.no-padding.hidden-xs > h1")).getText().contains("Çivit Mavisi"));
        scrollPage(350);
        clickByPartialLinkText("Gri"); // Renk seçimi
        Assert.assertTrue("Renk(gri) seçimi başarısız!!", isElementPresent(driver, By.xpath("//*[@id=\"tab_default_1\"]/div[5]/div[2]/gt")));
        return new ProductPage(driver);
    }

    public ProductPage secondPageAndProductSelect() {
        clickByCss("#CatalogFacetTabs > li.pull-right.col-xs-6.p-0.p-b-10.hidden-xs > ul > li:nth-child(4) > a");  // 2. sayfaya geçiş
        Assert.assertTrue("2. sayfaya geçilemedi!!", driver.getCurrentUrl().contains("page=2"));
        clickByXpath("//*[@id=\"fixed\"]/div[4]/div[1]/div[3]/div[3]/div[2]/div[2]/div/div[1]/div[2]/div/a/span[4]/img"); // Ürün seçimi
        Assert.assertTrue("Ürün seçimi başarısız!!", isElementPresent(driver, By.id("addToCart")));
        return new ProductPage(driver);
    }

    public ProductPage selectNumberOfProduct() {
        clickByXpath("//*[@id=\"Quantity\"]/option[2]");
        Assert.assertTrue("Ürün sayısı girilemedi!!", find(By.id("Quantity")).getText().contains("2"));
        return new ProductPage(driver);
    }

    public ProductPage addBasket() {
        clickByXpath("//*[@id=\"fixed\"]/div[5]/div/div/div[2]/div[7]/div/div[1]/div/ul/li[2]");
        clickById("addToCart");
        return new ProductPage(driver);
    }

    public BasketPage goToBasket() {
        clickById("popupBasket_ComplateShopping");
        Assert.assertTrue("Sepete gidilemedi!!", find(By.className("current")).getText().contains("Sepet"));
        return new BasketPage(driver);
    }
}

