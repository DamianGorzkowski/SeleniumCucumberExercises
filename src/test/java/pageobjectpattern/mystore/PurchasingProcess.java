package pageobjectpattern.mystore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasingProcess {


    @FindBy(css = "#quantity_wanted")
    private WebElement selectQuantity;
    @FindBy(css = ".add-to-cart")
    private WebElement shoppingCart;
    @FindBy(css = ".cart-content-btn > .btn-primary")
    private WebElement proceedToCheckout;
    @FindBy(css = ".text-sm-center > .btn")
    private WebElement proceedToCheckoutSecond;
    @FindBy(css = "#group_1 > option:nth-child(2)")
    private WebElement sizeHummingBird;
    @FindBy(css = "#checkout-addresses-step > div > div > form > div.clearfix > button")
    private  WebElement continueButtonOnAddress;
    @FindBy(css = ".continue:nth-child(2)")
    private  WebElement continueButtonOnShippingMethod;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheckOption;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfUse;
    @FindBy(css = ".ps-shown-by-js > .btn")
    private WebElement placeOrderButton;
    @FindBy(id = "order-reference-value")
    private WebElement orderReference;


    public PurchasingProcess(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void selectSize() {
        sizeHummingBird.click();
    }
    public void setQuantity(){
//        selectQuantity.clear();
        selectQuantity.sendKeys(Keys.DELETE, "5");
//        selectQuantity.click();
//        selectQuantity.click();
//        selectQuantity.click();
//        selectQuantity.click();
    }
    public void addToCart(){
        shoppingCart.click();
    }
    public void proceedToCheckout() {
        proceedToCheckout.click();
        proceedToCheckoutSecond.click();
    }
    public void clickContinueButtonOnAddress() {
        continueButtonOnAddress.click();
    }
    public void clickContinueButtonOnShippingMethod() {
        continueButtonOnShippingMethod.click();
    }
    public void payByCheckOption () {
        payByCheckOption.click();
    }
    public void termsOfUse () {
        termsOfUse.click();
    }
    public void placeOrderButton() {
        placeOrderButton.click();
    }
//    public String setOrderReference() {
//        orderReferenceNumber = orderReference.getText();
//        return orderReferenceNumber;
//    }

}
