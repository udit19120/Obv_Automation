package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.New_Vehicle_Auto_Page;
import com.obv.qa.pages.Used_Sell_To_Dealer_Auto_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class New_Vehicle_Auto_Page_Test extends TestBase {
    New_Vehicle_Auto_Page new_vehicle_auto_page;

    String sheet = "New_Vehicle_Auto";

    public New_Vehicle_Auto_Page_Test()
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        new_vehicle_auto_page=new New_Vehicle_Auto_Page();
    }

    @DataProvider
    public Object[][] getNewVehicleAutoData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getNewVehicleAutoData")
    public void FormTest1(String my_vehicle,String my_city, String auto_vehicle_in) throws InterruptedException {
        new_vehicle_auto_page.newFillForm(my_vehicle, my_city, auto_vehicle_in);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }
}

//    Honda Amaze 1.2 E MT PETROL BS6
