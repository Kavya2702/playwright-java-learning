package org.example;

import com.microsoft.playwright.*;

public class LaunchBrowser {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://www.google.com");

            String actualTitle = page.title();

            System.out.println("Title: " + actualTitle);

            if(actualTitle.contains("Google")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }

            browser.close();
        }
    }
}