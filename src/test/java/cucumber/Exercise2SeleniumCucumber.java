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


public class Exercise2SeleniumCucumber {
    private WebDriver driver;
    private MyStoreMainPage myStoreMainPaige;
    private UserData userData;
    private LogInPage logInPage;
    private AddressesPage addressesPage;
    private NewAddressFormPage newAddressFormPage;
    private PurchasingProcess purchasingProcess;
    private UserAccountOptions userAccountOptions;
    private WebElement hummingBirdPrintedSweaterDiscount;
    private WebElement orderReferenceNumber;
    private WebElement orderNumberInOrderHistory;
    private  WebElement orderStatus;
    private  WebElement totalValue;
    private  WebElement totalValueInOrderHistory;
    private String orderNumberAfterPlaceOrder;
    private String totalValueAfterPlaceOrder;


    @Given("^([^ ]+) opened in Google Chrome v2")
    public void openInGoogleChrome(String url) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.userData = new UserData(driver);
        this.myStoreMainPaige = new MyStoreMainPage(driver);
        this.logInPage = new LogInPage(driver);
        this.addressesPage = new AddressesPage(driver);
        this.newAddressFormPage = new NewAddressFormPage(driver);
        this.purchasingProcess = new PurchasingProcess(driver);
        this.userAccountOptions = new UserAccountOptions(driver);
        driver.get(url);
    }
    @When("the user clicks on the Sign in button")
    public void clickSignInButtonOnMainPage() {
    myStoreMainPaige.clickSignInButton();
}
    @And("enters {string} and {string} in the login form")
    public void enterLoginAndPassword(String email, String password) {
        logInPage.fillLogInForm(userData.setEmail(email).setPassword(password)); }
    @And("clicks the SIGN IN button")
    public void clickSingInButtonOnLogInPage() {
        logInPage.clickSignInButtonOnLogInPage();
    }
    @And("goes back to the Main Page")
    public void backToMainPage () {
        myStoreMainPaige.backToMainPage();
    }



    @And("selects the Hummingbird Printed Sweater for purchase")
    public void clickHummingbirdPrintedSweater () {
        myStoreMainPaige.clickHummingbird();
    }
    @And("checks if there's a 20% discount on it")
    public void discountCheck () {
        hummingBirdPrintedSweaterDiscount = driver.findElement(By.cssSelector(".discount:nth-child(2)"));
        assertTrue(hummingBirdPrintedSweaterDiscount.isDisplayed());
        String discountText = hummingBirdPrintedSweaterDiscount.getText();
        assertEquals("SAVE 20%", discountText);
    }

    @And("selects size M")
    public void selectSize() {
        purchasingProcess.selectSize();
    }
    @And("chooses 5 pieces according to the test parameters")
    public void setQuantity() {
        purchasingProcess.setQuantity();
    }


    @And("adds the product to the shopping cart")
    public void addToCart() {
        purchasingProcess.addToCart();
    }
    @And("proceeds to the checkout option")
    public void proceedToCheckout() {
        purchasingProcess.proceedToCheckout();

    }
    @And("confirms the delivery address")
    public void deliveryConfirm() {
        purchasingProcess.clickContinueButtonOnAddress();
    }

    @And("chooses the pick-up in-store delivery method")
    public void clickContinueButtonOnShippingMethod () {
        purchasingProcess.clickContinueButtonOnShippingMethod();
    }
    @And("selects the payment option - Pay by Check")
    public void payByCheckOption () {
        purchasingProcess.payByCheckOption();
        purchasingProcess.termsOfUse();
    }

    @And("clicks on 'order with an obligation to pay'")
    public void placeOrder () {
        purchasingProcess.placeOrderButton();
        orderReferenceNumber = driver.findElement(By.id("order-reference-value"));
        orderNumberAfterPlaceOrder = orderReferenceNumber.getText();

        totalValue = driver.findElement(By.cssSelector(".total-value > td:nth-child(2)"));
        totalValueAfterPlaceOrder = totalValue.getText();
    }
    @And("saves a screenshot")
    public void saveScreenshot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "exercise 2", "order-placed" + currentDateTime + ".png"));
    }

    @And("goes to the order history and details")
    public void entersOrderHistoryByUserName () {
        myStoreMainPaige.enterUserAccountByName();
        userAccountOptions.clickOrderHistory();
    }
    @And("checks if the order is listed with the status 'Awaiting check payment'")
    public void orderStatusCheck () {
        orderStatus = driver.findElement(By.cssSelector("tr:nth-child(1) .label"));
        assertTrue(orderStatus.isDisplayed());
        String orderStatusAwait = orderStatus.getText();
        assertEquals("Awaiting check payment", orderStatusAwait);

    }
    @Then("verifies if the total amount matches the order placed two steps earlier.")
    public void orderInformationCheck() {
        orderNumberInOrderHistory = driver.findElement(By.cssSelector("tbody > tr:nth-child(1) > th"));
        String orderNumber = orderNumberInOrderHistory.getText();
        assertEquals(orderNumberAfterPlaceOrder, "Order reference: " + orderNumber);

        totalValueInOrderHistory = driver.findElement(By.cssSelector("tr:nth-child(1) > .text-xs-right"));
        String totalValue = totalValueInOrderHistory.getText();
        assertEquals(totalValue, totalValueAfterPlaceOrder);
    }
    @And("Quit Driver")
    public void quitDriver() {
        driver.quit();
    }



}