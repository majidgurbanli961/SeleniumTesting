import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import Pages.AccountEditPage;
import Pages.AddAdressPage;
import Pages.MainPage;
import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;
public class FormTest {
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
    public  void addAddress(){
    AddAdressPage addAdressPage = new AddAdressPage(this.driver);
    String result = addAdressPage.addAddress();
    assertEquals("Your address has been successfully added",result);

    }
    @Test
    public  void afterLoginTest(){
        MainPage mainPage = new MainPage(this.driver);
        AccountEditPage accountEditPage = mainPage.openAccountEditPage();
        accountEditPage.editName();
        String afterClickHeaderName = this.driver.getTitle();
        assertEquals("My Account",afterClickHeaderName);
    }
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
