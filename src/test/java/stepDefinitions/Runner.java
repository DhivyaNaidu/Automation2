package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)                                                                                     
//@CucumberOptions(features = "src/test/resources/featureFiles/BookingFlow.feature", plugin = { "pretty", "json:target/cucumber.json","html:target/CucumberHTMLReport" }, monochrome = true, tags = { "@JBS_SC01_TC01" }) 
@CucumberOptions(features = "src/test/resources/featureFiles/BookingFlow.feature", plugin = {"junit:target/cuc_report.xml"}, monochrome = true, tags = { "@JBS_SC01_TC01" }) 
public class Runner {

}
 