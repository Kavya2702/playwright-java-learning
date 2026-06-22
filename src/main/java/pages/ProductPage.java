package pages;

import com.microsoft.playwright.Page;

public class ProductPage {

    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void addBackpack() {
        page.locator("#add-to-cart-sauce-labs-backpack").click();
    }

    public void addBikeLight() {
        page.locator("#add-to-cart-sauce-labs-bike-light").click();
    }

    public void removeBackpack() {
        page.locator("#remove-sauce-labs-backpack").click();
    }

    public String getCartCount() {
        return page.locator(".shopping_cart_badge").textContent();
    }

    public void openCart() {
        page.locator(".shopping_cart_link").click();
    }
}