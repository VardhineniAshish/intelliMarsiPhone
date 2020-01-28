package intellimars;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class IntelliMARSiPhone {
	public IOSDriver driver;
	public DesiredCapabilities caps;
	public MobileElement funnel;
	public MobileElement map;
	public MobileElement sort;
	public MobileElement back;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// Passing Desired Capabilities
		caps = new DesiredCapabilities();
		caps.setCapability("app", "/Users/Ashishv/Desktop/IntelliMARS.ipa");
		caps.setCapability("deviceName", "iPhone");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("udid", "50566ae7a20151b7a5fbbece43d508c376ee2d4f");
		caps.setCapability("platformVersion", "12.4");
		caps.setCapability("xcodeOrgId", "X45K6MGNL2");
		caps.setCapability("XcodeSigningId", "iPhone Developer");
		caps.setCapability("showIOSLog", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("showXcodeLog", "true");
		caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// MobileElement Allow = (MobileElement)
		// driver.findElementByAccessibilityId("Allow");
		// driver.wait.until(ExpectedConditions.alertIsPresent());
		// if(driver.findElementByAccessibilityId("Allow").isDisplayed()) {
		// driver.findElementByAccessibilityId("Allow").click();
		// }
		/*
		 * if(Allow.isDisplayed()) { Allow.click();
		 * //System.out.print("if condition executed"); } else {
		 * System.out.print("Allow not displayed");
		 * 
		 * }
		 */
		// LOGIN
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
				.clear();
		Reporter.log("User name is cleared");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
				.sendKeys("567829");
		Reporter.log("User Name is entered");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
				.sendKeys("mars1");
		Reporter.log("Password is entered");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
				.clear();
		Reporter.log("URL is cleared");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
				.sendKeys("https://imarsetfqa.phxa.com");
		Reporter.log("URL is entered");
		driver.findElementByAccessibilityId("Sign In").click();
		Reporter.log("Cicked on Sign In");

		/*
		 * if(driver.findElementByAccessibilityId("Yes").isDisplayed()) {
		 * driver.findElementByAccessibilityId("Yes").click(); } else {
		 * System.out.print("Yes not displayed"); } if
		 * (driver.findElementById("Allow Once").isDisplayed()) {
		 * driver.findElementById("Allow Once").click(); } else {
		 * System.out.print("Allow Once not displayed"); }
		 */
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		/// Boolean b= driver.findElementByAccessibilityId("Yearly, not selected, Link
		// Bar.").isEnabled();
		// Assert.assertTrue(b);
	}

	/*
	 * @BeforeMethod public void clickMenu() throws MalformedURLException {
	 * 
	 * driver.findElementByAccessibilityId("Menu line").click();
	 * 
	 * 
	 * }
	 */
	@BeforeMethod
	public void waitforit() {

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test(groups = "Dashboard", priority = 1)
	public void dashoard() {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Redemptions\"]").click();
		Reporter.log("Clicked on Redemtions tab in Dasboard");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Net\"]").click();
		Reporter.log("Clicked on Net tab in Dasboard");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Assets\"]").click();
		Reporter.log("Clicked on Assets tab in Dasboard(Top Products)");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Purchases\"]").click();
		Reporter.log("Clicked on Purchases tab in Dasboard");
		// click on grind line

		driver.findElementByAccessibilityId("Grid line").click();
		Reporter.log("Clicked on Grid view in Top Products");
		// Switch to cardline in opened screen

		driver.findElementByAccessibilityId("Card line").click();
		Reporter.log("Clicked on Card Line View in Opened Grid view");
		// Refresh the Cardline view
		driver.findElementByAccessibilityId("Reload line").click();
		Reporter.log("Card Line View is refreshed");
		// Swithback to gridline view
		driver.findElementByAccessibilityId("Grid line").click();
		Reporter.log("Switched back to Grid View");
		// Refresh Gridline view
		driver.findElementByAccessibilityId("Reload line").click();
		Reporter.log("Grid View Refreshed");
		// Navigate Back to Dashboard
		MobileElement back = (MobileElement) driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]");
		back.click();
		Reporter.log("Navigated Back");

	}

	@Test(groups = "Dashboard2", priority = 2)
	public void dashboard2() {

		driver.findElementByName("Dashboard 2").click();
		Reporter.log("Dashboard2 opened");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Tabs in Monthly Sales Trend Dashboard
		driver.findElementByAccessibilityId("Redemptions").click();
		Reporter.log("Redemtions in monthly Sales Trend Is Clicked");
		driver.findElementByAccessibilityId("Net").click();
		Reporter.log("Net in monthly Sales Trend Is Clicked");
		driver.findElementByAccessibilityId("Purchases").click();
		Reporter.log("Purchases in monthly Sales Trend Is Clicked");
		// Tabs in MOnthly Assets Trend Dashboard
		driver.findElementByAccessibilityId("Quarterly").click();
		Reporter.log("Quaterly in Asset Trend is Clicked");
		driver.findElementByAccessibilityId("Yearly").click();
		Reporter.log("Yearly in Asset Trend is Clicked");
		driver.findElementByAccessibilityId("Monthly").click();
		Reporter.log("Monthly in Asset Trend is Clicked");
		MobileElement MN = (MobileElement) driver.findElementByAccessibilityId("Monthly");

		/*
		 * //Top Tickets Dropdown Dimension dim = driver.manage().window().getSize();
		 * int height = dim.getHeight(); int width = dim.getWidth(); int x = width/2;
		 * int startY= (int) (height*0.80); int endY= (int) (height*0.20);
		 * 
		 * //driver.swipe(x, startY, x, endY, 500); MobileElement DP= (MobileElement)
		 * driver.findElementByAccessibilityId("Prior Month"); /*TouchAction TA = new
		 * TouchAction(driver); TA.longPress(MN).moveTo(DP).release().perform();
		 * DP.click(); driver.findElementByName("Cancel").click();
		 * driver.findElementByAccessibilityId("Prior Month").click();
		 * driver.findElementByName("Prior Day").click();
		 */

	}

	@Test(groups = "Rep", priority = 3)

	public void rep() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked in Menu");
		driver.findElementByAccessibilityId("Rep").click();
		Reporter.log("Clicked on Rep in Menu");

		// Click on First Name and enter Fname
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on First Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys("First Name");
		Reporter.log("First Name is entered");

		// Click on Last Name and enter Lname

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Last Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys("Last Name");
		Reporter.log("Last Name is entered");
		// Click and enter Firm Name

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeTextField")
				.sendKeys("Firm Name");
		Reporter.log("Firm Name is entered");

		// Office Name

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeTextField")
				.sendKeys("Office Name");
		Reporter.log("Office Name is Entered");
		// city

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on City");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeTextField")
				.sendKeys("City");
		Reporter.log("City Name is entered");
		// State

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on State");
		driver.findElementByAccessibilityId("Alabama").click();
		Reporter.log("State is Selected");
		// Zip

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[13]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Zip");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[13]/XCUIElementTypeTextField")
				.sendKeys("12345");
		Reporter.log("Zip code is entered");
		// Radius

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[15]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Radius");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[15]/XCUIElementTypeTextField")
				.sendKeys("10");
		Reporter.log("Radius is entered");
		// Apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");

		// Sorting
		MobileElement sort = (MobileElement) driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]");
		sort.click();
		Reporter.log("Clicked on Sorting Icon");
		driver.findElementByAccessibilityId("First Name").click();
		Reporter.log("Sorted by First Name");
		// Filter and cancel
		MobileElement funnel = (MobileElement) driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]");
		funnel.click();
		Reporter.log("Clicked on Funnel Icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Cancel the Filter");

	}

	@Test(groups = "Reps Near Me", priority = 4)

	public void repsnearme() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Reps Near Me").click();
		Reporter.log("Clicked on Reps near me");

		// click on map and navigate back

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clcked on Map Icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back");

		// Sorting
		// driver.findElementByAccessibilityId("Reorder line").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]").click();
		Reporter.log("Click on Sorting Icon");
		driver.findElementByAccessibilityId("First Name").click();
		Reporter.log("Sorted By First Name");
		// click on filter and cancel
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on Filter Icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel");
		// Navigate back

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back");

	}

	@Test(groups = "Team", priority = 5)

	public void team() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Teams").click();
		Reporter.log("Clicked on Team Option");
		// Select & Type First name

		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton").click();
		Reporter.log("Clicked on First Name");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField").sendKeys("First Name");
		Reporter.log("Entered First Name");

		// select & type last name

		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton").click();
		Reporter.log("Clicked on Last Name");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField").sendKeys("Last Name");
		Reporter.log("Entered Last Name");

		// Select & Type Firm Name

		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeButton").click();
		Reporter.log("Clicked on Firm Name");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeTextField").sendKeys("Firm Name");
		Reporter.log("Entered Last Name");

		// select & type office name

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeTextField")
				.sendKeys("Office Name");
		;
		Reporter.log("Entered Office Name");

		// select & type City name
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on City");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeTextField")
				.sendKeys("City");
		Reporter.log("City is Entered");
		// Select & type state

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on State");
		driver.findElementByAccessibilityId("Alabama").click();
		Reporter.log("State is selected");
		// select and type zip

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[13]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked o Zip Code");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[13]/XCUIElementTypeTextField")
				.sendKeys("12345");
		Reporter.log("Entered Zip Code");

		// Select & type radius

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[15]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Radius");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[15]/XCUIElementTypeTextField")
				.sendKeys("10");
		Reporter.log("Radius is entered");
		// Click on Apply

		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		// map
		// driver.findElementByAccessibilityId("Map button").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map Icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Nv=avigated back from back page");

		// Sorting
		// driver.findElementByAccessibilityId("Reorder line").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]").click();
		Reporter.log("Clicked on Sort icon");
		driver.findElementByAccessibilityId("First Name").click();
		Reporter.log("Sorted by first name");

		// Filter & cancel
		// driver.findElementByAccessibilityId("Funnel line").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel button");

	}

	@Test(groups = "Teams Near Me", priority = 6)

	public void teamsnearme() {

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Reporter.log("User Name is entered");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Reporter.log("User Name is entered");
		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Teams Near Me").click();
		Reporter.log("Clicked on Teams Near Me");
		// maps

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map Icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated from Map Page");
		// Sort

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]").click();
		Reporter.log("Clicked on Sort icon");
		driver.findElementByAccessibilityId("First Name").click();
		Reporter.log("Sorted by First Name");
		// Funnel and cancel
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on Funnel Icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel Button");
		// Navigate back
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated Back");

	}

	@Test(groups = "Office", priority = 7)
	public void office() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Office").click();
		Reporter.log("Clicked on Office");
		// select and enter Firm Name

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys("Firm Name");
		Reporter.log("Firm Name is entered");
		// Select and enter office name

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys("Office Name");
		Reporter.log("Office Name is entered");
		// select city

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on City");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeTextField")
				.sendKeys("City");
		Reporter.log("City is entered");
		// Select State
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on State");
		driver.findElementByAccessibilityId("Alabama").click();
		Reporter.log("Selected Alabama State");
		// enter zip
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Zip");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeTextField")
				.sendKeys("12345");
		;
		Reporter.log("Entered Zip");
