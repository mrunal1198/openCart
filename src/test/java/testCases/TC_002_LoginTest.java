package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups={"Master","sanity"})
	public void verify_login() {
		logger.info("*****starting TC_002_LoginTest******* ");
		try {
		//homePage
		HomePage hp=new HomePage(driver);
		
		hp.clickmyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage macp=new MyAccountPage(driver);
		boolean targetPage=macp.isMyAcccountPageExist();
		Assert.assertEquals(targetPage, true,"login failed");
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("*****finished TC_002_LoginTest******* ");
		

	}
	
}
