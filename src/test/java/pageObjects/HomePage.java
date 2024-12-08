package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

public	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//li//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(xpath="//li//a[text()='Login']") WebElement lnkLogin;
	
public	void clickmyAccount()
	{

		lnkMyAccount.click();
	}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin()
{
	lnkLogin.click();
}
	
	
}
