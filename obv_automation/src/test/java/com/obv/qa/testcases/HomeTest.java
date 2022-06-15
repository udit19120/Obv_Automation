package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Home;
import com.obv.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

//@Listeners(TestUtil.class)
public class HomeTest extends TestBase{
	Home home;
	String sheet = "VehicleHome";
	
	public HomeTest() throws FileNotFoundException {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialization();
	}

	@DataProvider
	public Object[][] getVehicleData(){
		Object data[][] = TestUtil.getTestData(sheet);
		return data;
	}

	@Test
	public void homePageTitleTest()
	{
		String title=home.validateHomePageTitle();
		Assert.assertEquals(title, "Used Car, Bike, Scooter, Mobile, Real Estate, Jobs,Jewellery Price Valuation Tool | OBV");

	}

	@Test(dataProvider = "getVehicleData", enabled = false)
	public void FormTest1(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms) {
		home.newFillForm(my_category, my_make, my_model, my_year, my_trim, my_kms);
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
