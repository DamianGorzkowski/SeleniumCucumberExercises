package pageobjectpattern.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreMainPage {

    @FindBy(css = "a > .hidden-sm-down")
  private WebElement signInButton;
    @FindBy(css = ".logo")
    private WebElement myStoreLogo;
    @FindBy(css = ".logo")
    private WebElement logoMyStore;
    @FindBy(css = ".js-product:nth-child(2) img")
    private WebElement hummingbirdPrintedSweater;
    @FindBy(id = "group_1")
    private WebElement picklist;
    @FindBy(css = ".account > .hidden-sm-down")
    private WebElement userName;


    public MyStoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void clickSignInButton () {
        signInButton.click();
    }
    public void backToMainPage() {
        myStoreLogo.click();
    }
    public void clickHummingbird() {
        hummingbirdPrintedSweater.click();
    }
    public void enterUserAccountByName () {
        userName.click();
    }


//    public void clickSignOutButton() {
//        logoMyStore.click();
//    }


}
