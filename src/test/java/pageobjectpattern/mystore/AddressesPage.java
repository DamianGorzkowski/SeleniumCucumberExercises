package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressesPage {
    @FindBy(css = ".addresses-footer span")
    private WebElement createNewAddress;
    @FindBy(css = ".alert li")
    private WebElement addressConfirmInfo;
//    @FindBy(css = ".alert li")
//    private WebElement addressSuccessfulCreationPanel;
    @FindBy(xpath = "//div[2]/article/div[2]/a[2]/span")
    private WebElement deleteButtonAddress;

    public void clickCreateNewAddress() {
        createNewAddress.click();
    }


    public AddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

//    public void checkIfAddressIsAdded() {
//        assertTrue(addressSuccessfulCreationPanel.isDisplayed());
//        String panelText = addressSuccessfulCreationPanel.getText();
//        assertEquals("Address successfully added!", panelText);
//    }
    public void deleteAddress() {
        deleteButtonAddress.click();
    }
}

