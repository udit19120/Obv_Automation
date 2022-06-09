package com.obv.qa.testcases;

import com.obv.qa.base.TestBase;
import com.obv.qa.pages.HomeBuyFromIndividual;
import com.obv.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class HomeBuyFromIndividualTest extends TestBase {
    HomeBuyFromIndividual homeBuyFromIndividual;

    String sheet = "VehicleHome";
    TestUtil testUtil;

    public HomeBuyFromIndividualTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        homeBuyFromIndividual=new HomeBuyFromIndividual();
        testUtil=new TestUtil();
    }
    @DataProvider
    public Object[][] getVehicleData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }

    @Test(dataProvider = "getVehicleData")
    public void FormTest1(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms) {
        homeBuyFromIndividual.newFillForm(my_category, my_make, my_model, my_year, my_trim, my_kms);
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
