package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexHome extends BasePage {

    private static final String YANDEX_RU = "https://yandex.ru/";

    public YandexHome(WebDriver driver) {
        super(driver);

        driver.get(YANDEX_RU);
    }

    public YandexMarket getMarket() {
        WebElement market = driver.findElement(By.xpath("//div[@class='home-arrow__tabs']//a[@data-id='market']"));
        market.click();

        return new YandexMarket(driver);
    }
}
