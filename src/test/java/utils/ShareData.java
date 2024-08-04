package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ShareData {
    public static String shareFirstName;
    public static String shareLastName;
    public static String shareAddress1;
    public static String shareAddress2;
    public static String shareAddress3;
    public static String shareCity;
    public static String shareState;
    public static String shareZipCode;
    public static String shareCountry;
    public static String sharePhoneNumber;
    public static String shareShippingMethod;

    public static String shareProductNameOne;
    public static String shareProductNameTwo;
    public static String shareSizeNumber1;
    public static String shareSizeNumber2;
    public static String shareColor1;
    public static String shareColor2;

    public static String sharePriceOfProductAddedDirectlyFromCatalog;
    public static String sharePriceOfProductChosenFromCatalog;

    public static String shareShippingMethodsPrice;
    public static String shareShippingMethodsText;

    public static String shareRegisterFirstName;
    public static String shareRegisterLastName;
    public static String shareProxyEmail;

    public static void setCheckoutPageArg(String firstName, String lastName, String address1, String address2, String address3, String city, String state, String zipCode, String country, String phoneNumber, String shippingMethod) {
        shareFirstName = firstName;
        shareLastName = lastName;
        shareAddress1 = address1;
        shareAddress2 = address2;
        shareAddress3 = address3;
        shareCity = city;
        shareState = state;
        shareZipCode = zipCode;
        shareCountry = country;
        sharePhoneNumber = phoneNumber;
        shareShippingMethod = shippingMethod;
    }

    public static String getShareFirstName() {
        return shareFirstName;
    }

    public static String getShareLastName() {
        return shareLastName;
    }

    public static String getShareAddress1() {
        return shareAddress1;
    }

    public static String getShareAddress2() {
        return shareAddress2;
    }

    public static String getShareAddress3() {
        return shareAddress3;
    }

    public static String getShareCity() {
        return shareCity;
    }

    public static String getShareState() {
        return shareState;
    }

    public static String getShareZipCode() {
        return shareZipCode;
    }

    public static String getShareCountry() {
        return shareCountry;
    }

    public static String getSharePhoneNumber() {
        return sharePhoneNumber;
    }

    public static String getShippingMethod() {
        return shareShippingMethod;
    }

    //Storing products arguments for sharing with different test case
    public static void setProductPageArg(String sizeNumber1, String sizeNumber2, String color1, String color2, String productNameOne, String productNameTwo) {
        shareProductNameOne = productNameOne;
        shareProductNameTwo = productNameTwo;
        shareSizeNumber1 = sizeNumber1;
        shareSizeNumber2 = sizeNumber2;
        shareColor1 = color1;
        shareColor2 = color2;
    }

    public static String getShareProductNameOne() {
        return shareProductNameOne;
    }

    public static String getShareProductNameTwo() {
        return shareProductNameTwo;
    }

    public static String getShareSizeNumber1() {
        return shareSizeNumber1;
    }

    public static String getShareSizeNumber2() {
        return shareSizeNumber2;
    }

    public static String getShareColor1() {
        return shareColor1;
    }

    public static String getShareColor2() {
        return shareColor2;
    }

    //Price of the product that is added directly to shopping cart from the catalog
    public static void setPriceOfProductAddedDirectlyFromCatalog(String priceOfProductAddedDirectlyFromCatalog) {
        sharePriceOfProductAddedDirectlyFromCatalog = priceOfProductAddedDirectlyFromCatalog;
    }

    public static String getSharePriceOfProductAddedDirectlyFromCatalog() {
        return sharePriceOfProductAddedDirectlyFromCatalog.replace("$", "");
    }

    //Price of the product that is chosen directly from Catalog and after add to shopping cart
    public static void setPriceOfProductChosenFromCatalog(String priceOfProductChosenFromCatalog) {
        sharePriceOfProductChosenFromCatalog = priceOfProductChosenFromCatalog;
    }

    public static String getSharePriceOfProductChosenFromCatalog() {
        return sharePriceOfProductChosenFromCatalog.replace("$", "");
    }

    //Sum of both prices of the products
    public static String totalSumOfProductPrice(String num1, String num2) {
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double totalSum = n1 + n2;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.00", decimalFormatSymbols);
        return decimalFormat.format(totalSum);
    }

    public static String orderTotalSumOfProductsAndShippingMethod(String num1, String num2, String shippingMethod){
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double n3 = Double.parseDouble(shippingMethod);
        double totalSum = n1 + n2 + n3;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.00", decimalFormatSymbols);
        return decimalFormat.format(totalSum);
    }
    //Storing shipping methods price
    public static void setShippingMethodsPrice(String price) {
        shareShippingMethodsPrice = price;
    }

    public static String getShareShippingMethodsPrice() {
        return shareShippingMethodsPrice;
    }

    //Storing shipping methods text
    public static void setShippingMethodsText(String text) {
        shareShippingMethodsText = text;
    }

    public static String getShareShippingMethodsText() {
        return shareShippingMethodsText;
    }

    public static void setProxyEmailStoring(String proxyEmail) {
        shareProxyEmail = proxyEmail;
    }

    public static String getProxyEmailStoring() {
        return shareProxyEmail;
    }

    public static void setRegisterFirstNameAndLastName(String firstName, String lastName){
        shareRegisterFirstName = firstName;
        shareRegisterLastName = lastName;
    }

    public static String getShareRegisterFirstName() {
        return shareRegisterFirstName;
    }

    public static String getShareRegisterLastName() {
        return shareRegisterLastName;
    }


}
