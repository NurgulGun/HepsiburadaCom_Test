package com.saha.test.base;

import com.saha.test.page.BasketPage;
import com.saha.test.util.BasePageUtil;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest{

    protected WebDriver driver;
    private static String URL = "http://www.hepsiburada.com";

    @Before
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver1.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        Thread.sleep(5);
    }

    /*@After
    public void clearTheBasket(){
        new BasketPage(driver).getElement(By.cssSelector(".btn-delete")).click();
    }*/

    @After
    public void quit() {
        //driver.quit();

    }


}
