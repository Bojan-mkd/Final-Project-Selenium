package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class ProxyEmailProvider {
    WebDriver driver;

    public ProxyEmailProvider(WebDriver driver) {
        this.driver = driver;
    }

    public String userProxyEmail() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        String url = "https://www.mailslurp.com/tools/fake-email-generator/";
        driver.navigate().to(url);
        Thread.sleep(2000);
        String email = driver.findElement(By.xpath("//input[@data-test-id='emailAddress']")).getAttribute("value");
        System.out.println(email);
        return email;
    }
}
