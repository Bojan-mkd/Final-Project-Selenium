package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ShareData {
    public static String shareEmail;
    public static String shareFirstName;
    public static String shareLastName;
    public static String shareCompany;
    public static String shareAddress1;
    public static String shareAddress2;
    public static String shareAddress3;
    public static String shareCity;
    public static String shareState;
    public static String shareZipCode;
    public static String shareCountry;
    public static String sharePhoneNumber;

    public static String shareProductNameOne;
    public static String shareProductNameTwo;
    public static String shareSizeNumber1;
    public static String shareSizeNumber2;
    public static String shareColor1;
    public static String shareColor2;

    public static String sharePriceOfProductAddedDirectlyFromCatalog;
    public static String sharePriceOfProductChosenFromCatalog;

    public static void setCheckoutPageArg(String email, String firstName, String lastName, String company, String address1, String address2, String address3, String city, String state, String zipCode, String country, String phoneNumber) {
        shareEmail = email;
        shareFirstName = firstName;
        shareLastName = lastName;
        shareCompany = company;
        shareAddress1 = address1;
        shareAddress2 = address2;
        shareAddress3 = address3;
        shareCity = city;
        shareState = state;
        shareZipCode = zipCode;
        shareCountry = country;
        sharePhoneNumber = phoneNumber;
    }

    public static String getShareEmail() {
        return shareEmail;
    }

    public static String getShareFirstName() {
        return shareFirstName;
    }

    public static String getShareLastName() {
        return shareLastName;
    }

    public static String getshareCompany() {
        return shareCompany;
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
    //Storing products arguments for sharing with different test case
    public static void setProductPageArg(String sizeNumber1, String sizeNumber2, String color1, String color2, String productNameOne, String productNameTwo){
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
    public static void setPriceOfProductAddedDirectlyFromCatalog(String priceOfProductAddedDirectlyFromCatalog){
        sharePriceOfProductAddedDirectlyFromCatalog = priceOfProductAddedDirectlyFromCatalog ;
    }

    public static String getSharePriceOfProductAddedDirectlyFromCatalog(){
        return sharePriceOfProductAddedDirectlyFromCatalog.replace("$","");
    }

    //Price of the product that is chosen directly from Catalog and after add to shopping cart
    public static void setPriceOfProductChosenFromCatalog(String priceOfProductChosenFromCatalog){
        sharePriceOfProductChosenFromCatalog = priceOfProductChosenFromCatalog;
    }

    public static String getSharePriceOfProductChosenFromCatalog(){
        return sharePriceOfProductChosenFromCatalog.replace("$","");
    }

    public static String totalSumOfProductPrice(String num1, String num2){
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double totalSum = n1 + n2;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.00", decimalFormatSymbols);
        return decimalFormat.format(totalSum);
    }
}
