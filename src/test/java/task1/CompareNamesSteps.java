package task1;

import org.jbehave.core.annotations.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import task1.pages.*;

import java.util.Collections;
import java.util.List;

public class CompareNamesSteps {
    private WebDriver driver;
    private BasePage page;

    @BeforeStory
    public void init() {
        driver = new ChromeDriver();
    }

    @AfterStory
    public void clean() {
        page.getDriver().quit();
    }

    @Given("a yandex page")
    public void yandexPage() {
        this.page = new YandexHome(driver);
    }

    @When("i open yandex market")
    public void openYandexMarket() {
        page = ((YandexHome) page).getMarket();
    }

    @When("i open subsection as $subsection")
    public void openSubsection(String subsection) {
        page = ((YandexMarket) page).getSubsection(subsection);
    }

    @When("i click on the $catalog in $menu")
    public void openCatalog(String catalog, String menu) {
        page = ((YandexMarket) page).getCatalog(menu, catalog);
    }

    @When("i enter manufacturer as $manufacturer")
    public void enterManufacturer(String manufacturer) {
        page = ((ProductList) page).withParams(Collections.singletonList(manufacturer));
    }

    @When("i enter price from as $price")
    public void enterPriceFrom(int price) {
        page = ((ProductList) page).priceFrom(price);
    }

    @When("i enter price to as $price")
    public void enterPriceTo(int price) {
        page = ((ProductList) page).priceTo(price);
    }

    @Then("i want compare names of first product and name in product card")
    public void compareName() {
        List<WebElement> products = ((ProductList) page).getProducts();

        String firstName = ((ProductList) page).getProductName(products.get(0));

        page = ((ProductList) page).getProductPage(products.get(0));

        Assert.assertEquals(firstName, ((ProductPage) page).getProductName());
    }
}
