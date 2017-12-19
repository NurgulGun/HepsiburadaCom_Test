package com.saha.test.test;

import com.saha.test.base.BasePage;
import com.saha.test.base.BaseTest;
import org.junit.Test;

import java.awt.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException, AWTException {
        new BasePage(driver).callLoginPage().login();
    }

}
