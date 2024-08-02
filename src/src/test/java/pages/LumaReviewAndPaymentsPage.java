package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaReviewAndPaymentsPage {
    WebDriver driver;
    WebDriverWait wait;
    private By reviewAndPaymentsTitleLocator = By.xpath("//div[text()='Review & Payments']");

    public LumaReviewAndPaymentsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String assertReviewAndPaymentsPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reviewAndPaymentsTitleLocator)).getText();
    }
}
