package page;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private static final String inputField = "//input[@name='q']";
    private static final String submitButton = "(//input[@name='btnK'])[2]";

    private final Page page;

    public HomePage(Page page) {
        super(page);
        this.page = page;
    }

    public HomePage navigate() {
        navigateToPage(BASE_URL);
        return this;
    }

    public HomePage search(String query) {
        page.fill(inputField, query);
        page.click(submitButton);
        switchToPage(page, SearchPage.class);
        return this;
    }

    public void waitForPageLoaded() {
        page.waitForSelector(submitButton);
    }

    public boolean isPageLoaded() {
        return page.isVisible(submitButton);
    }
}
