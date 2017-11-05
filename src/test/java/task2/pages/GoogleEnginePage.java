package task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleEnginePage extends SearchEnginePage {

    public static final String URL = "https://www.google.ru/";

    public GoogleEnginePage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    @Override
    public void search(String query) {
        WebElement input = driver.findElement(By.xpath("//input[@id='lst-ib']"));
        input.sendKeys(query);
        input.submit();

        WebElement firstElement = driver.findElement(By.xpath("//div[@class='_NId']//h3[@class='r']//a"));
        firstElement.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    @Override
    public String getSearchName() {
        return "google";
    }
}
