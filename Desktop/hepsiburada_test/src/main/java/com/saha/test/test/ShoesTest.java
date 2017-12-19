package com.saha.test.test;

import com.saha.test.base.BasePage;
import com.saha.test.base.BaseTest;
import org.junit.Test;

import java.awt.*;

public class ShoesTest extends BaseTest {

    @Test
    public void shoesTest() throws AWTException, InterruptedException {
        new BasePage(driver).researchProductForShoes().filteringForShoes().addBasketForShoes();
    }
}
