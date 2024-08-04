package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class NavigationHelper {

    public static void registerAnAccount(WebDriver driver, Actions action, WebDriverWait wait, String firstName, String lastName, String password) throws InterruptedException {
        ProxyEmailProvider userEmail = new ProxyEmailProvider(driver);
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaCreateAccountPage creatingUser = new LumaCreateAccountPage(driver, wait, action);
        String originalWindow = driver.getWindowHandle();
        String proxyEmail = userEmail.userProxyEmail();
        ShareData.setRegisterFirstNameAndLastName(firstName, lastName);
        ShareData.setProxyEmailStoring(proxyEmail);
        driver.switchTo().window(originalWindow);
        homePage.createAccountButton();
        creatingUser.scrollToCreateAccaountButton();
        creatingUser.firstName(firstName);
        creatingUser.lastName(lastName);
        creatingUser.email(proxyEmail);
        creatingUser.password(password);
        creatingUser.confirmPassword(password);
        creatingUser.createAccountButton();
    }
}
