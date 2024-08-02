package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaReviewAndPaymentsPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    private By reviewAndPaymentsTitleLocator = By.xpath("//span[text()='Review & Payments']");
    private By cartSubTotalPriceLocator = By.xpath("//span[@data-th='Cart Subtotal']");
    private By shippingLocator = By.xpath("//span[@data-th='Shipping']");
    private By orderTotalLocator = By.xpath("//td[@data-th='Order Total']");
    private By checkOrderLocator = By.xpath("//div[@class='billing-address-details']");
    private By shipToLocator = By.xpath("//div[@class='ship-to']/div[2]");
    private By shipViaLocator = By.xpath("//div[@class='ship-via']/div[2]");
    private By placeOrderButtonLocator = By.xpath("//button[@class='action primary checkout']");

    public LumaReviewAndPaymentsPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public String assertReviewAndPaymentsPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reviewAndPaymentsTitleLocator)).getText();
    }

    public String cartSubTotalPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartSubTotalPriceLocator)).getText().replace("$","");
    }

    public String shipping(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingLocator)).getText().replace("$","");
    }

    public String orderTotal(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderTotalLocator)).getText().replace("$","");
    }

    public String checkOrder(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkOrderLocator)).getText();
    }

    public String shipTo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shipToLocator)).getText();
    }

    public String shipVia(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shipViaLocator)).getText();
    }

    public void placeOrderButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButtonLocator)).click();
    }

    public void scrollToShipVia(){
        action.scrollToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(shipViaLocator))).perform();
    }


}
