package Pages;

import Pages.PageBase;
import org.openqa.selenium.WebDriver;

public class TabletPage extends PageBase {
    public TabletPage(WebDriver driver) {
        super(driver);
    }
    public String getTitle(){
        return this.driver.getTitle();
    }
}
