package runners;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/midtrans/cucumber-report.json",  "html:target/midtrans/runner"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@checkout-success"}
)

public class Runner extends BaseRunner {
}
