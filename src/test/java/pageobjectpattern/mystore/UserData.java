package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserData {
    private String alias;
    private String address;
    private String city;
    private String zipCode;
    private String country;

    public String getAlias() {
        return alias;
    }
    public UserData(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public UserData setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserData setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserData setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public UserData setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserData setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserData setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    private String phone;

    private String email;
    private String password;



    public String getEmail() {
        return email;
    }

    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }
}



