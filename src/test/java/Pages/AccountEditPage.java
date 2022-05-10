package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountEditPage extends PageBase {
    private final By inputName = By.id("input-firstname");
    private final  By continueButton = By.xpath("//input[@type='submit']");
    private  final  By alertDiv = By.className("alert-dismissible");

    public AccountEditPage(WebDriver driver) {
        super(driver);
    }
    public String editName(){
        WebElement nameElement  = waitVisibilityAndFindElement(inputName);
        WebElement continueButtonElement = waitVisibilityAndFindElement(continueButton);


        nameElement.sendKeys("t");
        continueButtonElement.click();
        WebElement alertDivElement = waitVisibilityAndFindElement(alertDiv);
        String afterClickText = alertDivElement.getText();
        return afterClickText;
    }
}
