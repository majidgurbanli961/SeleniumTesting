import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class AdvancedTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void testHover(){
        MainPage mainPage = new MainPage(this.driver);
        String result = mainPage.hoverDesktop();
        assertEquals("PC (0)", result);
    }
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
