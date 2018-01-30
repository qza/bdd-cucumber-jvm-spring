package bdd;

import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;

@ActiveProfiles("test")
@CucumberOptions(plugin = { "pretty", "html:target/cucumber","json:target/cucumber.json" })
public class FeaturesBase {

}
