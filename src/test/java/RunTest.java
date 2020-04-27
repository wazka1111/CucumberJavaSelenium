import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumberReport/cucumber.json"},
        monochrome = true,
        features = {"src/test/java/features"},
        strict = true,
        glue = {"stepDefinition"},
        tags = {"@selenium"})
public class RunTest {
}
