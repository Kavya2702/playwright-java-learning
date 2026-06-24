package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.*;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        ProductPage productPage = new ProductPage(page);

        // Add products
//        productPage.addBackpack();
//        productPage.addBikeLight();

        // Validate cart count


        //Adding product with dynamic locator
        productPage.addProduct("Sauce Labs Backpack");
        productPage.addProduct("Sauce Labs Bike Light");
        assertEquals("2", productPage.getCartCount());

        productPage.removeProduct("Sauce Labs Backpack");
        assertEquals("1", productPage.getCartCount());
    }

}