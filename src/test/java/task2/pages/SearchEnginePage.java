package task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class SearchEnginePage extends BasePage {

    public SearchEnginePage(WebDriver driver) {
        super(driver);
    }

    public abstract void search(String query);

    public abstract String getSearchName();
}
