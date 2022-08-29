import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import page.HomePage;

import java.nio.file.Paths;

public class SearchTest extends BaseTest {

    @Test
    public void playWrightTest() {
        new HomePage(page).navigate().search("Hello world");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screen.png")));
    }
}
