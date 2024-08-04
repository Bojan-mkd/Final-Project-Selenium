package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LumaAccountPage;
import pages.LumaCreateAccountPage;
import pages.LumaHomePage;
import utils.*;

public class LumaRegisterAnAccountTest extends BaseClassBeforeAndAfterMethod {
    //With this test we are testing presents and visibility of webelements
    @Test(priority = 10)
    public void createAccount_elementVisibility() {
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaCreateAccountPage creatingUser = new LumaCreateAccountPage(driver, wait, action);
        SoftAssert softAssert = new SoftAssert();
        homePage.createAccountButton();
        softAssert.assertEquals(creatingUser.createNewAccountText(), "Create New Customer Account");
        softAssert.assertEquals(creatingUser.personalInformationText(), "Personal Information");
        softAssert.assertEquals(creatingUser.firstNameText(), "First Name");
        softAssert.assertTrue(creatingUser.firstNameInput());
        softAssert.assertEquals(creatingUser.lastNameText(), "Last Name");
        softAssert.assertTrue(creatingUser.lastNameInput());
        softAssert.assertEquals(creatingUser.signInInformationText(), "Sign-in Information");
        softAssert.assertEquals(creatingUser.emailText(), "Email");
        softAssert.assertTrue(creatingUser.emailInput());
        softAssert.assertEquals(creatingUser.passwordText(), "Password");
        softAssert.assertTrue(creatingUser.passwordInput());
        softAssert.assertEquals(creatingUser.confirmPasswordText(), "Confirm Password");
        softAssert.assertTrue(creatingUser.confirmPasswordInput());
        softAssert.assertTrue(creatingUser.createAcoountButtonIsDisplayed());
        softAssert.assertAll();
    }
    //Positive testing with existing information for creating user
    @Test(priority = 60, dataProvider = "userInformation", dataProviderClass = DataProviders.class)
    public void createAccount_registrationSuccess(String firstName, String lastName, String password) throws InterruptedException {
        LumaAccountPage accountPage = new LumaAccountPage(driver, wait);
        NavigationHelper.registerAnAccount(driver, action, wait, firstName, lastName, password);
        Assert.assertEquals(accountPage.confirmationMessageForSuccessfulRegistration(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(accountPage.accountPageTitle(), "My Account");
        accountPage.signingOutUserButton();
    }

    @Test(priority = 20, dataProvider = "userInformationError", dataProviderClass = DataProviders.class)
    public void createAccount_registrationError(String firstName, String lastName, String email, String password) {
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaCreateAccountPage creatingUser = new LumaCreateAccountPage(driver, wait, action);
        SoftAssert softAssert = new SoftAssert();
        homePage.createAccountButton();
        creatingUser.scrollToCreateAccaountButton();
        creatingUser.firstName(firstName);
        creatingUser.lastName(lastName);
        creatingUser.email(email);
        creatingUser.password(password);
        creatingUser.confirmPassword(password);
        creatingUser.createAccountButton();
        softAssert.assertEquals(creatingUser.errorMessageForRequiredField(), "This is a required field.");
        softAssert.assertAll();
    }

    @Test(priority = 30, dataProvider = "passwordErrorMessage", dataProviderClass = DataProviders.class)
    public void createAccount_passwordError(String password, String errorMessage, String passwordStrenght) {
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaCreateAccountPage creatingUser = new LumaCreateAccountPage(driver, wait, action);
        SoftAssert softAssert = new SoftAssert();
        homePage.createAccountButton();
        creatingUser.scrollToCreateAccaountButton();
        creatingUser.password(password);
        creatingUser.confirmPassword(password);
        String errorMessageLocator = driver.findElement(By.xpath("//div[@class='mage-error']")).getText();
        String passwordStrenghtLocator = driver.findElement(By.id("password-strength-meter")).getText();
        softAssert.assertEquals(errorMessageLocator, errorMessage);
        softAssert.assertEquals(passwordStrenghtLocator, passwordStrenght);
        softAssert.assertAll();
    }

    @Test(priority = 40)
    public void createAccount_confirmPasswordError() {
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaCreateAccountPage creatingUser = new LumaCreateAccountPage(driver, wait, action);
        SoftAssert softAssert = new SoftAssert();
        String password = "Passw0rd";
        String confirmPassword = "password";
        homePage.createAccountButton();
        creatingUser.scrollToCreateAccaountButton();
        creatingUser.password(password);
        creatingUser.confirmPassword(confirmPassword);
        creatingUser.createAccountButton();
        String errorMessageLocator = driver.findElement(By.id("password-confirmation-error")).getText();
        Assert.assertEquals(errorMessageLocator, "Please enter the same value again.");
        softAssert.assertAll();
    }

    @Test(priority = 50)
    public void createAccount_emailError() {
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaCreateAccountPage creatingUser = new LumaCreateAccountPage(driver, wait, action);
        SoftAssert softAssert = new SoftAssert();
        String email = "@.com";
        homePage.createAccountButton();
        creatingUser.scrollToCreateAccaountButton();
        creatingUser.email(email);
        creatingUser.createAccountButton();
        String errorMessageLocator = driver.findElement(By.id("email_address-error")).getText();
        Assert.assertEquals(errorMessageLocator, "Please enter a valid email address (Ex: johndoe@domain.com).");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "createAccount_registrationSuccess", dataProvider = "userInformation", dataProviderClass = DataProviders.class)
    public void createAccount_checkingForExistingAccount(String firstName, String lastName, String password) {
        LumaCreateAccountPage accountPage = new LumaCreateAccountPage(driver, wait, action);
        LumaHomePage homePage = new LumaHomePage(driver, action);
        LumaCreateAccountPage creatingUser = new LumaCreateAccountPage(driver, wait, action);
        homePage.createAccountButton();
        creatingUser.scrollToCreateAccaountButton();
        creatingUser.firstName(firstName);
        creatingUser.lastName(lastName);
        creatingUser.email(ShareData.getProxyEmailStoring());
        creatingUser.password(password);
        creatingUser.confirmPassword(password);
        creatingUser.createAccountButton();
        Assert.assertEquals(accountPage.errorMessageForExistingAccount(), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
    }
}
