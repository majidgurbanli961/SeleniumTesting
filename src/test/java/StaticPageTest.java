import Pages.MainPage;
import Pages.MultiplePage;
import Pages.TabletPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StaticPageTest {
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
    public  void  openedCorrectly(){
        MainPage mainPage = new MainPage(this.driver);
        TabletPage tabletPage = mainPage.openTabletPage();
        String title = tabletPage.getTitle();
        assertEquals("Tablets", title);
    }
    @Test
    public void openedCorrectlyMultiple(){
        List<String> headers = new ArrayList<String>();
        headers.add("Your Store");
        headers.add("Software");
        headers.add("Cameras");
        List<String> urls = new ArrayList<String>();
        urls.add("http://tutorialsninja.com/demo/index.php");
        urls.add("http://tutorialsninja.com/demo/index.php?route=product/category&path=17");
        urls.add("http://tutorialsninja.com/demo/index.php?route=product/category&path=33");
        for (int i = 0 ; i <headers.size();i++) {
            new MultiplePage(this.driver,urls.get(i));
            assertEquals(headers.get(i),this.driver.getTitle());
        }
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
