package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ShareData;

import java.util.List;

public class LumaProductsCatalogPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private By sizeCategoryLocation = By.xpath("//div[text()='Size']");
    private By sizeCategoryDropDownListLocator = By.xpath("//div[@class='swatch-option text ']");
    private By colorCategoryLocation = By.xpath("//div[text()='Color']");
    private By colorCategoryDropDownListLocator = By.xpath("//div[@class='swatch-option color ']");
    private By productCatalogLocator = By.xpath("//a[@class='product-item-link']");
    private By shoppingCartLocator = By.xpath("//div[@class='minicart-wrapper']");
    private By shoppingCartQuantityLocator = By.xpath("//span[@class='counter qty']");
    private By shoppingCartCheckoutLocator = By.xpath("//button[@id='top-cart-btn-checkout']");
    private By clearAllShoppingOptionsLocator = By.xpath("//a[@class='action clear filter-clear']");
    private By confirmationMessageForSuccessfulAddingProductToCartLocator = By.xpath("//div[@data-ui-id='message-success']/div");
    private By productsListInShoppingCartLocator = By.xpath("//ol[@id='mini-cart']/li");
    private By subtotalSumForBothProductsInShoppingCartLocator = By.xpath("//div[@class='subtotal']/div");

    public LumaProductsCatalogPage(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public String subtotalSumForBothProductsInShoppingCart(){
        return driver.findElement(subtotalSumForBothProductsInShoppingCartLocator).getText();
    }

    public String confirmationMessageForSuccessfulAddingProductToCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageForSuccessfulAddingProductToCartLocator)).getText();
    }

    public void sizeCategoryList(String label) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeCategoryLocation)).click();
        List<WebElement> elementList = driver.findElements(sizeCategoryDropDownListLocator);
        for (WebElement e : elementList) {
            if (e.getAttribute("option-label").contentEquals(label)) {
                e.click();
                break;
            }
        }
    }

    public void colorCategoryList(String label) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorCategoryLocation)).click();
        List<WebElement> elementList = driver.findElements(colorCategoryDropDownListLocator);
        for (WebElement e : elementList) {
            if (e.getAttribute("option-label").contentEquals(label)) {
                e.click();
                break;
            }
        }
    }

    public void addingProductToCartDirectlyFromCatalogList(String label) {
        action = new Actions(driver);
        int i = 1;
        List<WebElement> elementList = driver.findElements(productCatalogLocator);
        for (WebElement e : elementList) {
            if (e.getText().contains(label)) {
                action.scrollByAmount(0, 300).perform();
                action.moveToElement(e).perform();
                ShareData.setPriceOfProductAddedDirectlyFromCatalog(driver.findElement(By.xpath("//ol[@class='products list items product-items']/li[" + i + "]/div/div/div[1]/span/span/span[2]")).getText());
                driver.findElement(By.xpath("//ol[@class='products list items product-items']/li[" + i + "]/div/div/div[3]/div/div/form/button")).click();
                break;
            }
            i++;
        }
    }

    public void choosingProductDirectlyFromCatalogList(String label) {
        action = new Actions(driver);
        List<WebElement> elementList = driver.findElements(productCatalogLocator);
        for (WebElement e : elementList) {
            if (e.getText().contains(label)) {
                action.scrollToElement(e).perform();
                action.moveToElement(e).click().perform();
                break;
            }
        }
    }

    public void shoppingCartButton() {
        action.scrollToElement(driver.findElement(shoppingCartLocator)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartQuantityLocator)).click();
    }

    public void shoppingCartCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartCheckoutLocator)).click();
    }

    public void clearAllShoppingOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clearAllShoppingOptionsLocator)).click();
    }

    public String productsInShoppingCart(String label) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsListInShoppingCartLocator));
        String product = "";
        int i = 1;
        List<WebElement> products = driver.findElements(productsListInShoppingCartLocator);
        for (WebElement e : products) {
            action.moveToElement(driver.findElement(By.xpath("//li[@data-role='product-item']["+ i + "]//span[@role='tab']"))).click().perform();
            if (e.getText().contains(label)) {
                product = e.getText();
            }
            action.moveToElement(driver.findElement(By.xpath("//li[@data-role='product-item']["+ i + "]//span[@role='tab']"))).click().perform();
            i++;
        }
        return product;
    }
}
