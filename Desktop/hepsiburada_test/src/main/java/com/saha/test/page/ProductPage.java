package com.saha.test.page;

import com.saha.test.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage filteringForShoes() throws InterruptedException {
        clickByPartialLinkText("Erkek");
        Assert.assertTrue("Erkek kategorisi seçilemedi!!", isElementPresent(driver, By.cssSelector("[href=\"\\/erkek-giyim-modelleri-c-12087177\"] [itemprop]")));
        clickByPartialLinkText("Erkek Ayakkabı");
        Assert.assertTrue("Erkek ayakkabı seçilemedi!!", isElementPresent(driver, By.cssSelector("[href=\"\\/ayakkabi-c-60000117\"] [itemprop]")));
        clickByPartialLinkText("Günlük Ayakkabı");
        Assert.assertTrue("Günlük ayakkabı seçilemedi!!", isElementPresent(driver, By.cssSelector("[href=\"\\/erkek-gunluk-ayakkabilar-c-60000126\"] [itemprop]")));

        scrollPage(400);
        clickByCss("[for=\"attr-fiyat-250-500\"]");
        Assert.assertTrue("Fiyat aralığı seçilemedi!!", getElement(By.cssSelector(".appliedFilter > span:nth-child(2)")).getText().contains("250"));

        scrollPage(1500);
        clickByCss("[for=\"attr-satici-Hepsiburada\"]");
        Assert.assertTrue("Satıcı seçilemedi!!", getElement(By.cssSelector(".applied-filter-container ul > .appliedFilter:nth-child(2) > span:nth-child(2)")).getText().contains("Hepsiburada"));

        clickByCss("[for=\"brand-voileblanche\"]");
        Assert.assertTrue("Marka seçilemedi!!", getElement(By.cssSelector(".applied-filter-container ul > .appliedFilter:nth-child(1) > span:nth-child(2)")).getText().contains("Voile Blanche"));

        scrollPage(1000);
        clickByCss("[for=\"attr-numara-44\"]");
        Assert.assertTrue("Numara seçilemedi!!", getElement(By.cssSelector(".applied-filter-container ul > .appliedFilter:nth-child(4) > span:nth-child(2)")).getText().contains("44"));

        scrollPage(500);
        clickByCss("[for=\"attr-renk-Kahverengi\"]");
        Assert.assertTrue("Renk seçilemedi!!", getElement(By.cssSelector(".applied-filter-container ul > .appliedFilter:nth-child(5) > span:nth-child(2)")).getText().contains("Kahverengi"));

        return new BasketPage(driver);
    }
}
