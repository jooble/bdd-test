package task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import task2.pages.AlfabankPage;
import task2.pages.BasePage;
import task2.pages.GoogleEnginePage;
import task2.pages.SearchEnginePage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

public class AlfabankTest {
    private WebDriver driver;
    private BasePage page;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd_HH-mm-ss");

    @Before
    public void init() {
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }


    @Test
    public void aboutJobTest() {
        SearchEnginePage enginePage = new GoogleEnginePage(driver);

        List<String> data = new AlfabankPage(driver, enginePage)
                .getJobPage()
                .getAboutJobPage()
                .getInfo();

        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        String time = LocalDateTime.now().format(formatter);
        String fileName = time + "_" + enginePage.getSearchName() + "_" + browserName + ".txt";

        try {
            writeFile(fileName, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String fileName, List<String> data) throws IOException {
        Path path = Paths.get(getPathOutput(fileName));
        Files.write(path, data);
    }

    private String getPathOutput(String file) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        if (inputStream == null) {
            return file;
        } else {
            Properties properties = new Properties();
            properties.load(inputStream);
            String dir = properties.getProperty("output.dir");
            return dir == null ? file : dir + File.separator + file;
        }
    }
}
