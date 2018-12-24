package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import util.ActionUtil;

public class onBoard_screenPages{
	
	@FindBy(xpath="//android.widget.TextView[@text='English']")

	private WebElement English;
	
	
	
	@FindBy(id="com.climate.farmrise:id/btn_Proceed")
	private WebElement ProceedBtn;
	
	
	@FindBy(id="com.climate.farmrise:id/btn_agree")
	private WebElement Termsbtn;


	private AndroidDriver driver;


	private WebElement swipeRightToLeft;
	
	// This is a constructor, as every page need a base driver to find web elements
	public onBoard_screenPages(AndroidDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Select a English Language 
	public void select_Language ()
	{
		English.click();
	}
	
	//Proceed Button 
	public void proceed_Btn()
	{
		ProceedBtn.click();
	}
	
	
	// Terms and Agree and condition
	
	public void terms_condition()
	{
		Termsbtn.click();
	}
	
	
	
	public void swipe_Operation(AndroidDriver<MobileElement> driver)
	
	{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//SwipeRightToLeft on Home Tab 
		try {
			
			ActionUtil util_obj =new ActionUtil();
			util_obj.swipeRightToLeft(driver);
		Reporter.log("Successfully Swipped.");
			
		} catch (InterruptedException e) {
			Reporter.log("Swipe Unsuccesfull.");
		}
	}
	
	
	
	
	


}
