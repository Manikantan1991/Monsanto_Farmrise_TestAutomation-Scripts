package util;

import java.util.NoSuchElementException;

import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class select_Crop {

	//AndroidDriver driver;

public   void select_crop(AndroidDriver driver) throws Exception
{
	/*try {
			driver.findElementByXPath("//android.widget.TextView[@text='"+cropName+"']");
			driver.findElementByXPath("//android.widget.TextView[@text='"+cropName+"']").click();
			driver.findElementById("com.climate.farmrise:id/btn_Done").click();
			driver.findElementById("com.climate.farmrise:id/btn_allow_proceed").click();
			Reporter.log("Crop page Appeared and Crop has been selected");
	} 
	
	catch  (Exception e ) 
	{
		Reporter.log("Crop page doesnot appear. Looks like CROP is already selected on this device.");
	}
	
}
*/

try {
	
		boolean seeds = false;

		if (seeds == true) {

		driver.findElementByXPath("//android.widget.TextView[@text='Beetroot']").click();
		Reporter.log("Crop page Appeared and Crop has been selected");
		Thread.sleep(2000); // Proceed After Selecting a crop

		driver.findElementById("com.climate.farmrise:id/btn_Done").click();

		// Allow Access to device Location

		driver.findElementById("com.climate.farmrise:id/btn_allow_proceed").click();

	}

	else {
		//driver.findElementById("com.climate.farmrise:id/action_home").click();
		Reporter.log("Crop page doesnot appear. Looks like CROP is already selected on this device.");

	}
}

catch (Exception e) {

	System.out.println("--------Unable to Select crop---------------");
	throw e;
}

}








}

