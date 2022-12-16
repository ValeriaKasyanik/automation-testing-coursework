package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtil {
    private static WebDriver driverInstance = null;

    private WebDriverUtil() {};

    public static WebDriver getDriverInstance() {
        if (driverInstance == null) {
            WebDriverManager.chromedriver().setup();

            final var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driverInstance = new ChromeDriver(chromeOptions);
        }
        return driverInstance;
    }

    public static void cleanUpDriver() {
        driverInstance = null;
    }
}
