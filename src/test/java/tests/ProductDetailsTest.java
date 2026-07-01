package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ProductPage;

public class ProductDetailsTest extends BaseTest {

    @Test
    public void verifyProductDetails() {

        ProductPage productPage = new ProductPage(page);

        productPage.clickProduct("Sauce Labs Backpack");

        ProductDetailsPage detailsPage = new ProductDetailsPage(page);

        Assert.assertEquals(
                detailsPage.getProductName(),
                "Sauce Labs Backpack");

        Assert.assertEquals(
                detailsPage.getProductPrice(),
                "$29.99");

        Assert.assertTrue(
                detailsPage.getProductDescription().contains("carry"));

        detailsPage.goBackToProducts();

        Assert.assertTrue(productPage.isProductPageDisplayed());
    }
}