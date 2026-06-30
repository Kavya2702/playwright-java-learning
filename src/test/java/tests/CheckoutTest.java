package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {

        ProductPage productPage = new ProductPage(page);

        productPage.addProduct("Sauce Labs Backpack");
        productPage.addProduct("Sauce Labs Bike Light");

        productPage.openCart();

        CartPage cartPage = new CartPage(page);

        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(page);

        checkoutPage.enterFirstName("Kaviya");
        checkoutPage.enterLastName("Priya");
        checkoutPage.enterPostalCode("641654");

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        assertEquals("Thank you for your order!", checkoutPage.getSuccessMessage());

        page.screenshot(new com.microsoft.playwright.Page.ScreenshotOptions().setPath(java.nio.file.Paths.get("screenshots/CheckoutSuccess.png")));
    }
}