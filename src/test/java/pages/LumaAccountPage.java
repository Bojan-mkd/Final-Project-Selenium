package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaAccountPage {
    WebDriver driver;
    WebDriverWait wait;
    private By confirmationMessageForSuccessfulRegistrationLocator = By.xpath("//div[@data-ui-id='message-success']/div");
    private By accountPageTitleLocator = By.xpath("//h1[@class='page-title']");
    private By welcomeUserDropDownLocator = By.xpath("//div[@class='panel header']/ul/li[2]/span/button");
    private By signingOutUserButtonLocator = By.xpath("//div[@class='panel header']/ul/li[2]/div/ul/li[3]");

    public LumaAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String confirmationMessageForSuccessfulRegistration() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageForSuccessfulRegistrationLocator)).getText();
    }

    public String accountPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountPageTitleLocator)).getText();
    }

    public void signingOutUserButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeUserDropDownLocator)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signingOutUserButtonLocator)).click();
    }
}
