package tests;

import base.BaseTest;

import pages.CartPage;
import pages.ProductPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveProductTest extends BaseTest {

    @Test
    public void removeProductFromCart() {

        ProductPage productPage = new ProductPage(page);

        productPage.addBackpack();
        productPage.addBikeLight();

        assertEquals("2", productPage.getCartCount());

        productPage.removeBackpack();

        assertEquals("1", productPage.getCartCount());

        productPage.openCart();

        CartPage cartPage = new CartPage(page);

        assertFalse(cartPage.isBackpackDisplayed());

        page.screenshot(new com.microsoft.playwright.Page.ScreenshotOptions().setPath(java.nio.file.Paths.get("screenshots/RemoveProduct.png")));
    }
}