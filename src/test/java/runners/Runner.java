package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/test/cucumber-report.json",  "html:target/test/runner"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@booking"}

)
public class Runner extends BaseRunner
{

}