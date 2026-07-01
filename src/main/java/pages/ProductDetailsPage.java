package pages;

import com.microsoft.playwright.Page;

public class ProductDetailsPage {

    private Page page;

    // Constructor
    public ProductDetailsPage(Page page) {
        this.page = page;
    }

    // Product Name
    public String getProductName() {
        return page.locator(".inventory_details_name").textContent();
    }

    // Product Description
    public String getProductDescription() {
        return page.locator(".inventory_details_desc").textContent();
    }

    // Product Price
    public String getProductPrice() {
        return page.locator(".inventory_details_price").textContent();
    }

    // Click Add to Cart
    public void addToCart() {
        page.locator("#add-to-cart").click();
    }

    // Click Remove
    public void removeFromCart() {
        page.locator("#remove").click();
    }

    // Back to Products
    public void goBackToProducts() {
        page.locator("#back-to-products").click();
    }

    public void clickProduct(String productName) {

        page.locator("//div[text()='" + productName + "']").click();
    }

    public boolean isProductPageDisplayed() {

        return page.locator(".title").textContent().equals("Products");
    }

}