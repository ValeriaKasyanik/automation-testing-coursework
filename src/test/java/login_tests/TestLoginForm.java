package login_tests;

import constants.UserData;
import org.junit.jupiter.api.Test;
import utils.DataGenerator;
import utils.WaitUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginForm extends CommonTest {
    private final String LOGIN_PAGE_URL = "https://account.jetbrains.com/login";
    private final String ENTER_USERNAME_ERROR_MESSAGE = "Please enter username or email address.";
    private final String INCORRECT_USERNAME_ERROR_MESSAGE = "Incorrect username and/or password";

    @Test
    public void openLoginPage() {
        driver.get(HOME_PAGE_URL);
        WaitUtil.waitForElementIsDisplayed(driver, homePage.getAccountIcon());
        homePage.getAccountIcon().click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(LOGIN_PAGE_URL, currentUrl, "Actual and expected results don't match.");
    }

    @Test
    public void checkLoginWithCorrectData() {
        driver.get(LOGIN_PAGE_URL);
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getEmailAddressInput());
        loginPage.getEmailAddressInput().sendKeys(UserData.EMAIL);
        loginPage.getPasswordInput().sendKeys(UserData.PASSWORD);
        loginPage.getSignInButton().click();
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getUserProfileSection());
        String userName = loginPage.getUserProfileSection().getText();
        assertEquals(UserData.USERNAME, userName, "Actual and expected results don't match.");
    }

    @Test
    public void checkLoginWithEmptyFields() {
        driver.get(LOGIN_PAGE_URL);
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getEmailAddressInput());
        loginPage.getSignInButton().click();
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getLoginFormErrorMessage());
        String errorMessage = loginPage.getLoginFormErrorMessage().getText();
        assertEquals(errorMessage, ENTER_USERNAME_ERROR_MESSAGE,"Actual and expected results don't match.");
    }

    @Test
    public void checkLoginWithIncorrectData() {
        driver.get(LOGIN_PAGE_URL);
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getEmailAddressInput());
        loginPage.getEmailAddressInput().sendKeys(DataGenerator.generateInvalidEmail());
        loginPage.getPasswordInput().sendKeys(DataGenerator.generatePassword());
        loginPage.getSignInButton().click();
        WaitUtil.waitForElementIsDisplayed(driver, loginPage.getLoginFormErrorMessage());
        String errorMessage = loginPage.getLoginFormErrorMessage().getText();
        assertEquals(errorMessage, INCORRECT_USERNAME_ERROR_MESSAGE,"Actual and expected results don't match.");
    }
}
