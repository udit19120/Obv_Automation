package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.Used_Buy_From_Dealer_Auto_Page;
import com.obv.qa.pages.Used_Sell_To_Dealer_Auto_Page;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Used_Buy_From_Dealer_Auto_Page_Test extends TestBase {
    Used_Buy_From_Dealer_Auto_Page used_buy_from_dealer_auto_page;
    String sheet = "Used_Buy_Dealer_Auto";

    public Used_Buy_From_Dealer_Auto_Page_Test()
    {
        super();
    }



    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        used_buy_from_dealer_auto_page=new Used_Buy_From_Dealer_Auto_Page();
    }

    @DataProvider
    public Object[][] getVehicleData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getVehicleData")
    public void FormTest1(String my_vehicle,String my_kms_driven, String auto_in_vehicle) throws InterruptedException {
        used_buy_from_dealer_auto_page.newFillForm(my_vehicle, my_kms_driven, auto_in_vehicle);
    }



    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }
}


//    Honda Amaze 2021 1.2 E MT PETROL BS6