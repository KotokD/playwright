import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class BrowserFactory {
    private final static String chrome = "chrome";
    private final static String firefox = "firefox";
    private final static String safari = "safari";

    public static Browser getBrowserType(Playwright playwright) {
        String browser = System.getProperty("web.browser");
        switch (browser) {
            case chrome:
                return playwright.chromium().launch(getBrowserOptions());
            case firefox:
                return playwright.firefox().launch(getBrowserOptions());
            case safari:
                return playwright.webkit().launch(getBrowserOptions());
            default:
                throw new IllegalArgumentException(String.format("You can create only : %s, %s, %s", chrome, firefox, safari));
        }
    }

    private static BrowserType.LaunchOptions getBrowserOptions() {
        return new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized"));
    }
}
