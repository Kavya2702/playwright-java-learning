package pages;

import com.microsoft.playwright.Page;

public class CheckoutCompletePage {

    private Page page;

    public CheckoutCompletePage(Page page) {
        this.page = page;
    }

    // Verify Success Header
    public String getSuccessHeader() {
        return page.locator(".complete-header").textContent();
    }

    // Verify Success Message
    public String getSuccessMessage() {
        return page.locator(".complete-text").textContent();
    }

    // Verify Image Displayed
    public boolean isSuccessImageDisplayed() {
        return page.locator(".pony_express").isVisible();
    }

    // Back Home
    public ProductPage clickBackHome() {
        page.locator("#back-to-products").click();
        return new ProductPage(page);
    }
}