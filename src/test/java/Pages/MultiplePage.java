package Pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplePage extends PageBase {
    public MultiplePage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
    }

}
