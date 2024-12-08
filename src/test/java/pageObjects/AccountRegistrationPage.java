package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountRegistrationPage extends BasePage {
//we extend baseclass in every pageobject class
	
	public WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']")  WebElement txtlastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")  WebElement confirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement checkPolicy;
	@FindBy(xpath="//button[@value='Continue']")WebElement btnContinue;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tele) {
		txtTelephone.sendKeys(tele);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confPwd) {
		confirmPassword.sendKeys(confPwd);
	}
	public void clickPolicy() {
		checkPolicy.click();
	}
	
	
	public void clickContinue()
	{
		btnContinue.click();
		
	//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//btnContinue.sendKeys(Keys.RETURN);
		
//		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
//		
	}
	
	
	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	
	
	
	
	
}
