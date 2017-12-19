package com.saha.test.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class BasePageUtil {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By by) {
        return driver.findElement(by);
    }

    protected void click(By by) {
        getElement(by).click();
    }

    protected void clickById(String id) {
        getElement(By.id(id)).click();
    }

    public void clickByCss(String css) {
        getElement(By.cssSelector(css)).click();
    }

    protected void clickByClassName(String className) {
        getElement(By.className(className)).click();
    }

    protected void clickByXpath(String xpath) {
        getElement(By.xpath(xpath)).click();
    }

    protected void clickByLinkText(String linkText) {
        getElement(By.linkText(linkText)).click();
    }

    protected void clickByPartialLinkText(String PLinkText) {
        getElement(By.partialLinkText(PLinkText)).click();
    }

    protected void sendKey(By by, String word) {
        getElement(by).sendKeys(word);
    }

    protected void setWait(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);

    }

    protected void popUpClose() throws InterruptedException {
        setWait(1);
        clickByXpath("/html/body/div[@class='insider-opt-in-notification']//div[.='Daha sonra']");
    }


    protected void mouseMove(By by)  {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(by);
        builder.moveToElement(element).build().perform();
    }

    protected void mouseMove(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getElement(By by) {
        WebElement webElement = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.visibilityOfElementLocated(by));

        return webElement;
    }

    protected static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    protected void scrollPage(int y) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("scroll(0,"+y+")");
        setWait(1);
    }

    protected void clearProductNumber(){
        find(By.id("quantity")).clear();
    }

    protected void selectByVisibleText(By by, String text) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(text);
    }

    protected void selectByIndex(By by, String index) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(index);
    }

    protected void selectByValue(By by, String value) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(value);
    }

}
