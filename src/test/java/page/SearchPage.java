package page;

import com.microsoft.playwright.Page;

public class SearchPage extends BasePage {

    private static final String header = "//form[@id='tsf']";

    private final Page page;

    public SearchPage(Page page) {
        super(page);
        this.page = page;
    }

    @Override
    public void waitForPageLoaded() {
        page.waitForSelector(header);
    }

    @Override
    public boolean isPageLoaded() {
        return page.isVisible(header);
    }
}
