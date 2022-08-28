import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import page.HomePage;

import java.nio.file.Paths;

public class PlaywrightTest extends BaseTest {

    @Test
    public void playWrightTest() {
        new HomePage(page).navigate();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screen.png")));
    }
}
