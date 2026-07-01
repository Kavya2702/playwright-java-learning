package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;


public class AddToCartTest extends BaseTest {

    @Test
    public void addToCart() {

        ProductPage productPage = new ProductPage(page);

        productPage.addProduct("Sauce Labs Backpack");

        Assert.assertEquals(productPage.getCartCount(), "1");
    }
}