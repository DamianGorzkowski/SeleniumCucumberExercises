package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {

    @FindBy(id = "field-email")
    private WebElement emailInputBox;
    @FindBy(id = "field-password")
    private WebElement passwordInputBox;

    public void fillLogInForm(UserData userData) {
        emailInputBox.sendKeys();

    }


}
