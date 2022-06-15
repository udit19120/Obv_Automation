package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomeBuyFromDealer;
import com.obv.qa.pages.New_Vehicle_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class New_Vehicle_Page_Test extends TestBase {
    New_Vehicle_Page new_vehicle_page;

    String sheet = "New_Vehicle";

    public New_Vehicle_Page_Test()
    {
        super();
    }


    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        new_vehicle_page=new New_Vehicle_Page();
    }

    @DataProvider
    public Object[][] getNewVehicleData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getNewVehicleData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_trim, String  my_city) {
//        new_vehicle_page.newFillForm("1","BMW","3 Series","M340I","Delhi");
//        new_vehicle_page.newFillForm("2","Honda","CB300R","300CC","Delhi");
//        new_vehicle_page.newFillForm("3","TVS","Jupiter","110CC SHEET METAL WHEEL BS6","Delhi");

        new_vehicle_page.newFillForm(my_category, my_make, my_model, my_trim, my_city);

    }


    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
