package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

public class BasePage {
//this class contains constructor which will initiate the driver
 public	WebDriver driver;

 public BasePage(WebDriver driver)
{
 this.driver=driver;
 PageFactory.initElements(driver, this);


}






}
