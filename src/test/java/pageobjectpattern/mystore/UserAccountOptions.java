package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountOptions {
    @FindBy(id = "history-link")
    private WebElement orderHistoryAndDetails;

    public UserAccountOptions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOrderHistory() {
        orderHistoryAndDetails.click();
    }
}
