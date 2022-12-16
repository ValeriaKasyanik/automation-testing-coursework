package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitUtil {
    public static void waitForElementIsDisplayed(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .ignoring(StaleElementReferenceException.class, WebDriverException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
