package page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public abstract class BasePage {
    protected final String BASE_URL = "https://www.google.com";
    private final Page page;

    BasePage(Page page) {
        this.page = page;
    }

    public void navigateToPage(String url) {
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        waitForPageLoaded();
    }

    public abstract void waitForPageLoaded();

    public abstract boolean isPageLoaded();

    protected <T extends BasePage> T switchToPage(Page page, Class<T> pageType) {
        T targetPage = null;
        try {
            targetPage = pageType.getConstructor(com.microsoft.playwright.Page.class).newInstance(page);
            targetPage.waitForPageLoaded();

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            log.error("Cannot create page {} something went wrong {}", pageType.getSimpleName(), ex.getMessage());
        }
        return targetPage;
    }
}
