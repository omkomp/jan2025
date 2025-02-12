import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


public class BaseTest {
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
       // Configuration.timeout = 15000;
    }

    @Before
    public void init() {
        setup();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
