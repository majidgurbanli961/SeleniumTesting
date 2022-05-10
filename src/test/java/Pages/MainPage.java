package Pages;

import Pages.AccountEditPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends PageBase {

    private  final By edit = By.xpath("//*[@id='column-right']/div/a[@href='http://tutorialsninja.com/demo/index.php?route=account/edit']");
    private  final By tablet = By.xpath("//*[@id='menu']/div[2]/ul[1]/li[4]/a[@href='http://tutorialsninja.com/demo/index.php?route=product/category&path=57']");
    private final  By desktopNav = By.xpath("//*[@id='menu']/div[2]/ul[1]/li[1]");
    private final  By afterHover = By.xpath("//*[@id='menu']/div[2]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    private  final  By footerAboutUs = By.xpath("//footer[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");


    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://tutorialsninja.com/demo/index.php");
    }
    private  final By myAccountNav = By.cssSelector(".list-inline .dropdown");
    private  final  By logOut  = By.xpath("//a[@href='http://tutorialsninja.com/demo/index.php?route=account/logout']");
    private  final  By afterLogout = By.cssSelector("#content h1");
    public AccountEditPage openAccountEditPage(){
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login("majidmg@code.edu.az","miko1999");
        WebElement editElement = waitVisibilityAndFindElement(edit);
        editElement.click();
        return new AccountEditPage(this.driver);
    }
    public String logout(){
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login("majidmg@code.edu.az","miko1999");
        WebElement myAccountNavElement = waitVisibilityAndFindElement(myAccountNav);
        myAccountNavElement.click();
        WebElement logOutElement = waitVisibilityAndFindElement(logOut);
        logOutElement.click();
        WebElement logoutText = waitVisibilityAndFindElement(afterLogout);
        return  logoutText.getText();
    }
    public TabletPage openTabletPage(){
        WebElement tabletElement = waitVisibilityAndFindElement(tablet);
        tabletElement.click();
        TabletPage tabletPage = new TabletPage(this.driver);
        return tabletPage;
    }
    public  String hoverDesktop(){
        WebElement desktopElement = waitVisibilityAndFindElement(desktopNav);
       Actions action =  new Actions(this.driver);
       action.moveToElement(desktopElement).perform();
       WebElement afterHoverElement = waitVisibilityAndFindElement(afterHover);
       return  afterHoverElement.getText();

    }
    public String goToBottomPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement aboutUsElement = waitVisibilityAndFindElement(footerAboutUs);
        aboutUsElement.click();
        return this.driver.getTitle();
    }
    public void goBack(){

        this.driver.navigate().back();

    }


}
