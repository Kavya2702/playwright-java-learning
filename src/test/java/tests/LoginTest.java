package tests;

import com.microsoft.playwright.*;

import pages.LoginPage;
import pages.InventoryPage;
import Constants.FrameworkConstants;

public class LoginTest {

    public static void main(String[] args) {

        try (Playwright playwright =
                     Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate(FrameworkConstants.URL);

            LoginPage loginPage = new LoginPage(page);

            loginPage.login(FrameworkConstants.USERNAME, FrameworkConstants.PASSWORD);

            page.waitForURL("**/inventory.html");

            InventoryPage inventoryPage =
                    new InventoryPage(page);

            String title =
                    inventoryPage.getTitle();

            System.out.println(title);

            browser.close();
        }
    }
}