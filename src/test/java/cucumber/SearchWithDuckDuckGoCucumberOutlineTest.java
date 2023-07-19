package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/cucumber/features/search_with_duck_duck_go_outline.feature",
        plugin = {"pretty","html:out"})
public class SearchWithDuckDuckGoCucumberOutlineTest {
}
