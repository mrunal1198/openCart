package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest  extends BaseClass{


	


@Test(groups={"Master","Regression"})
public void verify_account_registration() 
{
	logger.info("****************starting TC_001_AccountRegistrationTest***********");
	try {
	HomePage hp=new HomePage(driver);
	
	hp.clickmyAccount();
	logger.info("clicked on MyAccount link");
	
	hp.clickRegister();
	logger.info("clicked on registration link");
	
	
	logger.info("entering customer details");
	AccountRegistrationPage ap=new AccountRegistrationPage(driver);
	ap.setFirstName(randomString().toUpperCase());
	ap.setLastName(randomString().toUpperCase());
	ap.setEmail(randomString()+"@gmail.com");
	ap.setTelephone(randomNumber());
	
	
	String password=randomAlphaNumeric();
	ap.setPassword(password);
	ap.setConfirmPassword(password);
	
	
	ap.clickPolicy();
	
	ap.clickContinue();	
	logger.info("clicked on continue..");
	String confmsg=ap.getConfirmationMsg();
	
	logger.info("validating expected message...");
	if(confmsg.equals("Your Account Has Been Created!")){
		Assert.assertTrue(true);
	}
	else {
		Assert.fail();
	}
	
}
	catch (Exception e){
		logger.error("test failed..");
		
	}
	logger.info("****************finished  TC_001_AccountRegistrationTest***********");
}


}
