import configuration.BrowserPicker;
import configuration.TestProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestBase {
    private static final Logger logger = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    protected static BrowserPicker browserPicker;


    @BeforeAll
    static void beforeAll() {
        TestProperties properties = new TestProperties();
        browserPicker = new BrowserPicker();
        driver = browserPicker.getDriver();
        driver.get(System.getProperty("webUrl"));
        logger.info(">>>DRIVER INITIATED PROPERLY");
    }

    @AfterAll
    static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        logger.info(">>>DRIVER CLOSED PROPERLY");
    }

}