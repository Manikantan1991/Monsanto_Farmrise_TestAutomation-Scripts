package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import util.ActionUtil;

public class MoreTab_Pages {
	
	@FindBy(xpath="//android.widget.TextView[@text='More']")

	private WebElement MoreTab;

	
	
	@FindBy(xpath="//android.widget.TextView[@text='Government Schemes']")
	private WebElement GovtSchemes;
	
	// This is a constructor, as every page need a base driver to find web elements
		public MoreTab_Pages(AndroidDriver driver)
		{
			
			PageFactory.initElements(driver, this);
		}
		
		
		//Click on Moretab 
		public void MoreTab_btn()
		{
			MoreTab.click();
		}
		
		//Click on GovtScheme 
		public void GovtScheme()
		{
			GovtSchemes.click();
		}	
		
		
	
	public void Scrolling(AndroidDriver<MobileElement> driver)
	{
		
		
		//swipeBottomToTop on Home Tab 
			try {
			
			ActionUtil util_object =new ActionUtil();
			util_object.swipeBottomToTop(driver);
		
			Reporter.log("Successfully Scrolled.");
			
		} catch (InterruptedException e) {
			Reporter.log("Scroll Unsuccesfull.");
		}
		
		
		
		
	}

	
}