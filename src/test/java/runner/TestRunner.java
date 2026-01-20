package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "base"},
        tags = "@US6",
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"},
        dryRun = false
)
public class TestRunner {
}
