package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {

    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void enterFirstName(String firstName) {
        page.locator("#first-name").fill(firstName);
    }

    public void enterLastName(String lastName) {
        page.locator("#last-name").fill(lastName);
    }

    public void enterPostalCode(String postalCode) {
        page.locator("#postal-code").fill(postalCode);
    }

    public void clickContinue() {
        page.locator("#continue").click();
    }

    public void clickFinish() {
        page.locator("#finish").click();
    }

    public String getSuccessMessage() {
        return page.locator(".complete-header").textContent();
    }
}