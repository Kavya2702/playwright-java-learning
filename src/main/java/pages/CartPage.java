package pages;

import com.microsoft.playwright.Page;

public class CartPage {

    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public boolean isBackpackDisplayed() {
        return page.locator("text=Sauce Labs Backpack").isVisible();
    }

    public void clickCheckout() {
        page.locator("#checkout").click();
    }
}