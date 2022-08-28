package page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

public abstract class BasePage {
    private final Page page;

    BasePage(Page page) {
        this.page = page;
    }

    public void navigateToPage(String url) {
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        waitForPageLoaded();
    }

    public abstract void waitForPageLoaded();
}
