package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectpattern.mystore.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise1SeleniumCucumber {
    private WebDriver driver;
    private MyStoreMainPage myStoreMainPaige;
    private UserData userData;
    private LogInPage logInPage;
    private AddressesPage addressesPage;
    private NewAddressFormPage newAddressFormPage;
    private WebElement addressSuccessfulCreationPanel;

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
    public void clickSignInButtonOnMainPage() {
        myStoreMainPaige.clickSignInButton();
    }

    @When("{string} and {string} entered in log form")
    public void enterLoginAndPassword(String email, String password) {
        logInPage.fillLogInForm(userData.setEmail(email).setPassword(password));
    }

    @And("SIGN IN button clicked")
    public void clickSingInButtonOnLogInPage() {
        logInPage.clickSignInButtonOnLogInPage();
    }

    @And("Tile Addresses clicked in the bottom menu")
    public void clickLinkAddresses() {
        logInPage.clickLinkAddresses();
    }

    @And("Create new address button clicked")
    public void clickCreateNewAddress() {
        addressesPage.clickCreateNewAddress();
    }

    @And("New address form filled with {string} {string} {string} {string} {string} {string}")
    public void addressFormFill(String alias, String address, String city, String zipcode, String country, String phone) {
        newAddressFormPage.addressFormFill(userData.setAlias(alias).setAddress(address).setCity(city).setZipCode(zipcode).setCountry(country).setPhone(phone));
    }

    @And("Save button clicked")
    public void clickSaveButtonOnForm() {
        newAddressFormPage.clickSaveButton();
    }
    //    @Then("Will check if the data in the added address is correct.")
//    public void checkIfAddressIsCorrectlyAdded() {
//        addressesPage.checkIfAddressIsAdded();
//    }
    @Then("Will check if the data in the added address is correct.")
    public void checkIfAddressIsAdded() {
        addressSuccessfulCreationPanel = driver.findElement(By.cssSelector(".alert li"));
        assertTrue(addressSuccessfulCreationPanel.isDisplayed());
        String panelText = addressSuccessfulCreationPanel.getText();
        assertEquals("Address successfully added!", panelText);
    }
    @And("Will take screenshot of added address")
    public void saveScreenshot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "qwant-search-" + currentDateTime + ".png"));
    }

        @And("The above address is deleted")
        public void deleteAddress () {
            addressesPage.deleteAddress();
        }
    @And("Will check if the address has been deleted")
    public void checkIfAddressIsDeleted() {
        addressSuccessfulCreationPanel = driver.findElement(By.cssSelector(".alert li"));
        assertTrue(addressSuccessfulCreationPanel.isDisplayed());
        String panelText = addressSuccessfulCreationPanel.getText();
        assertEquals("Address successfully deleted!", panelText);
    }


    @And("Quit Driver for better performance")
    public void quitDriver() {
        driver.quit();
    }

    }











