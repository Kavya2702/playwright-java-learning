package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import utils.ConfigReader;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setup() {

        playwright = Playwright.create();

        String browserName = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        // Launch browser
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
        );

        // Create context (important best practice)
        context = browser.newContext();
        page = context.newPage();

        // Navigate to application
        page.navigate(ConfigReader.get("baseUrl"));

        // Login Page usage (POM)
        LoginPage loginPage = new LoginPage(page);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

    @AfterEach
    void tearDown() {

        if (context != null) {
            context.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}