//enter radius
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Radius");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeTextField")
				.sendKeys("10");
		Reporter.log("Entered Radius");
		// apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");

		// map
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map Icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back form map page");
		// sort

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]").click();
		Reporter.log("Clicked on Sort Icon");
		driver.findElementByAccessibilityId("Office Name").click();
		Reporter.log("Sorted By Office Name");
		// Filter and cancel

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on Filter Icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel Button");
		// Navigate back
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back");

	}

	@Test(groups = "Offices Near Me", priority = 8)
	public void officesnearme() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu Icon");
		driver.findElementByAccessibilityId("Offices Near Me").click();
		Reporter.log("Clicked on Offices Near Me");
		// sort
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]").click();
		Reporter.log("Clicked on Sort Icon");
		driver.findElementByAccessibilityId("Office Name").click();
		Reporter.log("Sorted By Office Name");
		// map
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map Icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from Map Page");
		// Filter and cancel

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on Funnel Icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel Button");
		// Navigate back
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back");
	}

	@Test(groups = "Firm", priority = 9)
	public void firm() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu Icon");
		driver.findElementByAccessibilityId("Firm").click();
		Reporter.log("Clicked on Firm in Menu");
		// Firm Name
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys("Firm Name");
		Reporter.log("Entered Firm Name");
		// Office Name
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys("Office Name");
		Reporter.log("Entered Office Name");
		// City
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on City");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeTextField")
				.sendKeys("City");
		Reporter.log("Entered City");
		// State
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeButton")
				.click();
		Reporter.log("Click on City");
		driver.findElementByAccessibilityId("Alabama").click();
		Reporter.log("Alabama State is selected");
		// apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		// sort
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]").click();
		Reporter.log("Clicked on Sorting icon");
		driver.findElementByAccessibilityId("Office Name").click();
		Reporter.log("Sorted by office name");
		// map
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map Icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from Map Page");
		// Filter and cancel

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on Funnel Icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel Button");
		// Navigate back
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated Back");

	}

	@Test(groups = "Product", priority = 10)
	public void product() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Product").click();
		Reporter.log("Clicked on Product in Menu");
		// click & type product code
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Type");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys("Pcode");
		Reporter.log("Product Code is entered");
		// click & type title

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Title");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys("PTitle");
		Reporter.log("Entered Product Title");
		// click & type type

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Type");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeTextField")
				.sendKeys("PType");
		Reporter.log("Entered Product Type");
		// Click & type Group

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Group");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeTextField")
				.sendKeys("PGroup");
		Reporter.log("Product Group is entered");
		// apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Aplly button");

		// Map
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map Button");
		// verify tabs
		driver.findElementByAccessibilityId("Redemptions").click();
		Reporter.log("Clicked on Redemptions Tab");
		driver.findElementByAccessibilityId("Net").click();
		Reporter.log("Clicked on Net tab");
		driver.findElementByAccessibilityId("Assets").click();
		Reporter.log("Clicked on Assets Tab");
		driver.findElementByAccessibilityId("Purchases").click();
		Reporter.log("Clicked on Purchases Tab");
		driver.findElementByAccessibilityId("Current Year").click();
		Reporter.log("Clicked on Current Year Tab");
		driver.findElementByAccessibilityId("Prior Month").click();
		Reporter.log("Clicked on Prior Month Tab");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back");
		// Verify groups & types options

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Groups\"]").click();
		Reporter.log("Clicked on Groups");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Types\"]").click();;
		Reporter.log("Clicked on Types");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Products\"]").click();;
		Reporter.log("Clicked on Products");
		// verify sorting
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reorder line\"]").click();
		Reporter.log("Clicked on Sorting Icon");
		driver.findElementByAccessibilityId("Product Code").click();
		Reporter.log("Sorted by product Code");
		// Verify Filter and cancel

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel Button");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated Back");
	}

	@Test(groups = "Star Report", priority = 11)
	public void starreport() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("STAR Report").click();
		Reporter.log("Selected STAR Report from Menu");

	
		// Tabs in STAR REPORT
		driver.findElementByAccessibilityId("Sales").click();
		Reporter.log("Clicked on Slaes");
		driver.findElementByAccessibilityId("Adjustments").click();
		Reporter.log("Clicked on Adjustments");
		driver.findElementByAccessibilityId("Quick View").click();
		Reporter.log("Clicked on Quick View");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated Back");
	}

	@Test(groups = "general", priority = 12)
	public void general() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("General").click();
		Reporter.log("Selected General in Menu");
		// Setting Tab
		driver.findElementByAccessibilityId("Settings").click();
		Reporter.log("Clicked on Settings Tab");

		

		driver.findElementByAccessibilityId("OK").click();
		Reporter.log("Click on OK if exists");

	
		// help tab
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Help\"]").click();
		Reporter.log("Clicked on Help");
		// Logs Tab
		driver.findElementByAccessibilityId("Logs").click();
		Reporter.log("Clicked on Logs");
		driver.findElementByAccessibilityId("MarsSendEmail").click();
		Reporter.log("Clciked on Send Email");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel Button");

		driver.findElementByAccessibilityId("Clear").click();
		Reporter.log("Clear the logs icon is clicked");
		driver.findElementByAccessibilityId("OK").click();
		Reporter.log("Clicked on OK");
		// About Tab
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"About\"]").click();
		Reporter.log("Click on ABout");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated Back");
	}

	@Test(groups = "feedback", priority = 13)
	public void feedback() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Feedback").click();
		Reporter.log("Clicked on Feedback in Menu");

		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Click on Cancel button");
		driver.findElementByAccessibilityId("Delete Draft").click();
		Reporter.log("Click on Delete Draft");
	}

	@Test(groups = "Signout", priority = 14)
	public void signout() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Sign Out").click();
		Reporter.log("Clicked on Sign Out in Menu");

		driver.findElementByAccessibilityId("Continue").click();
		Reporter.log("Clicked on COntinue in notification");

		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Sign Out").click();
		Reporter.log("Clicked on Signout");
		driver.findElementByAccessibilityId("Sign Out").click();
		Reporter.log("Choosed to sign out");
		driver.findElementByAccessibilityId("Sign In").isEnabled();
		Reporter.log("Verifed if login page is shown after logout");
	}

	/*@AfterTest
	public void generatereport() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.createTest("");
		logger.log(Status.INFO, )
		
	}
*/
}
