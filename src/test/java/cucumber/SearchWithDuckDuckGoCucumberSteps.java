package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectpattern.ddg.DdgMainPage;
import pageobjectpattern.ddg.DdgSearchResultsPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class SearchWithDuckDuckGoCucumberSteps {
    private WebDriver driver;
    private DdgMainPage mainPage;
    private DdgSearchResultsPage resultsPage;

    @Given("^([^ ]+) opened in web browser$")
    public void openInBrowser(String url) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.mainPage = new DdgMainPage(driver);
        this.resultsPage = new DdgSearchResultsPage(driver);

        driver.get(url);
    }

    @When("Phrase {string} entered in search input box")
    public void searchPhraseEnteredInSearchInput(String phrase) {
        // when
        mainPage.enterSearchPhrase(phrase);
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        mainPage.clickSearchButton();
    }

    @Then("First {int} results contain phrase {string}")
    public void checkSearchResults(int count, String phrase) {
        String phraseLowerCase = phrase.toLowerCase();
        List<String> searchResults = resultsPage.getSearchResults();
        for (int i = 0; i < count; i++) {
            String resultLowerCase = searchResults.get(i).toLowerCase();
            if(!resultLowerCase.contains(phraseLowerCase)) {
                fail(String.format("Phrase %s NOT found in result: %s", phrase, resultLowerCase));
            }
        }
    }

    @And("Quit driver")
    public void quitDriver() {
        driver.quit();
    }

    @Then("Save screenshot")
    public void saveScreenshot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "qwant-search-"+currentDateTime+".png"));
    }
}
