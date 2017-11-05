package task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AboutJobAlfabankPage extends BasePage {

    public AboutJobAlfabankPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getInfo() {
        String message = driver.findElement(By.xpath("//div[@class='message']"))
                .getText();

        List<String> info = driver.findElements(By.xpath("//div[@class='info']//p"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        info.add(0, message);

        return info;
    }
}
