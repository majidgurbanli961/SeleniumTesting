import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import Pages.LoginPage;
import Pages.MainPage;
import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;
public class LoginTest {
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
    public  void loginTest(){
        LoginPage loginPage = new LoginPage(this.driver);
       String result =  loginPage.login("majidmg@code.edu.az","miko1999");
        assertEquals("My Account", result);
    }

    @Test
    public  void LogoutTest(){
        MainPage mainPage = new MainPage(this.driver);
        String logoutText = mainPage.logout();
        assertEquals("Account Logout", logoutText);
    }
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
