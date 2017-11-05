package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarket extends BasePage {

    public YandexMarket(WebDriver driver) {
        super(driver);
    }

    public YandexMarket getSubsection(String subSection) {
        driver.findElement(By.xpath(String.format("//ul[@class='topmenu__list']//li[@data-department='%s']//a", subSection)))
                .click();
        return this;
    }

    public ProductList getCatalog(String menu, String catalog) {
        WebElement container = driver.findElement(By.xpath(String.format("//div[a[text()[contains(., '%s')]]]", menu)));

        //expand menu
        container.findElement(By.className("catalog-menu__list-item_type_more"))
                .click();

        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format("//div[@class='catalog-menu__list']//a[text()[contains(.,'%s')]]", catalog))));

        element.click();
        return new ProductList(driver);
    }
}
