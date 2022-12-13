package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {
    private static WebDriver driverInstance = null;
    private WebDriverUtil() {};

    public static WebDriver getDriverInstance() {
        if (driverInstance == null) {
            WebDriverManager.chromedriver().setup();
            driverInstance = new ChromeDriver();
        }
        return driverInstance;
    }

    public static void cleanUpDriver() {
        driverInstance = null;
    }
}
