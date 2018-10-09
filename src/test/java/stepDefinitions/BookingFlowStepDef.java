package stepDefinitions;

import Utils.WebDriverUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageClasses.BookingFlow;
import pageClasses.LaunchApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.After;


public class BookingFlowStepDef extends LaunchApplication{

   // private final WebDriver driver = new FirefoxDriver();
    BookingFlow Bookflow= new BookingFlow();
    
    @Given("^I am on the Google search page$")
    public void I_visit_google() {
    	try {
			openGoogleUrl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }

   @When("^I search for \"(.*)\"$")
     public void search_for(String query) {
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys(query);
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
   }

  


	

	@Given("^User Launches JetBlue Application$")
	public void launch_portal() throws Exception
	{
			openUrl();
		    //verifyUrlLoaded();
		
		
	}
	
	@Given("^User Launches Google$")
	public void launch_google() throws Exception
	{
			openGoogleUrl();
		
	}
	
	@When("^User clicks on I am feeling Lucky$")
	public void clickLetsCruise() throws Exception
	{
	
		Bookflow.clickLetsCruise();
				
	}	
	
	@Then("^User filter cruise by'(.+)'$")
	public void selectCruizeLine(String Cruiseline) throws Exception
	{
	
		Bookflow.selectCruizeLine (Cruiseline);
				
	}	
	@And("^User selects a cruise from search results$")
	public void selectCruize() throws Exception
	{
	
		Bookflow.selectCruize();
				
	}	
	@And("^User Enter the '(.+)'$")
	public void EnterPassengerDetails(String Passengerdetails) throws Exception
	{
	
		Bookflow.EnterPassengerDetails(Passengerdetails);
				
	}	
	@And("^Enters '(.+)'$")
	public void EnterCardsDetails(String Carddetails) throws Exception
	{
	
		Bookflow.EnterCardsDetails(Carddetails);
				
	}	
	@And("^User Enters '(.+)'$")
	public void EnterBillingAddress(String BillingAddress) throws Exception
	{
	
		Bookflow.EnterBillingAddress(BillingAddress);
				
	}	

	@And("^Agree to terms and conditions$")
	public void termsandConditions() throws Exception
	{
	
		Bookflow.termsandConditions();
				
	}	
	
	@And("^Verify Confirmation Message$")
	public void verifyconfirmationMessage() throws Exception
	{
	
		Bookflow.verifyconfirmationMessage();
				
	}	
	
}
