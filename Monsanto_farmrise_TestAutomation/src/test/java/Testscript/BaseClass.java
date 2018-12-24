package Testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Generic.Constant;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pages.GovtScheme_Pages;
import pages.HomeTab_pages;
import pages.MoreTab_Pages;
import pages.onBoard_screenPages;
import util.ActionUtil;
import util.ScreenshotHandle;
import util.select_Crop;

public class BaseClass implements Constant {

	AndroidDriver<MobileElement> driver;
	DesiredCapabilities cap;
	ScreenshotHandle device_page = new ScreenshotHandle();

	String sDirPath = System.getProperty("user.dir");

	@BeforeSuite

	public void _setup() throws InterruptedException {

		// set desired capabilities for FarmRise and Honor 7 device

		try {

			cap = new DesiredCapabilities();
			cap.setCapability("automationName", automationName);
			cap.setCapability("platformName", platformName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("UDID", UDID);
			cap.setCapability("autoGrantPermissions", "true");
			// cap.setCapability("appPackage", "com.climate.farmrise");
			// cap.setCapability("appActivity",
			// "com.climate.farmrise.SplashScreen");

			cap.setCapability("app", new File(sDirPath + "/Apk-File/FarmRice.apk").getAbsolutePath());
			System.out.println("Present Project Directory : " + System.getProperty("user.dir"));
			cap.setCapability("fullReset", "false");
			cap.setCapability("noReset", "false");

			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Reporter.log("----------------appium driver initialised----------------");

		}

		catch (Exception e) {
			System.out.println("----------Unable to launch app-------------");
		}

		String windowName = driver.currentActivity();
		Reporter.log("Window name is :" + windowName);

		try {

			if (windowName.contains("SplashScreen")) {
				Reporter.log("Successfully installed.");
			}

			else

			{
				Reporter.log("Installation failed.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 0, groups = "OnBoarding_page")
	
	public void boarding_Testscript() throws Exception {

		// This is to Instantiate Onborading_Pages

		onBoard_screenPages start_up_page = new onBoard_screenPages(driver);

		start_up_page.select_Language();
		device_page.takeScreenshot(driver, "Language_Selection");
		start_up_page.proceed_Btn();
		device_page.takeScreenshot(driver, "Proceed Button");
		start_up_page.terms_condition();
		device_page.takeScreenshot(driver, "Terms and Conditions ");
		Thread.sleep(5000);
		select_Crop crop_selection = new select_Crop();
		crop_selection.select_crop(driver);
		//select_Crop.select_crop(driver, "Cumin seeds");
		// start_up_page.select_crop("Beetroot");

		start_up_page.swipe_Operation(driver);
		device_page.takeScreenshot(driver, "Swipe operation");
		Reporter.log(" Boarding Screen is Sucess Full ");

	}

	@Test(priority = 1, groups = "Home_page", dependsOnMethods = "boarding_Testscript")

	public void homescreen_Testscript() throws InterruptedException, IOException {

		// This is to Instantiate Home Tab
		// HomeTab_pages H = new HomeTab_pages(driver);
		HomeTab_pages main_page = new HomeTab_pages(driver);
		main_page.homeScreen();
		device_page.takeScreenshot(driver, "Home screen page");
		main_page.weather_Details();
		device_page.takeScreenshot(driver, "Weather screen page ");
		main_page.checkweather_timings(driver);
		//main_page.Horizontal_swipe(driver);
		device_page.takeScreenshot(driver, "Access weather and scrollHorizontally Timings page ");

	}

	@Test(priority = 2, groups = "More_page", dependsOnMethods = "boarding_Testscript")

	public void Morepage_Testscript() throws InterruptedException, IOException

	{

		// This is to Instantiate More Tab

		MoreTab_Pages more_page = new MoreTab_Pages(driver);
		Thread.sleep(2000);
		more_page.MoreTab_btn();
		device_page.takeScreenshot(driver, "More Tab page ");
		more_page.GovtScheme();
		device_page.takeScreenshot(driver, "GovtSchemes Tab page ");
		more_page.Scrolling(driver);
		device_page.takeScreenshot(driver, "More Tab page ");

		// This is to Instantiate GovtScheme Tab

		GovtScheme_Pages Govt_page = new GovtScheme_Pages(driver);
		Govt_page.SearchBtn();
		Govt_page.Searchbox();
		Govt_page.Tapon_SrchBx(driver);
		device_page.takeScreenshot(driver, "Search  page under Govt Schemes ");

		if (Govt_page.VerifyResult(driver, "Kisan"))
			Reporter.log("PASSED Test");
		else
			Reporter.log("FAILED Test");

	}

	@AfterSuite

	public void tearDown() {
		if (driver != null) {

			driver.quit();
			Reporter.log("Close the Driver");
		}
	}

}
