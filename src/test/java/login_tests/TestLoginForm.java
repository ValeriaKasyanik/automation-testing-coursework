package login_tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.WebDriverUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginForm {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverUtil.getDriverInstance();
    }

    @Test
    public void openHomePage() {
        driver.get("https://www.jetbrains.com/");
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.jetbrains.com/", currentUrl);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
