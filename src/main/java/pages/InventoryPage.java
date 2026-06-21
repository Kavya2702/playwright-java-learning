package pages;

import com.microsoft.playwright.Page;

public class InventoryPage {

    private Page page;

    public InventoryPage(Page page) {
        this.page = page;
    }

    public String getTitle() {

        return page.locator(".title")
                .textContent();
    }
}