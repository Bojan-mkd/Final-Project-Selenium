package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LumaHomePage {
    WebDriver driver;
    Actions action;
    private By createAccountLocator = By.xpath("//div[@class='panel header']/./ul/li[3]/a");
    private By womenCategoryButtonLocator = By.xpath("//span[text() = 'Women']");
    private By choosingPantsCategoryLocator = By.xpath("//a[text() = 'Pants']");
    private By menCategoryButtonLocator = By.xpath("//span[text() = 'Men']");
    private By choosingWomensPantsCategoryLocator = By.xpath("//a[@id='ui-id-15']");
    private By womenBottomCategoryLocator = By.xpath("//a[@id='ui-id-10']");

    public LumaHomePage(WebDriver driver, Actions action) {
        this.driver = driver;
        this.action = action;
    }

    public void createAccountButton() {
        driver.findElement(createAccountLocator).click();
    }

    public void womenCategoryButton() {
        driver.findElement(womenCategoryButtonLocator).click();
    }

    public void choosingPantsCategory() {
        driver.findElement(choosingPantsCategoryLocator).click();
    }

    public void womenCategoryButton2() {
        action.moveToElement(driver.findElement(womenCategoryButtonLocator)).perform();
    }

    public void womenBottomCategory() {
        action.moveToElement(driver.findElement(womenBottomCategoryLocator)).perform();
    }

    public void choosingWomensPantsCategory2() {
        action.moveToElement(driver.findElement(choosingWomensPantsCategoryLocator)).click().perform();
    }
}
