package login_tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHomePage extends CommonTest {

    @Test
    public void openHomePage() {
        driver.get(HOME_PAGE_URL);
        String currentUrl = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, currentUrl, "Actual and expected results don't match.");
    }
}
