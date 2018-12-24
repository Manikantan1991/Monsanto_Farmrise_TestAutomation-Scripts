package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import util.ActionUtil;

public class GovtScheme_Pages {
	
	@FindBy(id="android:id/search_button")

	private WebElement Srchbtn;
	
	
	@FindBy(id="android:id/search_src_text")
	private WebElement SrchBox;
	
	@FindBy(id = "com.climate.farmrise:id/sorry_txt")
	public WebElement txtResult;
 
	
	public GovtScheme_Pages(AndroidDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	

	
	public void SearchBtn()
	{
		Srchbtn.click();
		
	}
	
	
	public void Searchbox()
	{
		
		SrchBox.sendKeys("Kisan");
	}
	
	
	public void Tapon_SrchBx(AndroidDriver<MobileElement> driver)
	{
		try {
			
			ActionUtil util_obj =new ActionUtil();
			util_obj.tapOnentrBtn(driver);
		
		Reporter.log("Successfully Tapped.");
			
		} catch (InterruptedException e) {
			Reporter.log("Tap Unsuccesfull.");
		}
	}
	
	public boolean VerifyResult(AndroidDriver<MobileElement> driver,String result) {
		if (txtResult.getText().equals(result))
			return true;
		else
			return false;
	}
 
	

	
	
}
