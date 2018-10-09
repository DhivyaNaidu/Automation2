package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.WebDriverUtils;

public class BookingFlow extends WebDriverUtils {

	private static final String String = null;

	/**
	 * @author
	 * @description Function is used to click on lets cruise button
	 * @param driver
	 * @return boolean
	 */
	public void clickLetsCruise() throws Exception {
		try {
			//click(ORprop.getProperty("Lucky"));
			driver.manage().window().maximize();
			/*isElementPresent(ORprop.getProperty("LetsCruise"));
			click(ORprop.getProperty("LetsCruise"));
			Boolean pageVerification = isDisplayed(ORprop.getProperty("LetsCruisePage"));
			Assert.assertTrue("Search results are not present", pageVerification);
			App_log.debug("Successfully clicked on Lets cruise button"); */

		} catch (Exception e) {

			App_log.error("Error encountered while clicking on Lets cruise button" + e.getMessage());

			throw (e);
		}
	}

	/**
	 * @author
	 * @description Function is used to select cruise line by Vendor type
	 * @param dataType
	 * @return boolean
	 */
	public void selectCruizeLine(String dataType) throws Exception {
		testData = getDataFromJson(dataType);
		String cruiseLine = testData.get("CruiseLine").toString();

		try {

			App_log.debug("Select Cruise Line");
			click(ORprop.getProperty("ByCruiseLineFilterTab"));
			click(ORprop.getProperty("CruiseLine").replace("{Cruise_Line}", cruiseLine));
			Boolean showdatesbutton = isDisplayed(ORprop.getProperty("ShowDatesBtn"));
			Assert.assertTrue("Successfully selected cruise line", showdatesbutton);

		} catch (Exception e) {

			App_log.error("Error encountered while clicking on Lets cruise button" + e.getMessage());

			throw (e);
		}
	}

	/**
	 * @author
	 * @description Function is used to click on the first cruise from desired cruise line vendor 
	 * @param driver
	 * @return boolean
	 */
	public void selectCruize() throws Exception {
		boolean result = false;
		try {
			String showdatesbutton = ORprop.getProperty("ShowDatesBtn");
			ExplicitWait(showdatesbutton, "Presence", 30);
			App_log.debug("Selecting Cruise");
			forceSleep(40);
			click(ORprop.getProperty("ShowDatesBtn"));
			isElementPresent(ORprop.getProperty("SelectPriceLink"));
			click(ORprop.getProperty("SelectPriceLink"));
			isElementPresent(ORprop.getProperty("Inside"));
			click(ORprop.getProperty("Inside"));
			result = isElementPresent(ORprop.getProperty("Passenger_FirstName"));
			if (result) {
				App_log.debug("Successfully selected cruise");
			}

			else {
				App_log.debug("Unable to select cruise");
			}
		} catch (Exception e) {

			App_log.error("Error encountered while selecting cruise" + e.getMessage());
			result = false;
			throw (e);
		}
	}

	/**
	 * @author
	 * @description Function is used to Enter passenger details like gender,first name, last name, email,dob etc 
	 * @param dataType
	 * @return boolean
	 */
	public void EnterPassengerDetails(String dataType) throws Exception {
		boolean result = false;
		try {
			click(ORprop.getProperty("RemoveTraveler"));
			testData = getDataFromJson(dataType);
			String gender = testData.get("Gender").toString();
			dropDownSelect(ORprop.getProperty("Passenger_GenderDropdown"), gender);
			// Enter first name
			String firstName = testData.get("FirstName").toString();
			EnterText(ORprop.getProperty("Passenger_FirstName"), firstName);
			// Enter last name
			String lastName = testData.get("LastName").toString();
			EnterText(ORprop.getProperty("Passenger_LastName"), lastName);
			// Enter email
			String email = testData.get("Email").toString();
			EnterText(ORprop.getProperty("Passenger_Email"), email);
			// Enter residency country
			String residenceContry = testData.get("ResidenceContry").toString();
			dropDownSelect(ORprop.getProperty("Passenger_ResidentCountry"), residenceContry);
			// Enter dob
			String dob = testData.get("DOB").toString();
			EnterText(ORprop.getProperty("Passenger_DOB"), dob);
			App_log.debug("Click on Find Deals Button");
			click(ORprop.getProperty("FindDealsBtn"));
			String protectcruise = ORprop.getProperty("CardName");
			ExplicitWait(protectcruise, "Presence", 20);
			result = isElementPresent(ORprop.getProperty("CardName"));
			if (result) {
				App_log.debug("Clicked on Find Deals Button");
			} else {
				App_log.debug("Unable to Click on Find Deals Button");
			}
		} catch (Exception e) {

			App_log.error("Error encountered while clicking on find deals button" + e.getMessage());

			throw (e);
		}
	}

