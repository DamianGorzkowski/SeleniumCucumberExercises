package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectpattern.mystore.AddressesPage;
import pageobjectpattern.mystore.LogInPage;
import pageobjectpattern.mystore.MyStoreMainPage;
import pageobjectpattern.mystore.UserData;

import java.time.Duration;

public class Exercise1SeleniumCucumber {
    private WebDriver driver;
    private MyStoreMainPage myStoreMainPaige;
    private UserData userData;
    private LogInPage logInPage;
    private AddressesPage addressesPage;

    @Given("^([^ ]+) opened in Google Chrome")
    public void openInGoogleChrome(String url) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.userData = new UserData(driver);
        this.myStoreMainPaige = new MyStoreMainPage(driver);
        this.logInPage = new LogInPage(driver);
        this.addressesPage = new AddressesPage(driver);

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

//    And New address form filled with '<Alias>' '<Address>' '<City>' '<Zip/postal code>' '<Country>' '<Phone>'
//    And Save button clicked
//    Then Will check if the data in the added address is correct.
//    And Will delete the above address by clicking "delete"
//    And Will check if the address has been deleted

}










