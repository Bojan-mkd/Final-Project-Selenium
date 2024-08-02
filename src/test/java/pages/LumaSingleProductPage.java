package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LumaSingleProductPage {
    WebDriver driver;
    Actions action;
    private By addToWishLocator = By.xpath("//div[@class='product-social-links']");
    private By addToCartButtonLocator = By.xpath("//button[@title='Add to Cart']");
    private By priceOfProductLocator = By.xpath("//div[@class='page-title-wrapper product']/../div[3]/div/span[1]/span/span[2]");

    public LumaSingleProductPage(WebDriver driver, Actions action) {
        this.driver = driver;
        this.action = action;
    }

    public void scrollToAddToWish() {
        action.scrollToElement(driver.findElement(addToWishLocator)).perform();
    }

    public void choosingSizeOrColor(String element) {
        action.moveToElement(driver.findElement(By.xpath("//div[@option-label='" + element + "']"))).click().perform();
    }

    public void addToCartButton() {
        action.moveToElement(driver.findElement(addToCartButtonLocator)).click().perform();
    }

    public String priceOfProduct(){
        return driver.findElement(priceOfProductLocator).getText();
    }
}