package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {
    private final By inputEmail = By.id("input-email");
    private final By inputPassword = By.id("input-password");
    private  final  By buttonLogin  = By.xpath("//input[@type='submit']");
    private  final  By afterLogin  = By.xpath("//*[@id='column-right']/div[1]/a[@href='http://tutorialsninja.com/demo/index.php?route=account/account']");
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");

    }
    public String login(String username, String password){
        WebElement emailElement = waitVisibilityAndFindElement(inputEmail);
        WebElement passwordElement = waitVisibilityAndFindElement(inputPassword);
        WebElement buttonElement = waitVisibilityAndFindElement(buttonLogin);
        emailElement.sendKeys(username);
        passwordElement.sendKeys(password);
        buttonElement.click();

        return this.driver.getTitle();
    }

}
