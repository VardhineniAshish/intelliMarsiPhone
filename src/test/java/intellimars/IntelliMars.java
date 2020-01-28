package intellimars;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
public class IntelliMars {
	public IOSDriver driver;
	public DesiredCapabilities caps;
	
@BeforeTest
public void setUp() throws MalformedURLException {
		//Passing Desired Capabilities
		caps= new DesiredCapabilities();	
		caps.setCapability("app", "/Users/Ashishv/Desktop/IntelliMARS_6200.ipa");
		caps.setCapability("deviceName", "Rajesh iPad");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("udid", "ed48ddd2735d69bb02c94ad521f9a790e0d6eef2");
		caps.setCapability("platformVersion", "13.2");
		caps.setCapability("xcodeOrgId", "X45K6MGNL2");
		caps.setCapability("XcodeSigningId", "iPhone Developer");
		caps.setCapability("showIOSLog", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("showXcodeLog", "true");
		caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	//MobileElement Allow = (MobileElement) driver.findElementByAccessibilityId("Allow");
	//driver.wait.until(ExpectedConditions.alertIsPresent());
	//if(driver.findElementByAccessibilityId("Allow").isDisplayed()) {
		//driver.findElementByAccessibilityId("Allow").click();
	//}
 /*if(Allow.isDisplayed())
	{
		Allow.click();
		//System.out.print("if condition executed");
	}
	else
	{
		System.out.print("Allow not displayed");
	}*/
	//LOGIN
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]").clear();
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]").sendKeys("567829");
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField").clear();
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField").sendKeys("mars1");
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]").clear();
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]").sendKeys("https://imarsetfqa.phxa.com");
	driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign In\"]").click();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	/*if(driver.findElementByAccessibilityId("Yes").isDisplayed()) {
		driver.findElementByAccessibilityId("Yes").click();
	}
	else
	{
		System.out.print("Yes not displayed");
	}
	if (driver.findElementById("Allow Once").isDisplayed()) {
		driver.findElementById("Allow Once").click();
	}
	else
	{
		System.out.print("Allow Once not displayed");
	}*/
	//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	///Boolean b= driver.findElementByAccessibilityId("Yearly, not selected, Link Bar.").isEnabled();
	//Assert.assertTrue(b);
}
	@BeforeMethod
	public void clickMenu() throws MalformedURLException {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//static String enu= "//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]"
	MobileElement Menu = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");	
	Menu.click();
	}
@Test(groups="Dashboard",priority=0)
public void dashoard() {
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElementByAccessibilityId("Dashboard").click();
	driver.findElementByAccessibilityId("Executive").click();
	driver.findElementByAccessibilityId("YTD Sales, not selected, Link Bar.").click();
	driver.findElementByAccessibilityId("Curr Assets, not selected, Link Bar.").click();
	driver.findElementByAccessibilityId("Quarterly, not selected, Link Bar.").click();
	driver.findElementByAccessibilityId("Yearly, not selected, Link Bar.").click();
	driver.findElementByAccessibilityId("Yearly, not selected, Link Bar.").click();
}
}