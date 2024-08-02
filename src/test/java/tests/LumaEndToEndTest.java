package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.*;

public class LumaEndToEndTest extends BaseClassWithClass {

    @Test(priority = 10, dataProvider = "userInformation", dataProviderClass = DataProviders.class)
    public void createAccount_registrationSuccess(String firstName, String lastName, String password) throws InterruptedException {
        LumaAccountPage accountPage = new LumaAccountPage(driver, wait);
        NavigationHelper.registerAnAccount(driver, action, wait, firstName, lastName, password);
//        accountPage.confirmationMessageForSuccessfulRegistration();
//        Assert.assertEquals(accountPage.confirmationMessageForSuccessfulRegistration(), "Thank you for registering with Main Website Store.");
    }

    @Test(priority = 20, dataProvider = "informationForTwoProducts", dataProviderClass = DataProviders.class)
    public void addAndCheckoutProductInShoppingCartByClickingItems(String sizeNumber1, String sizeNumber2, String color1, String color2, String productNameOne, String productNameTwo) throws InterruptedException {
        ShareData.setProductPageArg(sizeNumber1, sizeNumber2, color1, color2, productNameOne, productNameTwo);
        softAssert = new SoftAssert();
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaProductsCatalogPage productsPage = new LumaProductsCatalogPage(driver, wait, action);
        LumaSingleProductPage singleProduct = new LumaSingleProductPage(driver, action);
        LumaCheckoutPage checkoutPage = new LumaCheckoutPage(driver, wait, action);
        homePage.womenCategoryButton();
        homePage.choosingPantsCategory();
        //Adding first product via left side shopping options and adding it directly to shopping cart
        productsPage.sizeCategoryList(sizeNumber1);
        productsPage.colorCategoryList(color1);
        productsPage.addingProductToCartDirectlyFromCatalogList(productNameOne);
        softAssert.assertEquals(productsPage.confirmationMessageForSuccessfulAddingProductToCart(), "You added " + productNameOne + " to your shopping cart.");
        productsPage.clearAllShoppingOptions();
        //Adding second product via clicking on the product directly and open single product page to choose and adding to shopping cart
        productsPage.choosingProductDirectlyFromCatalogList(productNameTwo);
        singleProduct.scrollToAddToWish();
        ShareData.setPriceOfProductChosenFromCatalog(singleProduct.priceOfProduct());
        singleProduct.choosingSizeOrColor(sizeNumber2);
        singleProduct.choosingSizeOrColor(color2);
        singleProduct.addToCartButton();
        softAssert.assertEquals(productsPage.confirmationMessageForSuccessfulAddingProductToCart(), "You added " + productNameTwo + " to your shopping cart.");
        productsPage.shoppingCartButton();
        //Shopping cart window pop-up assert of name, color, size and price of the chosen products
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameTwo).contains(productNameTwo));
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameTwo).contains(sizeNumber2));
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameTwo).contains(color2));
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameTwo).contains(ShareData.getSharePriceOfProductChosenFromCatalog()));
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameOne).contains(productNameOne));
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameOne).contains(sizeNumber1));
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameOne).contains(color1));
        softAssert.assertTrue(productsPage.productsInShoppingCart(productNameOne).contains(ShareData.getSharePriceOfProductAddedDirectlyFromCatalog()));
        String subTotalSum = productsPage.subtotalSumForBothProductsInShoppingCart();
        softAssert.assertEquals(subTotalSum.replace("$",""), ShareData.totalSumOfProductPrice(ShareData.getSharePriceOfProductChosenFromCatalog(), ShareData.getSharePriceOfProductAddedDirectlyFromCatalog()));
        productsPage.shoppingCartCheckout();
    }

    @Test(priority = 30, dependsOnMethods = "addAndCheckoutProductInShoppingCartByClickingItems", dataProvider = "informationForShippingAddress", dataProviderClass = DataProviders.class)
    public void checkoutPage(String email, String firstName, String lastName, String company, String address1, String address2, String address3, String city, String state, String zipCode, String country, String phoneNumber) throws InterruptedException {
        ShareData.setCheckoutPageArg(email, firstName, lastName, company, address1, address2, address3, city, state, zipCode, country, phoneNumber);
        LumaCheckoutPage checkoutPage = new LumaCheckoutPage(driver, wait, action);
        softAssert = new SoftAssert();
        String productNameOne = ShareData.getShareProductNameOne();
        String productNameTwo = ShareData.getShareProductNameTwo();
        //Checking if both of products are present in order summary that is checkout page
        softAssert.assertEquals(checkoutPage.assertingCheckoutPage(), "Shipping Address");
        softAssert.assertEquals(checkoutPage.assertingOrderSummary() , "Order Summary");
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(productNameOne));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(ShareData.getShareSizeNumber1()));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(ShareData.getShareColor1()));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(ShareData.getSharePriceOfProductAddedDirectlyFromCatalog()));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(productNameTwo));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(ShareData.getShareSizeNumber2()));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(ShareData.getShareColor2()));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(ShareData.getSharePriceOfProductChosenFromCatalog()));
        checkoutPage.scrollToShippingMethods();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customer-email']"))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']"))).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lastname']"))).sendKeys(lastName);
        checkoutPage.companyName(company);
        checkoutPage.streetAddressOne(address1);
        checkoutPage.streetAddressTwo(address2);
        checkoutPage.streetAddressThree(address3);
        checkoutPage.city(city);
        checkoutPage.stateOrProvinceDropDownList(state);
        checkoutPage.zipOrPostalCode(zipCode);
        checkoutPage.countryDropDownList(country);
        checkoutPage.phoneNumber(phoneNumber);
        checkoutPage.scrollToNextButton();
        checkoutPage.shoppingMethods();
        checkoutPage.nextButtonClick();
    }

    @Test(priority = 40, dependsOnMethods = "checkoutPage")
    public void reviewAndPaymentsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='billing-address-details']")));
        System.out.println(driver.findElement(By.xpath("//div[@class='billing-address-details']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='billing-address-details']")).getText(), ShareData.getShareFirstName() + " " + ShareData.getShareLastName() + "\n" +
                ShareData.getShareAddress1() + ", " + ShareData.getShareAddress2() + ", " + ShareData.getShareAddress3() + "\n" +
                ShareData.getShareCity() + ", " + ShareData.getShareState() + " " + ShareData.getShareZipCode() + "\n" +
                ShareData.getShareCountry() + "\n" +
                ShareData.getSharePhoneNumber() + "\n" +
                "Edit");
    }
}
