package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*data is valid  - login success  -test pass --logout
 * data is valid  --login failed  ---test fail
 * 
 * 
 * 
 * data is invalid---login success--test fail ---logout
 * data is invalid ---login failed---test pass
 */



public class TC_003_LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")//getting dataprovider from different class
	public void verify_LoginDDT(String email,String pwd,String exp) throws InterruptedException {
		
		
		logger.info("******starting TC_003_LoginDDT*****");
		try {
		      //homePage
				HomePage hp=new HomePage(driver);
				hp.clickmyAccount();
				hp.clickLogin();
				
				//LoginPage
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
			
				Thread.sleep(3000);

				MyAccountPage macp=new MyAccountPage(driver);
				boolean targetPage=macp.isMyAcccountPageExist();
				
				if(exp.equals("valid")){
					if(targetPage==true) {
					

						macp.clickLogout();
						Assert.assertTrue(true);
					}
					
					else {
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equals("invalid")) {
                      if(targetPage==true) {
						
						macp.clickLogout();
						Assert.assertTrue(false);
				}
                      
                      else {
  						Assert.assertTrue(true);

                      }	

	}
				}catch(Exception e) {
					Assert.fail();
				}
		Thread.sleep(3000);
				logger.info("******finished TC_003_LoginDDT*****");

	}
	
}
