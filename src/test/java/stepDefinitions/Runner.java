package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)                                                                                     
@CucumberOptions(features = "src/test/resources/featureFiles/BookingFlow.feature", plugin = { "pretty", "json:target/cucumber.json","html:target/CucumberHTMLReport" }, monochrome = true, tags = { "@JBS_SC01_TC02" }) 
public class Runner {

}
