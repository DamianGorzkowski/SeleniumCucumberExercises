package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectpattern.mystore.MyStoreMainPage;

import java.time.Duration;

public class Exercise1SeleniumCucumber {
    private WebDriver driver;
    private MyStoreMainPage myStoreMainPaige;

    @Given("^([^ ]+) opened in Google Chrome")
    public void openInGoogleChrome(String url) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.myStoreMainPaige = new MyStoreMainPage(driver);
        driver.get(url);
    }
    @And("Sign in button clicked")
    public void clickSignInButton() {
        myStoreMainPaige.clickSignInButton();
    }


}






//    And Sign in button clicked
//    When Login and password entered in log form
//    And Tile 'Addresses' clicked (in the bottom menu)
//    And Create new address button clicked
//    And New address form filled with '<Alias>' '<Address>' '<City>' '<Zip/postal code>' '<Country>' '<Phone>'
//    And Save button clicked
//    Then Will check if the data in the added address is correct.
//    And Will delete the above address by clicking "delete"
//    And Will check if the address has been deleted






}
