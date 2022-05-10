package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddAdressPage extends PageBase {
    public AddAdressPage(WebDriver driver) {
        super(driver);
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login("majidmg@code.edu.az","miko1999");
        this.driver.get("http://tutorialsninja.com/demo/index.php?route=account/address/add");

    }
    private  final By firstName = By.name("firstname");
    private  final By lastName = By.name("lastname");
    private  final By company = By.name("company");
    private  final By addressFirst = By.name("address_1");
    private  final By addressSecond = By.name("address_2");
    private  final By city = By.name("city");
    private  final By postCode = By.name("postcode");
    private  final By countryId = By.name("country_id");
    private  final By zoneId = By.name("zone_id");
    private final By checkBox = By.name("default");
    private  final  By submitButton = By.xpath("//input[@type='submit']");
    private  final By alertDismissible = By.className("alert-dismissible");

    public String addAddress(){
        WebElement firstNameElem = waitVisibilityAndFindElement(firstName);
        WebElement lastNameElem = waitVisibilityAndFindElement(lastName);
        WebElement companyElem = waitVisibilityAndFindElement(company);
        WebElement addressFirstElem = waitVisibilityAndFindElement(addressFirst);
        WebElement addressSecondElem = waitVisibilityAndFindElement(addressSecond);
        WebElement cityElem = waitVisibilityAndFindElement(city);
        WebElement postCodeElem = waitVisibilityAndFindElement(postCode);
        WebElement countryIdElem = waitVisibilityAndFindElement(countryId);
        WebElement zoneIdElem = waitVisibilityAndFindElement(zoneId);

        WebElement checkBoxElem = waitVisibilityAndFindElement(checkBox);
        WebElement submitButtonElem= waitVisibilityAndFindElement(submitButton);
        firstNameElem.sendKeys("Majid1");
        lastNameElem.sendKeys("Gurbanli");
        companyElem.sendKeys("Limak MMC");
        addressFirstElem.sendKeys("Szovetseg 35");
        addressSecondElem.sendKeys("3 emelet");
        cityElem.sendKeys("Budapest");
        postCodeElem.sendKeys("1074");
        Select countrySelect = new Select(countryIdElem);
        countrySelect.selectByVisibleText("Hungary");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select zoneSelect = new Select(zoneIdElem);
        zoneSelect.selectByIndex(1);
        if(!checkBoxElem.isSelected()){
            checkBoxElem.click();

        }
        submitButtonElem.click();
        WebElement alertDismissibleElem = waitVisibilityAndFindElement(alertDismissible);

        return alertDismissibleElem.getText();
    }
}
