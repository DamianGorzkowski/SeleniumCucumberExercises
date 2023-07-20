package cucumber;

import io.cucumber.java.en.And;

import org.openqa.selenium.WebDriver;

import pageobjectpattern.mystore.*;


public class Exercise2SeleniumCucumber {
    private WebDriver driver;
    private MyStoreMainPage myStoreMainPaige;

    @And("Back to Main Page")
    public void backToMainPage () {
        myStoreMainPaige.backToMainPage();
    }

}