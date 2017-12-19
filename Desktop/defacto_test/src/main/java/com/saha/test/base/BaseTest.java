package com.saha.test.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;
    public static String URL = "https://www.defacto.com.tr/";

    @Before
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver1.exe");
        driver = new ChromeDriver(options);
        driver.get(URL);
        Thread.sleep(5);
    }

    @After
    public void quit() {
        //driver.quit();
    }
}
