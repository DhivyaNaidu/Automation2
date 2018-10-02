package pageClasses;

import java.util.Properties;

import org.openqa.selenium.WebDriver;



import Utils.WebDriverUtils;
import cucumber.api.java.Before;



public class LaunchApplication extends WebDriverUtils {
	
	
	public static String currentScenarioTagName;
	
	
	/**
	 * @author
	 * @description Function is used to launch browser and navigate to application
	 * @param driver
	 * @return boolean
	 */
	
	
	public void openUrl() throws Exception
	{
		try {
			//launchbrowser code
			launchBrowser();
			navigateToUrl();

		} catch (Exception e) {
			App_log.error("Error occured while launching application");
		
			throw(e);
		}
		
		
		
	}
	/**
	 * @author
	 * @description Function is used to launch browser and navigate to application
	 * @param driver
	 * @return boolean
	 */
	
	
	public void openGoogleUrl() throws Exception
	{
		try {
			//launchbrowser code
			launchBrowser();
     		driver.get(prop.getProperty("https://www.google.com"));
			App_log.debug("Google url  Entered");
		} catch (Exception e) {
			App_log.error("Error occured while launching application");
		
			throw(e);
		}
		
		
		
	}
	/**
	 * @author
	 * @description Function is used to check if signup popup is present or not
	 * @param driver
	 * @return boolean
	 */
	public boolean checkIfPopupDisplayed() {
		boolean result = false;
		try {
			App_log.debug("Verifying if Popup is present on homepage");
			result = isElementPresent(ORprop.getProperty("Popup_txt"));

		} catch (Exception e) {
			App_log.error("Error Verifying if Popup is present on homepage or not");
			App_log.error(e.getMessage());
			result = false;
		} finally {
			return result;
		}
	}
	/**
	 * @author
	 * @description Function is used to verify if url is loaded successfully 
	 * @param driver
	 * @return boolean
	 */
	public void verifyUrlLoaded() throws Exception {
		boolean result = false;
		try {
			if(checkIfPopupDisplayed()){
				App_log.debug("Signup popup is present ");
				isElementPresent(ORprop.getProperty("PopupCancel_Btn"));
				click(ORprop.getProperty("PopupCancel_Btn"));
				App_log.debug("Cancelled popup ");
				}
			result=isElementPresent(ORprop.getProperty("LetsCruise"));
			if (result)
				App_log.debug("Successfully launched the URL");
			else
				throw (new Exception(
						"Lets Cruise button is not present"));
		}
			catch (Exception e) {
			App_log.error("Error occured while launching application");
			throw (e);
		}
	}
	

}