	/**
	 * @author
	 * @description Function is used enter card details like name, card number,cvv number and expiry date 
	 * @param dataType
	 * @return boolean
	 */
	public void EnterCardsDetails(String dataType) throws Exception {

		try {
			/*isElementPresent(ORprop.getProperty("ProtectCruize"));
			click(ORprop.getProperty("ProtectCruize"));*/
			testData = getDataFromJson(dataType);
			// Enter Name
			String cardName = testData.get("Name").toString();
			EnterText(ORprop.getProperty("CardName"), cardName);
			// Enter CardNumber
			String cardNumber = testData.get("CardNumber").toString();
			EnterText(ORprop.getProperty("CreditCardNumber"), cardNumber);
			// Enter expiryYear
			String expiryYear = testData.get("ExpiryDate").toString();
			dropDownSelect(ORprop.getProperty("ExpiryYear"), expiryYear);
			// Enter CVV
			String cvv = testData.get("CVV").toString();
			EnterText(ORprop.getProperty("CVV"), cvv);	
			App_log.debug("Successfully entered card details");
		} catch (Exception e) {

			App_log.error("Error encountered while entering card details" + e.getMessage());

			throw (e);
		}
	}

	/**
	 * @author
	 * @description Function is used to enter billing address, city, zipcode and email 
	 * @param dataType
	 * @return nothing 
	 */
	public void EnterBillingAddress(String dataType) throws Exception {

		try {
			
			click(ORprop.getProperty("ProtectCruize"));
			testData = getDataFromJson(dataType);
			// Enter Address
			String address = testData.get("BillingAddress").toString();
			EnterText(ORprop.getProperty("BillingAddress"), address);
			// Enter City
			String city = testData.get("City").toString();
			EnterText(ORprop.getProperty("City"), city);
			// Enter Zipcode
			String zipcode = testData.get("ZipCode").toString();
			EnterText(ORprop.getProperty("ZipCode"), zipcode);
			// Enter CustomerPhoneNo
			String cvv = testData.get("CustomerPhoneNo").toString();
			EnterText(ORprop.getProperty("CustomerPhoneNo"), cvv);
			// Enter Password
			String password = testData.get("Password").toString();
			EnterText(ORprop.getProperty("Password"), password);
			// Enter ConfirmPassword
			String confirmPassword = testData.get("ConfirmPassword").toString();
			EnterText(ORprop.getProperty("ConfirmPassword"), confirmPassword);
			// Enter Email
			String email = testData.get("Email").toString().replace("{AT}", "@").replace("{DOT}", ".");
			EnterText(ORprop.getProperty("Email"), email);
		} catch (Exception e) {

			App_log.error("Error encountered while entering billing address" + e.getMessage());

			throw (e);
		}
	}

	/**
	 * @author
	 * @description Function is used to click on agree terms and conditons
	 *              checkbox
	 * @param driver
	 * @return boolean
	 */
	public void termsandConditions() throws Exception {
		boolean result = false;
		try {
			click(ORprop.getProperty("TermsandConditions"));
			click(ORprop.getProperty("BuyCruizeBtn"));
			result = isElementPresent(ORprop.getProperty("ConfirmationMsg"));

			if (result) {
				App_log.debug("Successfully selected cruise");
			}

			else {
				App_log.debug("Unable to select cruise");
			}

		} catch (Exception e) {

			App_log.error("Error encountered while selecting terms and conditions checkbox" + e.getMessage());

			throw (e);
		}
	}

	/**
	 * @author
	 * @description Function is used to verify confirmation message is displayed
	 *              after booking
	 * @param driver
	 * @return boolean
	 */
	public void verifyconfirmationMessage() throws Exception {
		boolean result = false;
		try {
			result = isElementPresent(ORprop.getProperty("ConfirmationMsg"));
			if (result) {
				App_log.debug("Booking is successful");
			}

			else {
				App_log.debug("Booking is unsuccessful");
			}

		} catch (Exception e) {

			App_log.error("Error encountered while verifying confirmation message" + e.getMessage());
			result = false;
			throw (e);
		}
	}

}
