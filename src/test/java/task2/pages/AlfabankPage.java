package task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlfabankPage extends BasePage {

    private static final String JOB_TEXT = "Работайте у нас";
    private static final String URL = "https://alfabank.ru";

    public AlfabankPage(WebDriver driver) {
        super(driver);

        driver.get(URL);
    }

    public AlfabankPage(WebDriver driver, SearchEnginePage searchEngine) {
        super(driver);

        searchEngine.search("АльфаБанк");
    }

    public AlfabankJobPage getJobPage() {

        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format("//div[@class='footer__nav-column']//li//a[text()[contains(.,'%s')]]", JOB_TEXT))));

        element.click();

        return new AlfabankJobPage(driver);
    }
}
