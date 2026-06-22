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
        productPage.addBackpack();
        productPage.addBikeLight();

        // Validate cart count
        assertEquals("2", productPage.getCartCount());
    }
}