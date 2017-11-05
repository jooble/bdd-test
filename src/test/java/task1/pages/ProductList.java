package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductList extends BasePage {

    public ProductList(WebDriver driver) {
        super(driver);
    }

    public ProductList withParams(List<String> params) {
        for (String param : params) {
            WebElement element = driver.findElement(By.xpath(String.format("//label[contains(., '%s')]", param)));
            element.click();
        }

        return this;
    }

    public ProductList priceFrom(int from) {
        driver.findElement(By.className("input_price_from")).findElement(By.className("input__control"))
                .sendKeys(String.valueOf(from));
        return this;
    }

    public ProductList priceTo(int from) {
        driver.findElement(By.className("input_price_to")).findElement(By.className("input__control"))
                .sendKeys(String.valueOf(from));
        return this;
    }

    public List<WebElement> getProducts() {
        sleep(10);
        return driver.findElements(By.className("n-snippet-cell2"));
    }

    public ProductPage getProductPage(WebElement element) {
        element.findElement(By.className("n-snippet-cell2__title")).click();

        return new ProductPage(driver);
    }

    public String getProductName(WebElement element) {
        return element.findElement(By.className("n-snippet-cell2__title")).getText();
    }
}
