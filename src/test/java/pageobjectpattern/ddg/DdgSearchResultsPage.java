package pageobjectpattern.ddg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DdgSearchResultsPage {
    @FindBy(css = "ol.react-results--main article h2 a")
    private List<WebElement> results;

    public DdgSearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getSearchResults() {
        List<String> result = new ArrayList<>();

        for(WebElement element : results) {
            result.add(element.getText());
        }

        return result;
    }
}
