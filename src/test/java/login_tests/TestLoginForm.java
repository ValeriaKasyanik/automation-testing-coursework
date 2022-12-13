package login_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.WaitUtil;
import utils.WebDriverUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginForm {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private final String HOME_PAGE_URL = "https://www.jetbrains.com/";
    private final String LOGIN_PAGE_URL = "https://account.jetbrains.com/login";
    private final String ENTER_USERNAME_ERROR_MESSAGE = "Please enter username or email address.";

    @BeforeEach
    public void setUp() {
        driver = WebDriverUtil.getDriverInstance();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void openLoginPage() {
        driver.get(HOME_PAGE_URL);
        WaitUtil.waitForElementIsDisplayed(driver, homePage.getAccountIcon());
        homePage.getAccountIcon().click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(LOGIN_PAGE_URL, currentUrl, "Actual and expected results don't match.");
    }

    @Test
    public void loginWithCorrectData() {
        driver.get(LOGIN_PAGE_URL);
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getEmailAddressInput());
        loginPage.getEmailAddressInput().sendKeys("jetbrainstestmail@gmail.com");
        loginPage.getPasswordInput().sendKeys("IFJCikdjcmsdilz");
        loginPage.getSignInButton().click();
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getUserProfileSection());
        String userName = loginPage.getUserProfileSection().getText();
        assertEquals("JBAccount Test", userName, "Actual and expected results don't match.");
    }

    @Test
    public void checkLoginWithEmptyFields() {
        driver.get(LOGIN_PAGE_URL);
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getEmailAddressInput());
        loginPage.getSignInButton().click();
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getEnterUsernameErrorMessage());
        String errorMessage = loginPage.getEnterUsernameErrorMessage().getText();
        assertEquals(errorMessage, ENTER_USERNAME_ERROR_MESSAGE,"Actual and expected results don't match.");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        WebDriverUtil.cleanUpDriver();
    }
}
