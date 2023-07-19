package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreMainPage {
    @FindBy(css = "a > .hidden-sm-down")
  private WebElement signInButton;



    public MyStoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton () {
        signInButton.click();
    }
}
