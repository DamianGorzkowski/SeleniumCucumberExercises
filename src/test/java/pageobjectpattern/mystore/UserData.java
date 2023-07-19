package pageobjectpattern.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserData {
    private String email;
    private String password;

    public UserData(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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



