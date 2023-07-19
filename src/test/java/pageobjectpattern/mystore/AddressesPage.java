package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
    @FindBy(css = ".addresses-footer span")
    private WebElement createNewAddress;

    public void clickCreateNewAddress() {
        createNewAddress.click();
    }


    public AddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
