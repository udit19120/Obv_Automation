package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Used_Buy_From_Individual_Auto_Page extends TestBase {
    @FindBy(xpath = "//a[text()='Or Select A Vehicle']")
    WebElement auto_link;

    WebElement buy_btn;

    WebElement search_vehicle;
    WebElement kms;
    WebElement sub_btn;

    WebElement to_individual;
    public Used_Buy_From_Individual_Auto_Page()
    {
        PageFactory.initElements(driver, this);
        auto_link.click();


        buy_btn=driver.findElement(By.xpath("//a[text()='Buy']"));
        buy_btn.click();

        to_individual=driver.findElement(By.id("checkIndi"));
        Actions actions = new Actions(driver);
        actions.moveToElement(to_individual).click().perform();

        search_vehicle=driver.findElement(By.id("product_title"));
        kms=driver.findElement(By.id("kms_driven"));

        sub_btn=driver.findElement(By.id("check_price_used"));
    }

    public void newFillForm(String my_vehicle,String my_kms_driven, String auto_in_vehicle) throws InterruptedException {
//        search_vehicle.sendKeys(my_vehicle);
        for(int i=0;i<auto_in_vehicle.length();i++)
        {
            search_vehicle.sendKeys(auto_in_vehicle.substring(i,i+1));
            Thread.sleep(1000);
        }

        String x_path_vehicle="//ul[@id='auto-suggest']//li[text()='"+my_vehicle+"']";

        driver.findElement(By.xpath(x_path_vehicle)).click();
        kms.sendKeys(String.valueOf(my_kms_driven));
        sub_btn.click();
    }
}
