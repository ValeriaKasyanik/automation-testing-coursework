package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath="//*[@data-test='site-header-profile-action']/*[contains(@class, 'wt-icon')]")
    WebElement accountIcon;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public WebElement getAccountIcon() {
        return accountIcon;
    }
}
