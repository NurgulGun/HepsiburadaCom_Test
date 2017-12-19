package com.saha.test.test;

import com.saha.test.base.BasePage;
import com.saha.test.base.BaseTest;
import org.junit.Test;

import java.awt.*;

public class BasketTest extends BaseTest {

    @Test
    public void checkBasketForMouse() throws AWTException, InterruptedException {

        // Ürün kodu ile arama yapıp, bulunan ürünü(+3) sepete ekleme . . .

        new BasePage(driver).researchProductForMouse().addBasketForMouse();
    }
}
