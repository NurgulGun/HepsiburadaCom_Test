package com.saha.test.test;

import com.saha.test.base.BasePage;
import com.saha.test.base.BaseTest;
import org.junit.Test;

import java.awt.*;

public class ElectronicTest extends BaseTest {

    @Test
    public void selectProductTest() throws AWTException, InterruptedException {

        // Çevre birimlerinden mouse seçimi yapıp, 7. sayfada 1. ürünü görüntüleme . . .

        new BasePage(driver).selectElectronicMenu().selectProduct();
    }
}
