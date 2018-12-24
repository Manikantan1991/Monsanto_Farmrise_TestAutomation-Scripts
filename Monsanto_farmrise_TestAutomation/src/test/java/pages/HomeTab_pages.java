package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import util.ActionUtil;


public class HomeTab_pages

{
	
	private AndroidDriver driver;
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Home']")

	private WebElement Hometab;
	
	@FindBy(id="com.climate.farmrise:id/checkWeatherDetails")
	private WebElement Accessweatherdetails;
	
	

	@FindBy(id="com.climate.farmrise:id/hourlyWeatherForecastScrollView")
	private WebElement Weatherelement;
	
	
	@FindBy(xpath=("//android.widget.TextView[@text='Now']"))
	private WebElement hourElement;
	
	// This is a constructor, as every page need a base driver to find web elements
		public HomeTab_pages(AndroidDriver driver)
		{
			
			PageFactory.initElements(driver, this);
		}
		
	
	
	
	public void homeScreen()
	{
		Hometab.click();
	}
	
	
	
	public void weather_Details()
	{
		Accessweatherdetails.click();
	}
	
	
	
	
	public void checkweather_timings(AndroidDriver<MobileElement> driver) throws InterruptedException
	{
		
		
		ActionUtil util_obj =new ActionUtil();
		
		util_obj.checkweather_details(driver);
		Reporter.log(" check weather details from Now to 23hrs");
		
		
		
		
		
	}
	
	
	
	
	
}
 
	
	
	
	
	
	
	
	
	
	
	

