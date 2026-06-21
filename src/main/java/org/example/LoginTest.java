package org.example;

import com.microsoft.playwright.*;

public class LoginTest {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));

            Page page = browser.newPage();



            // Open website
            page.navigate("https://www.saucedemo.com");

            // Enter username
            page.locator("#user-name").fill("standard_user");

            // Enter password
            page.locator("#password").fill("secret_sauce");

            // Click login
            page.locator("#login-button").click();

            // Verify login
            String title = page.locator(".title").textContent();

            if(title.equals("Products")) {
                System.out.println("LOGIN SUCCESSFUL");
            } else {
                System.out.println("LOGIN FAILED");
            }

            page.waitForURL("**/inventory.html");

            String currentUrl = page.url();
            System.out.println("Current URL: " + currentUrl);

            if(currentUrl.contains("inventory")) {
                System.out.println("URL Validation Passed");
            } else {
                System.out.println("URL Validation Failed");
            }

            browser.close();
        }
    }
}