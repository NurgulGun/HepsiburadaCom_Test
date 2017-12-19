package com.saha.test.test;

import com.saha.test.base.BasePage;
import com.saha.test.base.BaseTest;
import org.junit.Test;

import java.awt.*;

public class RegisterTest extends BaseTest {

    @Test
    public void registerTest() throws InterruptedException, AWTException {
        new BasePage(driver).callRegisterPage().register();
    }
}
