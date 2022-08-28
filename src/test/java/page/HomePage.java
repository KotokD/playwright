package page;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    protected final String url = "https://www.whatsmybrowser.org";
    private static final String title = "//h2[contains(@class,'header')]";
    private final Page page;

    public HomePage(Page page) {
        super(page);
        this.page = page;
    }

    public HomePage navigate() {
        navigateToPage(url);
        return this;
    }

    public void waitForPageLoaded() {
        page.waitForSelector(title);
    }
}
