package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductPage;


import static org.testng.Assert.assertEquals;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        ProductPage productPage = new ProductPage(page);

        //Adding product with dynamic locator
        productPage.addProduct("Sauce Labs Backpack");
        productPage.addProduct("Sauce Labs Bike Light");
        assertEquals("2", productPage.getCartCount());

        productPage.removeProduct("Sauce Labs Backpack");
        assertEquals("1", productPage.getCartCount());
    }

}