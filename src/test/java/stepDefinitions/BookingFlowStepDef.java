package stepDefinitions;

import Utils.WebDriverUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageClasses.BookingFlow;
import pageClasses.LaunchApplication;



public class BookingFlowStepDef extends LaunchApplication{


	BookingFlow Bookflow= new BookingFlow();

	@Given("^User Launches JetBlue Application$")
	public void launch_portal() throws Exception
	{
			openUrl();
		    verifyUrlLoaded();
		
	}
	
	@Given("^User Launches Google$")
	public void launch_google() throws Exception
	{
			openGoogleUrl();
		
	}
	
	@When("^User clicks on Lets Cruise$")
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
