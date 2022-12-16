package login_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverUtil;

public class CommonTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected final String HOME_PAGE_URL = "https://www.jetbrains.com/";

    @BeforeEach
    public void setUp() {
        driver = WebDriverUtil.getDriverInstance();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        WebDriverUtil.cleanUpDriver();
    }
}
