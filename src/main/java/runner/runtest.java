package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "stepDef",
        tags = "@Checkout",
        plugin = {"pretty", "html:target/HTML_Report.html"}
)

public class runtest {

}
