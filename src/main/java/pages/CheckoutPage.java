package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {

    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public CheckoutOverviewPage enterCheckoutInformation(
            String firstName,
            String lastName,
            String zipCode) {

        page.locator("#first-name").fill(firstName);

        page.locator("#last-name").fill(lastName);

        page.locator("#postal-code").fill(zipCode);

        page.locator("#continue").click();

        return new CheckoutOverviewPage(page);
    }


}