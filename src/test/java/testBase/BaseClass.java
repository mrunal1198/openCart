package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static  WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups={"sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
				//loading config.properties file
		     FileReader file=new FileReader("./src//test//resources//config.properties");
		     p=new Properties();//creating object of properties class
		     p.load(file);//this command will load the file
		
		
		//loading log4j2 file 
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		 case "chrome":driver=new ChromeDriver();break;
		 case "edge":driver=new EdgeDriver();break;
		 case "firefox": driver=new FirefoxDriver();break;
		 default: System.out.println("no matching browser..");
		return;
		}
		

	
	//	driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL"));//reading url from property file
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
	      return generatedString;
	}

   public String randomNumber() {
	 String generatedNumber=RandomStringUtils.randomNumeric(5);
	 return generatedNumber;
   }


	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}


	public String captureScreen(String tname)throws IOException {
		String timestamp=new SimpleDateFormat("yyyyMMddhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir"+"\\screenshots\\"+ tname+"_"+timestamp+".png");
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	
	
	

	@AfterClass(groups={"sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
