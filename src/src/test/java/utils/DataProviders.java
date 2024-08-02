package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "userInformation")
    public String[][] userInformation(){
        String[][] userInformation = {
                {"Kazuma" , "Satou", "True_Gender_Equ@l!ty"}};
        return userInformation;
    }

    @DataProvider(name = "userInformationError")
    public String[][] userInformationError(){
        String[][] userInformation = {
                {"" , "lastname1", "email1@domain.com", "Passw0rd"},
                {"name2", "", "email2@domain.com", "Passw0rd"},
                {"name3", "lastname3", "", "Passw0rd", "Passw0rd"},
                {"name4", "lastname4", "email4@domain.com", ""},
                {" ", "lastname5", "email5@domain.com", "Passw0rd"},
                {"name6", " ", "email6@domain.com", "Passw0rd",},
                {"name7", "lastname7", " ", "Passw0rd", "Passw0rd"},
                {"name8", "lastname8", "email9@domain.com", " ",}};
        return userInformation;
    }

    @DataProvider(name = "passwordErrorMessage")
    public String[][] passwordErrorMessage(){
        String[][] passwordErrorMessage= {
                {"pass" , "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.", "Password Strength: Weak"},
                {"password", "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.", "Password Strength: Weak"},
                {"Passw0rd", "", "Password Strength: Medium"},
                {"Passw0rd1", "", "Password Strength: Strong"},
                {"Passw0rd123", "", "Password Strength: Very Strong"}};
        return passwordErrorMessage;
    }

    @DataProvider(name = "informationForTwoProducts")
    public String[][] informationForTwoProducts() {
       String[][] informationForProducts = {
                {"28", "29", "Blue", "Black", "Deirdre Relaxed-Fit Capri", "Bardot Capri"}};
       return informationForProducts;
    }

    @DataProvider(name = "informationForShippingAddress")
    public String[][] informationForShippingAddress() {
        String[][] informationForShippingAddress = {
                {"bm@example.com", "b", "m", "Qinshift", "Address1", "Address2", "Address3", "Buffalo", "New York", "14201", "United States", "1234-567"}};
        return informationForShippingAddress;
    }
}
