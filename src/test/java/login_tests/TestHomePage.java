package login_tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.WebDriverUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHomePage {
    private WebDriver driver;
    private final String HOME_PAGE_URL = "https://www.jetbrains.com/";

    @BeforeEach
    public void setUp() {
        driver = WebDriverUtil.getDriverInstance();
    }

    @Test
    public void openHomePage() {
        driver.get(HOME_PAGE_URL);
        String currentUrl = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, currentUrl, "Actual and expected results don't match.");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        WebDriverUtil.cleanUpDriver();
    }
}
