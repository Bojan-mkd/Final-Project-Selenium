package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LumaCheckoutPage;
import pages.LumaHomePage;
import pages.LumaProductsCatalogPage;
import pages.LumaSingleProductPage;
import utils.BaseClass;
import utils.DataProviders;
import utils.ShareData;

public class LumaAddAndCheckoutProductsToShoppingCartTest extends BaseClass {

    @Test(dataProvider = "informationForTwoProducts", dataProviderClass = DataProviders.class)
    public void addAndCheckoutProductInShoppingCartByClickingItems(String sizeNumber1, String sizeNumber2, String color1, String color2, String productNameOne, String productNameTwo) throws InterruptedException {
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
        //Checking if both of products are present in order summary
        softAssert.assertEquals(checkoutPage.assertingCheckoutPage(), "Shipping Address");
        softAssert.assertEquals(checkoutPage.assertingOrderSummary(), "Order Summary");
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(productNameOne));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(sizeNumber1));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(color1));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameOne).contains(ShareData.getSharePriceOfProductAddedDirectlyFromCatalog()));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(productNameTwo));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(sizeNumber2));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(color2));
        softAssert.assertTrue(checkoutPage.productsInOrderSummary(productNameTwo).contains(ShareData.getSharePriceOfProductChosenFromCatalog()));
        softAssert.assertAll();
    }
}
