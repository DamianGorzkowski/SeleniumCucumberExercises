package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-email")
    private WebElement emailInputBox;

    @FindBy(css = "#footer_account_list > li:nth-child(4) > a")
    private WebElement linkAddresses;
    @FindBy(id = "field-password")
    private WebElement passwordInputBox;
    @FindBy(id = "submit-login")
    private WebElement signInbutton;

    public void fillLogInForm(UserData userData) {
        emailInputBox.sendKeys(userData.getEmail());
        passwordInputBox.sendKeys(userData.getPassword());

    }
    public void clickLinkAddresses() {
        linkAddresses.click();
    }
    public void clickSignInButtonOnLogInPage() {
        signInbutton.click();
    }


}
