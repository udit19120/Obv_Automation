package com.obv.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.obv.qa.util.TestUtil;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
//	public static ArrayList<Vehicle> data;
	
	public TestBase()
	{
		prop= new Properties();
		
		try 
		{
			FileInputStream ip = new FileInputStream("/home/uditnarang/eclipse-workspace/obv_automation/src/main/java/com/obv/qa/config/config.properties");

			prop.load(ip);
			System.out.println("Loaded");
		}
		
		catch(FileNotFoundException e){
			System.out.println("Hello error here");
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Hello error here");
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() throws FileNotFoundException {
		String browserName= prop.getProperty("browser");

	
		if(browserName.equals("chrome"))
		{
	        System.setProperty("webdriver.chrome.driver", "/home/uditnarang/Downloads/chromedriver_linux64/chromedriver");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
			driver=new ChromeDriver();
		}
		
		//can also add condition for other browsers
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
//		data=TestUtil.getData(TestUtil.TESTDATA_SHEET_PATH);
	}
	
}


//ul[@class="auto-suggest-li"]