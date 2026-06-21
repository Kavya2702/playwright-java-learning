package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {

        page.locator("#user-name").fill(username);
        page.locator("#password").fill(password);
        page.locator("#login-button").click();
    }
}