package com.saha.test.test;

import com.saha.test.base.BasePage;
import com.saha.test.base.BaseTest;
import org.junit.Test;

public class PurchasingTest extends BaseTest {

    @Test
    public void defactoPurchasingTest() throws InterruptedException {
        new BasePage(driver).callRegisterPage().register().selectCategory().filteringForShirtSColour().secondPageAndProductSelect()
                .selectNumberOfProduct().addBasket().goToBasket().continueForAddressPage().addressRegister()
                .continueForPayment().editCreditCard();

    }
}
