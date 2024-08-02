package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LumaCheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    Select s;
    private By assertingCheckoutPageLocator = By.xpath("//div[contains(@data-bind,'Shipping Address')]");
    private By assertingPresentsOfProductsLocator = By.xpath("//span[text()='Order Summary']");
    private By productsListLocator = By.xpath("//div[@class='block items-in-cart']");
    private By productsListDropDownLocator = By.xpath("//ol[@class='minicart-items']/li");
    private By companyNameLocator = By.xpath("//input[@name='company']");
    private By streetAddressOneLocator = By.xpath("//input[@name='street[0]']");
    private By streetAddressTwoLocator = By.xpath("//input[@name='street[1]']");
    private By streetAddressThreeLocator = By.xpath("//input[@name='street[2]']");
    private By cityLocator = By.xpath("//input[@name='city']");
    private By stateOrProvinceListLocator = By.xpath("//select[@name='region_id']");
    private By zipOrPostalCodeLocator = By.xpath("//input[@name='postcode']");
    private By countryLocator = By.xpath("//select[@name='country_id']");
    private By phoneNumberLocator = By.xpath("//input[@name='telephone']");
    private By shippingMethodsLocator = By.xpath("//input[@class='radio']");
    private By shippingMethodsTitleLocator = By.xpath("//div[contains(@data-bind,'Shipping Methods')]");
    private By nextButtonLocator = By.xpath("//button[@class='button action continue primary']");
    private By firstNameLocator = By.xpath("//input[@name='firstname']");
    private By lastNameLocator = By.xpath("//input[@name='lastname']");

    public LumaCheckoutPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public String assertingCheckoutPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(assertingCheckoutPageLocator)).getText();
    }

    //Thread.sleep is needed here because productList sometimes is not clickable and intercepted
    public String assertingOrderSummary() throws InterruptedException {
        action.scrollToElement(driver.findElement(assertingPresentsOfProductsLocator)).perform();
        WebElement productList = wait.until(ExpectedConditions.elementToBeClickable(productsListLocator));
        Thread.sleep(5000);
        productList.click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(assertingPresentsOfProductsLocator)).getText();
    }

    public String productsInOrderSummary(String label) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsListDropDownLocator));
        String product = "";
        int i = 1;
        List<WebElement> products = driver.findElements(productsListDropDownLocator);
        for (WebElement e : products) {
            action.moveToElement(driver.findElement(By.xpath("//li[@class='product-item']["+ i + "]//span[@role='tab']"))).click().perform();
            if (e.getText().contains(label)) {
                product = e.getText();
            }
            action.moveToElement(driver.findElement(By.xpath("//li[@class='product-item']["+ i + "]//span[@role='tab']"))).click().perform();
            i++;
        }
        return product;
    }

    public void companyName(String companyName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyNameLocator)).sendKeys(companyName);
    }

    public void streetAddressOne(String streetName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddressOneLocator)).sendKeys(streetName);
    }

    public void streetAddressTwo(String streetName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddressTwoLocator)).sendKeys(streetName);
    }

    public void streetAddressThree(String streetName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddressThreeLocator)).sendKeys(streetName);
    }

    public void city(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator)).sendKeys(city);
    }

    public void stateOrProvinceDropDownList(String state) {
        s = new Select(driver.findElement(stateOrProvinceListLocator));
        s.selectByVisibleText(state);
    }

    public void zipOrPostalCode(String zipOrPostalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipOrPostalCodeLocator)).sendKeys(zipOrPostalCode);
    }

    public void countryDropDownList(String country) {
        s = new Select(driver.findElement(countryLocator));
        s.selectByVisibleText(country);
    }

    public void phoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberLocator)).sendKeys(phoneNumber);
    }

    public void shoppingMethods() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodsLocator)).click();
    }

    public void scrollToShippingMethods() {
        action.scrollToElement(driver.findElement(shippingMethodsTitleLocator)).perform();
    }

    public void scrollToNextButton() {
        action.scrollToElement(driver.findElement(nextButtonLocator)).perform();
    }

    public void nextButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButtonLocator)).click();
    }

    public void getFirstName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator)).getText();
    }

    public void getLastName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameLocator)).getText();
    }
}
