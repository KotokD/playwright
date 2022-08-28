import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeAll
    static void setUp() {
        playwright = Playwright.create();
        browser = BrowserFactory.getBrowserType(playwright);
    }

    @BeforeEach
    void setBrowserContext() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.setViewportSize(width, height);
    }

    @AfterEach
    void removeBrowserContext() {
        browserContext.close();
    }

    @AfterAll
    static void cleanUp() {
        playwright.close();
    }
}
