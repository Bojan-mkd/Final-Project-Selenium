package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaCreateAccountPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    private By createNewAccountTextLocator = By.className("base");
    private By firstNameLocator = By.id("firstname");
    private By lastNameLocator = By.name("lastname");
    private By emailLocator = By.id("email_address");
    private By passwordLocator = By.id("password");
    private By confirmPasswordLocator = By.name("password_confirmation");
    private By createAccountButtonLocator = By.xpath("//button[@title='Create an Account']");
    private By personalInformationTextLocator = By.xpath("//span[text()='Personal Information']");
    private By signInInformationTextLocator = By.xpath("//span[text()='Sign-in Information']");
    private By firstNameTextLocator = By.xpath("//label[@for='firstname']");
    private By lastNameTextLocator = By.xpath("//label[@for='lastname']");
    private By emailTextLocator = By.xpath("//label[@for='email_address']");
    private By passwordTextLocator = By.xpath("//label[@for='password']");
    private By confirmPasswordTextLocator = By.xpath("//label[@for='password-confirmation']");
    private By errorMessageForExistingAccountLocator = By.xpath("//div[@data-ui-id='message-error']");

    public LumaCreateAccountPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public String createNewAccountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createNewAccountTextLocator)).getText();
    }

    public String personalInformationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalInformationTextLocator)).getText();
    }

    public String signInInformationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signInInformationTextLocator)).getText();
    }

    public String firstNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTextLocator)).getText();
    }

    public boolean firstNameInput() {
        return driver.findElement(firstNameLocator).isDisplayed();
    }

    public String lastNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTextLocator)).getText();
    }

    public boolean lastNameInput() {
        return driver.findElement(lastNameLocator).isDisplayed();
    }

    public String emailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextLocator)).getText();
    }

    public boolean emailInput() {
        return driver.findElement(emailLocator).isDisplayed();
    }

    public String passwordText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextLocator)).getText();
    }

    public boolean passwordInput() {
        return driver.findElement(passwordLocator).isDisplayed();
    }

    public String confirmPasswordText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordTextLocator)).getText();
    }

    public boolean confirmPasswordInput() {
        return driver.findElement(confirmPasswordLocator).isDisplayed();
    }

    public boolean createAcoountButtonIsDisplayed() {
        return driver.findElement(createAccountButtonLocator).isDisplayed();
    }

    public void firstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void lastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void email(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void password(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void confirmPassword(String password) {
        driver.findElement(confirmPasswordLocator).sendKeys(password);
    }

    public void createAccountButton() {
        driver.findElement(createAccountButtonLocator).click();
    }

    public void scrollToCreateAccaountButton() {
        action.moveToElement(driver.findElement(createAccountButtonLocator)).perform();
    }

    public String errorMessageForExistingAccount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageForExistingAccountLocator)).getText();
    }
}
