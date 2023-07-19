package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressFormPage {
    @FindBy(id = "field-alias")
    private WebElement alias;
    @FindBy(id = "field-address1")
    private WebElement address;
    @FindBy(id = "field-city")
    private WebElement city;
    @FindBy(id = "field-postcode")
    private WebElement zipCode;
    @FindBy(id = "field-id_country")
    private  WebElement country;
    @FindBy(id = "field-phone")
    private WebElement phone;
    @FindBy(css = ".form-control-submit")
    private WebElement saveButton;

    public NewAddressFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void addressFormFill(UserData userData) {
        alias.sendKeys(userData.getAlias());
        address.sendKeys(userData.getAddress());
        city.sendKeys(userData.getCity());
        zipCode.sendKeys(userData.getZipCode());
        country.sendKeys(userData.getCountry());
        phone.sendKeys(userData.getPhone());

    }
    public void clickSaveButton() {
        saveButton.click();
    }

}
