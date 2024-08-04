package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaFinalPage {
    WebDriver driver;
    WebDriverWait wait;
    private By successfulOrderMessageLocator = By.xpath("//span[@class='base']");
    private By confirmingEmailIsSendMessageLocator = By.xpath("//div[@class='checkout-success']");

    public LumaFinalPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String successfulOrderMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulOrderMessageLocator)).getText();
    }

    public String confirmingEmailIsSendMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmingEmailIsSendMessageLocator)).getText();
    }
}
