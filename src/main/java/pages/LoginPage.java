package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name="username")
    WebElement emailAddressInput;

    @FindBy(name="password")
    WebElement passwordInput;

    @FindBy(css = ".sign-in-button")
    WebElement signInButton;

    @FindBy(css = ".text-danger")
    WebElement enterUsernameErrorMessage;

    @FindBy(css = ".navbar-customer-name .dropdown-toggle")
    WebElement userProfileSection;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailAddressInput() {
        return emailAddressInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getEnterUsernameErrorMessage() {
        return enterUsernameErrorMessage;
    }

    public WebElement getUserProfileSection() {
        return userProfileSection;
    }
}