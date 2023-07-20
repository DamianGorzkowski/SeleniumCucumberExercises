package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreMainPage {
    private WebDriver driver;
    @FindBy(css = "a > .hidden-sm-down")
  private WebElement signInButton;

    @FindBy(css = ".logo")
    private WebElement myStoreLogo;
    @FindBy(css = ".logout")
    private WebElement logoMyStore;



    public MyStoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton () {
        signInButton.click();
    }
    public void backToMainPage() {
        myStoreLogo.click();
    }
    public void clickSignOutButton() {
        logoMyStore.click();

    }

}
