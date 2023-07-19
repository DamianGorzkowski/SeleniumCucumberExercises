package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectpattern.mystore.*;

import java.time.Duration;

public class Exercise1SeleniumCucumber {
    private WebDriver driver;
    private MyStoreMainPage myStoreMainPaige;
    private UserData userData;
    private LogInPage logInPage;
    private AddressesPage addressesPage;
    private NewAddressFormPage newAddressFormPage;

    @Given("^([^ ]+) opened in Google Chrome")
    public void openInGoogleChrome(String url) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.userData = new UserData(driver);
        this.myStoreMainPaige = new MyStoreMainPage(driver);
        this.logInPage = new LogInPage(driver);
        this.addressesPage = new AddressesPage(driver);
        this.newAddressFormPage = new NewAddressFormPage(driver);


        driver.get(url);
    }
    @And("Sign in button clicked")
    public void clickSignInButton() {
        myStoreMainPaige.clickSignInButton();
    }
    @When("Login and password entered in log form")
    public void enterLoginAndPassword() {
        logInPage.fillLogInForm(userData.setEmail("damiangorzkowski@gmail.com").setPassword("1234567890"));
    }
    @And("SIGN IN button clicked")
    public void clickSingInButtonOnLogInPage() {
        logInPage.clickSignInButtonOnLogInPage();
    }
    @And("Tile Addresses clicked in the bottom menu")
    public void clickLinkAddresses () {
        logInPage.clickLinkAddresses();
    }
    @And("Create new address button clicked")
    public void clickCreateNewAddress () {
        addressesPage.clickCreateNewAddress();
    }

    @And("New address form filled with {string} {string} {string} {string} {string} {string}")
    public void addressFormFill(String alias, String address, String city, String zipcode, String country, String phone) {
        newAddressFormPage.addressFormFill(userData.setAlias(alias).setAddress(address).setCity(city).setZipCode(zipcode).setCountry(country).setPhone(phone));


    }
//    And Save button clicked
//    Then Will check if the data in the added address is correct.
//    And Will delete the above address by clicking "delete"
//    And Will check if the address has been deleted

}










