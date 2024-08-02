package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseClassWithClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;
    protected SoftAssert softAssert;
    String url = "https://magento.softwaretestingboard.com/";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
