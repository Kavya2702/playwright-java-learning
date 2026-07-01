package pages;

import com.microsoft.playwright.Page;

public class CheckoutOverviewPage {

    private Page page;

    public CheckoutOverviewPage(Page page) {
        this.page = page;
    }

    // Get Product Name
    public String getProductName() {
        return page.locator(".inventory_item_name").textContent();
    }

    // Get Product Price
    public String getProductPrice() {
        return page.locator(".inventory_item_price").textContent();
    }

    // Get Payment Information
    public String getPaymentInformation() {
        return page.locator("[data-test='payment-info-value']").textContent();
    }

    // Get Shipping Information
    public String getShippingInformation() {
        return page.locator("[data-test='shipping-info-value']").textContent();
    }

    // Get Item Total
    public String getItemTotal() {
        return page.locator(".summary_subtotal_label").textContent();
    }

    // Get Tax
    public String getTax() {
        return page.locator(".summary_tax_label").textContent();
    }

    // Get Total Price
    public String getTotalPrice() {
        return page.locator(".summary_total_label").textContent();
    }

    // Click Finish
    public CheckoutCompletePage clickFinish() {
        page.locator("#finish").click();
        return new CheckoutCompletePage(page);
    }

    // Click Cancel
    public ProductPage clickCancel() {
        page.locator("#cancel").click();
        return new ProductPage(page);
    }
}