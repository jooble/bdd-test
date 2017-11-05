package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(By.className("n-title__text")).getText();
    }
}
