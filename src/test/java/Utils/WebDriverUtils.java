package Utils;

import java.io.File;

import java.io.IOException;
import java.io.ObjectOutput;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Predicate;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WebDriverUtils extends Exception {
	
	public static WebDriver driver;
	public static AppiumDriver adriver;
	public static WebDriverWait ExplicitwaitObject =null;
	public static Properties prop=SupportUtils.getproperty();
	public static Properties ORprop=SupportUtils.getORproperty();
	public static String[] locatorVal=null;
	public static int explicitWait =60;

	public static JSONObject testData = null;
	public static JSONArray dataArr = null;
	public static String jsonFile = null;
	public static Logger App_log = Logger.getLogger("devpinoyLogger");
	public static DateFormat df;
	public static Date dateobj;

	public static String CommonJSON="CommonData";
	public static String baseFolder="";
	public static File bs;
	public static File sb;
	
	//TWB_ALM specific variable
	public static String gTwbSuiteInstance="";
	public static String gTwbCaseInstance="";
	public static String gTwbstepResponse="";
	public static String gStepStatus="";
	public static String gS3KeyName="";
	public static String gScreenshotName="";
	public static String gStepName="";
	public static String gCaseName="";
	public static String scenarioTestDataSheetName;
	public static String currentTestCaseID;
	public int count = 0;
	public static ArrayList<String> currentScenarioStepsList;
	public static int stepCounter=0;
	
	//application specific variables
	public String gUserName = "";
	
	public List<WebElement> portalLineDetails;
	public List<WebElement> appLineDetails;
	
	String browser = "";
	String version = "";
	String platform = "";
	String screenResolution = "";
	String deviceName="";
	
	
	@SuppressWarnings("deprecation")
	public void launchBrowser() throws Exception {
		
		//String name = getBrowserConfig()
		DesiredCapabilities cap=null;
		
		try
		{
			{//get browser and platform info
			getBrowserConfig();
			
			
				App_log.debug("***************New Scenario*************");
				App_log.debug("Starting "+ browser +" browser on Local System");
				if (browser.equalsIgnoreCase("Firefox"))
				{
	
					
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/drivers/geckodriver.exe");
					driver= new FirefoxDriver();
				}
				else if (browser.equalsIgnoreCase("Chrome"))
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("disable-infobars");
					String os = System.getProperty("os.name").toLowerCase();
					if (!os.contains("win")) {
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/drivers/chromedriver_Mac");
					}
					else
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/drivers/chromedriver.exe");
					
					driver = new ChromeDriver(options);
				}
				else if (browser.equalsIgnoreCase("IE")) {
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/test/drivers/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				App_log.debug(browser + " browser started on Local System");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			ExplicitwaitObject = new WebDriverWait(driver, explicitWait);
		} catch (Exception e) {
			App_log.debug("Unable to launch browser");
			App_log.error(e.getMessage());
			throw (e);
		}

	}


	public static void navigateToUrl() {
		try {
		//	gStepStatus="Failed";
			String env = prop.getProperty("env");
			switch(env)
			{
				case "DEV1":
					driver.get(prop.getProperty("DEV1_URL"));
					App_log.debug("DEV1 URL Entered");
					break;
				case "DEV2":
					driver.get(prop.getProperty("DEV2_URL"));
					App_log.debug("DEV2 URL Entered");
					break;
			}
		//	gStepStatus="Passed";
		} catch (Exception e) {
			App_log.error("Unable to launch URL");
			throw(e);
		}

	}
	
	public static void loadURL(String appURL) {
		try {
			App_log.debug("Opening URL");
			driver.get(appURL);
		}catch(Exception e) {
			App_log.error("Unable to load app url");
			throw(e);
		}
	}

	
	
	
	public static String  getUrl() {
		 return driver.getCurrentUrl();
		

	}
	
	public static void reloadPage() {
		driver.navigate().refresh();
	}

	public static void FindByXPath(String elemnetXpath) {
		driver.findElement(By.xpath(elemnetXpath));
	}

	public static By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "TagName":
			by = By.tagName(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public static void EnterText(String locatorValue, String textToBeEnter) throws InterruptedException{
		try {
			
			locatorVal = locatorValue.split("__");

			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);

			// ExplicitwaitObject.until(ExpectedConditions.presenceOfElementLocated(locator));

			WebElement element = driver.findElement(locator);

			if(element.isDisplayed()||element.isEnabled())
				element.clear();
			for(char i:textToBeEnter.toCharArray()) {
		        String s = new StringBuilder().append(i).toString();
				element.sendKeys(s);
				Thread.sleep(100);
			}
		} catch (NoSuchElementException e) {
			App_log.error("No Element Found to enter text" + e);
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			
				throw (e);
			
		}
	}
	
	public static void EnterTextInReactiveField(String locatorValue, String textToBeEnter) throws InterruptedException{
		try {
			
			locatorVal = locatorValue.split("__");

			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);

			// ExplicitwaitObject.until(ExpectedConditions.presenceOfElementLocated(locator));

			WebElement element = driver.findElement(locator);

			if(element.isDisplayed()||element.isEnabled())
				element.clear();
			for(char i:textToBeEnter.toCharArray()) {
		        String s = new StringBuilder().append(i).toString();
				element.sendKeys(s);
				Thread.sleep(100);
				element.sendKeys(Keys.ARROW_RIGHT);
				Thread.sleep(100);
			}
		} catch (NoSuchElementException e) {
			App_log.error("No Element Found to enter text" + e);
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			
				throw (e);
			
		}
	}

	
	public static void EnterTextAtOnce(String locatorValue, String textToBeEnter) throws InterruptedException{
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			// ExplicitwaitObject.until(ExpectedConditions.presenceOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			if(element.isDisplayed()||element.isEnabled())
			element.clear();
			element.sendKeys(textToBeEnter);
		}catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
	}
		
	}
	
	
	
	public static void switchToFrame(String locatorValue){
		try {
			locatorVal = locatorValue.split("__");

			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);

			// ExplicitwaitObject.until(ExpectedConditions.presenceOfElementLocated(locator));

			WebElement element = driver.findElement(locator);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(element);
			
		} catch (NoSuchElementException e) {
			App_log.error("No Frame Found to Switch to" + e);
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
	}
	
	public static void pressEnter(String locatorValue) {
		try {
			locatorVal = locatorValue.split("__");

			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);

			// ExplicitwaitObject.until(ExpectedConditions.presenceOfElementLocated(locator));

			WebElement element = driver.findElement(locator);
			if (element.isDisplayed() || element.isEnabled())
				element.clear();
			element.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			App_log.error("No Element Found to press enter " + e);
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
	}
	
	public static void hoverAndClick(String locatorToHoverOn,String locatorToClickOn) {
		try {
			locatorVal = locatorToHoverOn.split("__");
			By hoverLocator;
			hoverLocator = locatorValue(locatorVal[0], locatorVal[1]);
			locatorVal = locatorToClickOn.split("__");
			By clickLocator;
			clickLocator = locatorValue(locatorVal[0], locatorVal[1]);
			// ExplicitwaitObject.until(ExpectedConditions.presenceOfElementLocated(locator));
			Actions hoverAndClickAction=new Actions(driver);
			hoverAndClickAction.moveToElement(driver.findElement(hoverLocator)).build().perform();
//			hoverAndClickAction.moveToElement(driver.findElement(clickLocator)).build().perform();
			actionClick(locatorToClickOn);
		} catch (NoSuchElementException e) {
			App_log.error("Eement not found to hover and click" + e);
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
	}

	public static List<WebElement> getWebElement(String locatorType, String locatorValue) {
		try {
			By locator;
			locator = locatorValue(locatorType, locatorValue);
			List<WebElement> elementList = driver.findElements(locator);
			return elementList;
		} catch (Exception e) {
			System.out.println("There is on object avaialable in page using:" + locatorType + "and" + locatorValue);
		}
		return null;

	}

	public static void click(String locatorValue) {
		try {
			locatorVal = locatorValue.split("__");

		By locator;
		locator = locatorValue(locatorVal[0], locatorVal[1]);
		
		//ExplicitwaitObject.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.findElement(locator);
		element.click();
		}
		catch (NoSuchElementException e) {

			App_log.error("No Element Found to click");
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void captureScreenshot(String screenshotname) throws IOException {
		File fs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("./TestResultScreenShot/" + screenshotname + ".png"));
		System.out.println("screenshot taken");
		// getScreenshotAs(Output.FILE)
	}

	public static void rightClickOn(String optionToBeSelect) {
		Actions act = new Actions(driver);
	}

	public static int countForNonWorkingLink(List<WebElement> elemenltList) throws IOException {

		int count = 0;

		for (int i = 0; i < elemenltList.size(); i++) {
			WebElement el = elemenltList.get(i);
			String url = el.getAttribute("href");
			URL urlToBeCheck = new URL(url);

			HttpURLConnection connection = (HttpURLConnection) urlToBeCheck.openConnection();

			// connection.setConnectTimeout(3000);
			connection.connect();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() == 200) {
				System.out.println("link working fine");

			} else {
				count++;
			}
		}
		System.out.println("Total number of non working link==" + count);
		return count;
	}

	// Function to return all dropdrown options
	@SuppressWarnings("null")
	public static List<String> getAllOptions(String locatorValue) {
		List<String> optinonsList = new ArrayList<String>();

		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);
			Select select = new Select(element);
			List<WebElement> alloptions = select.getOptions();
			for (WebElement el : alloptions) {
				String temp = el.getText();
				optinonsList.add(temp);
			}

		} catch (NoSuchElementException e) {
			System.out.println("There is no element available using locator" + locatorVal[0] + "and" + locatorVal[1]);
		}
		return optinonsList;

	}

	// Function will select the value from dropdown on the basis of Index
	public static void selectOptionbyIndex(String locatorValue, int index) {

		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);
			Select s = new Select(element);
			s.selectByIndex(index);

		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
	}
	
	// Function will select the value from dropdown on the basis of Index
	public static void selectOptionbyIndexValue(String locatorValue, String option) {

		try {
			List<String> allPortals = getAllOptions(locatorValue);

			for (int i = 0; i < allPortals.size(); i++) {
				// System.out.println(allPortals.get(i));
				if (allPortals.get(i).equalsIgnoreCase(option)) {
					selectOptionbyIndex(locatorValue, i);

					break;
				}
			}
		} catch (Exception e) {
			App_log.error("Unable to select required portal");
			throw (e);
		}
	}

	// Function will select the value from dropdown on the basis of Index
	public static String getSelectedValue(String locatorValue) {
		String selectedVal;

		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);
			Select s = new Select(element);
			selectedVal = s.getFirstSelectedOption().getText();

		} catch (Exception e) {
			App_log.debug("Unable to select required portal");
			throw (e);
		}
		return selectedVal;
	}

	public static boolean verifyDropDownListContent(String locatorValue, List<String> expectedList) {
		// boolean flag=false;

		List<String> actualList = getAllOptions(locatorValue);

		int exceptedSizeLength = expectedList.size();
		int actualSizeLength = actualList.size();

		if ((exceptedSizeLength == 0 && actualSizeLength == 0) && (exceptedSizeLength != actualSizeLength)) {
			return false;
		}

		else {
			Collections.sort(expectedList);

			Collections.sort(actualList);

			return expectedList.equals(actualList);

		}

	}

	
	public static void captureScreenOnTestFailure(File screenshotName) throws IOException
	{
		
		File fs	=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, screenshotName);
	}

	public boolean isSelected(String locatorValue) {
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);

			ExplicitwaitObject.until(ExpectedConditions.elementToBeClickable(locator));
			WebElement element = driver.findElement(locator);
			if (element.isSelected())
				return true;

			return false;
		} catch (NoSuchElementException e) {
			App_log.error("No Element Found");
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
	}
	
	public boolean dropDownSelect(String locatorValue, String selectionDesired) {
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);

			new Select(driver.findElement(locator)).selectByVisibleText(selectionDesired);

		} catch (NoSuchElementException e) {
			App_log.error("No Element Found");
			throw (e);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
		return false;
	}

	public void switchToAlertMsg(String action) {
		try {
			if (action.equalsIgnoreCase("Accept")) {
				driver.switchTo().alert().accept();
			} else if (action.equalsIgnoreCase("dismiss")) {
				driver.switchTo().alert().dismiss();
			}

		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}

	}

	// this function will read Alert Text
	public String getAlertText() {
		String alertTxt = "";
		try {

			alertTxt = driver.switchTo().alert().getText();

		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
		return alertTxt;
	}

	// adding Json testdata loader
		public JSONObject getDataFromJson(String SheetName, String Datatype)
		   {
			   TestDataLoader dataLoader=new TestDataLoader();
			   testData=dataLoader.getTestData(SheetName, Datatype);
			   return testData;
		}
		
		public JSONObject getDataFromJson(String Datatype)
		   {
			   TestDataLoader dataLoader=new TestDataLoader();
			   testData=dataLoader.getTestData(WebDriverUtils.scenarioTestDataSheetName,WebDriverUtils.currentTestCaseID,Datatype);
			   return testData;
		}
		
		public void getBrowserConfig()
		{
			testData=getDataFromJson("BrowserConfig", "BrowserConfig");
			browser = testData.get("browser_name").toString();
			version = testData.get("version").toString();
			platform = testData.get("platform").toString();
			screenResolution = testData.get("screenResolution").toString();
			deviceName = testData.get("deviceName").toString();
			
		}
		
		
		public void forceSleep(int seconds) throws InterruptedException
		{
			Thread.sleep(seconds*1000);
		}
		
		public String getText(String locatorValue) 
		{
			String textVal="";
			try {
				locatorVal = locatorValue.split("__");
					By locator;
					locator = locatorValue(locatorVal[0], locatorVal[1]);
					WebElement element = driver.findElement(locator);
					
					textVal = element.getText();
			 }	
				catch(NoSuchElementException e)
				{
					//System.out.println("There is no element available using locator"+locatorVal[0]+"and"+locatorVal[1]);
					App_log.debug("There is no element available using locator "+locatorVal[0]+" and "+locatorVal[1]);
					throw(e);
					
				}
				return textVal;
		}
		
	// click on element using Action class
	public static void actionClick(String locatorValue) {
		String s = locatorValue;
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);

			Actions act = new Actions(driver);
			act.click(element).build().perform();

		} catch (NoSuchElementException e) {
			App_log.error("No Element Found to click " + e);
			throw (e);
		}
	}

	// click on element using Action class
	public void actionEnterText(String locatorValue, String textToEnter) {
		// String s =locatorValue;
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);

			element.clear();

			Actions act = new Actions(driver);
			act.sendKeys(element, textToEnter).build().perform();

		} catch (NoSuchElementException e) {
			App_log.error("No Element Found to enter text " + e);
			throw (e);
		}
	}

	// Switch window
	public void switchWindow() throws InterruptedException {
		try {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			String parentWinId = itr.next();
			String childWinId = itr.next();
			driver.switchTo().window(childWinId);
		} catch (NoSuchElementException e) {
			App_log.error("No window Element Found" + e);
			throw (e);
		}
	}

	public void switchToWindow() throws InterruptedException {
		forceSleep(3);
		try {
			String currentWinHandle = driver.getWindowHandle();
			driver.getWindowHandles();
			Set<String> allWinHandles = driver.getWindowHandles();
			// Iterator<String> it = allWinHandles.iterator();
			System.out.println(allWinHandles.size());
			for (String iterator : allWinHandles) {
				if (!iterator.equals(currentWinHandle)) {
					driver.switchTo().window(iterator);
				}
			}

		} catch (NoSuchElementException e) {
			App_log.error("No window Element Found" + e);
			throw (e);
		}

	}

	public void openLinkinNewTab(String locatorValue) {
		String selectAll = Keys.chord(Keys.SHIFT, Keys.RETURN);
		locatorVal = locatorValue.split("__");
		By locator;
		locator = locatorValue(locatorVal[0], locatorVal[1]);
		WebElement element = driver.findElement(locator);

		element.sendKeys(selectAll);
	}

	// this function will remove spaces and new line chracter from the string
	public String replaceSPACEandNEWLINE(String value) {
		String temp;
		try {
			temp = value.replaceAll("\\s", "").replaceAll("\\n", "");
		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
		return temp;
	}

	// this function will remove spaces and new line chracter from the string
	public String removeNEWLINEChar(String value) {
		String temp;
		try {
			temp = value.replaceAll("\\n", "");
		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
		return temp;
	}

	// this function will check whether the element is enabled or disabled
	public boolean isEnable(String locatorValue) {
		boolean flag = false;
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);
			flag = element.isEnabled();

		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
		return flag;

	}

	// this function will check whether the element is available on page or not
	public boolean isDisplayed(String locatorValue) {
		boolean flag = false;
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);
			flag = element.isDisplayed();

		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
		return flag;

	}

	// this function will check whether the element is available on page or not
	public boolean isElementPresent(String locatorValue) {
		// boolean flag=true;
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}

	}

	public String getAttribute(String locatorValue, String attribute) {
		String attributeVal;
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);
			attributeVal = element.getAttribute(attribute);

		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
		return attributeVal;
	}

	public String getTextforListElements(String locatorValue) {
		List<WebElement> allElements;
		String tempElements = "";
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			allElements = driver.findElements(locator);
			// WebElement element = driver.findElement(locator);
			// attributeVal = element.getAttribute(attribute);
			for (int i = 0; i < allElements.size(); i++) {
				tempElements = tempElements + allElements.get(i).getText();
			}

		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
		return tempElements;

	}
	

	// this method will clear the content from textbox
	public void clearContent(String locatorValue) {
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element = driver.findElement(locator);
			element.clear();

		} catch (Exception e) {
			App_log.debug(e.getMessage());
			throw (e);
		}
	}
		
		//click on mouse hover over element using Action class
        public void actionMouseHover(String locatorValue)
        {
               String s =locatorValue;
               try{
                     locatorVal = locatorValue.split("__");
               By locator;
               locator = locatorValue(locatorVal[0], locatorVal[1]);
               WebElement element = driver.findElement(locator);
               
               Actions act = new Actions(driver);
               act.moveToElement(element).build().perform();
               
               }
               catch (NoSuchElementException e) {
                     App_log.error("No Element Found to click" + e.getMessage());
                     throw(e);
               }
        }

        public void stalelement(String locatorValue)
        {
               String s =locatorValue;
               try{
                     locatorVal = locatorValue.split("__");
               By locator;
               locator = locatorValue(locatorVal[0], locatorVal[1]);
               WebElement element = driver.findElement(locator);
               new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
             
               
               }
               catch (NoSuchElementException e) {
                     App_log.error("No Element Found to click" + e.getMessage());
                     throw(e);
               }
        }

        public List<WebElement> getElementList(String locatorValue)
        {
            List<WebElement> allElements;
            try 
            {
		        	locatorVal = locatorValue.split("__");
		        	By locator = locatorValue(locatorVal[0], locatorVal[1]);
		        	allElements = driver.findElements(locator);
		        	
            } 
            catch (Exception e) 
            {
        	App_log.error(e.getMessage());
        	throw(e);
            }
            return allElements;
        }
        
        
      
      //this method will fetch the current date
        public String currentDate()
        {
        	String currentDate;
        	try {
        		df = new SimpleDateFormat("MM/dd/yyyy");
            	dateobj = new Date();
            	
            	currentDate = df.format(dateobj);
            	
			} catch (Exception e) {
				App_log.error("Error while fetching the current date");
				throw(e);
			}
        	return currentDate;
        }
        

        
      //this method will fetch the current date
        public String futureDate(int future_days)
        {
        	String fDate;
        	try {
        		
        		df = new SimpleDateFormat("MM/dd/yyyy");
        		dateobj = new Date();
        		
        		Calendar cal = Calendar.getInstance();
        		cal.setTime(dateobj);
        		cal.add(Calendar.DATE, future_days);
        		dateobj=cal.getTime();
        		
        		//converting Date into String
        		fDate = df.format(dateobj);
			} catch (Exception e) {
				App_log.error("Error while fetching the current date");
				throw(e);
			}
        	
			return fDate;
        }
        
        

	// this function will generate random 10 digit number
	// Explicit wait for any condition
	public void ExplicitWait(String locatorValue, String waitCondition, long waitSeconds) {
		try {
			locatorVal = locatorValue.split("__");
			By locator;
			locator = locatorValue(locatorVal[0], locatorVal[1]);
			WebElement element;

			WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
			
			switch (waitCondition) {
			case "Invisibility":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
				break;
			case "Visibility":
				element=driver.findElement(locator);
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			case "Clickable":
				element=driver.findElement(locator);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			case "Presence":
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				break;
			}
        }
		catch (Exception e) {
			App_log.error("Error while explicit wait - " + e.getMessage());
		}
	}
        
      
        
   

	public void changeImplicitTime(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			App_log.error(e.getMessage());
			throw (e);
		}
	}

}

