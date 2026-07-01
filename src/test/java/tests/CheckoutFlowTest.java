package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void verifyCompleteCheckoutFlow() {

        // Product Page
        ProductPage productPage = new ProductPage(page);

        productPage.addProduct("Sauce Labs Backpack");

        Assert.assertEquals(productPage.getCartCount(), "1");

        // Cart Page
        CartPage cartPage = productPage.openCart();

        // Checkout Page
        CheckoutPage checkoutPage = cartPage.clickCheckout();

        // Checkout Information
        CheckoutOverviewPage overviewPage =
                checkoutPage.enterCheckoutInformation(
                        ConfigReader.getProperty("firstname"),
                        ConfigReader.getProperty("lastname"),
                        ConfigReader.getProperty("zipcode"));

        // Verify Overview Page
        Assert.assertEquals(
                overviewPage.getProductName(),
                "Sauce Labs Backpack");

        // Finish Checkout
        CheckoutCompletePage completePage =
                overviewPage.clickFinish();

        // Verify Success Header
        Assert.assertEquals(
                completePage.getSuccessHeader(),
                "Thank you for your order!");

        // Verify Success Message
        Assert.assertTrue(
                completePage.getSuccessMessage()
                        .contains("Your order has been dispatched"));

        // Back Home
        ProductPage homePage =
                completePage.clickBackHome();

        // Verify Product Page
        Assert.assertTrue(homePage.isProductPageDisplayed());

    }
}