package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/cucumber/features/exercise_1_selenium_cucumber.feature",
        plugin = {"pretty","html:out"})
public class Exercise1SeleniumCucumberTest {
}
