package task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlfabankJobPage extends BasePage {
    private static final String ABOUT_TEXT = "О работе в банке";

    public AlfabankJobPage(WebDriver driver) {
        super(driver);
    }

    public AboutJobAlfabankPage getAboutJobPage() {

        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format("//a[@class='nav_item-link']//span[text()[contains(.,'%s')]]", ABOUT_TEXT))));

        element.click();

        return new AboutJobAlfabankPage(driver);
    }
}
