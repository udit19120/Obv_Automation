package com.obv.qa.pages;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//a[text()='Used Car Price']")
    WebElement UsedCar;


    @FindBy(xpath = "//a[text()='Used Bike Price']")
    WebElement UsedBike;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement LoginDropDown;


    //a[text()='User Login ']


    @FindBy(xpath = "//a[text()='Used Vehicle Price']")
    WebElement UsedVehicle;




    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public void ScrollToUsedCar()
    {

        js.executeScript("arguments[0].scrollIntoView()", UsedCar);

    }

    public UserLoginPage clickOnUserLogin()
    {
        LoginDropDown.click();
        driver.findElement(By.xpath("//a[text()='User Login ']")).click();
        return new UserLoginPage();
    }


    public void ScrollToUsedBike()
    {
        js.executeScript("arguments[0].scrollIntoView()", UsedBike);
    }

    public void ScrollToUsedVehicle()
    {
        js.executeScript("arguments[0].scrollIntoView()", UsedVehicle);
    }

    public UsedCarPage clickOnUserCarLink() throws InterruptedException {
        ScrollToUsedCar();

        Thread.sleep(5000);
//        UsedCar.click();
        js.executeScript("arguments[0].click()", UsedCar);
        return new UsedCarPage();
    }


    public UsedBikePage clickOnUserBikeLink() throws InterruptedException {
        ScrollToUsedBike();

        Thread.sleep(5000);
        js.executeScript("arguments[0].click()", UsedBike);
        return new UsedBikePage();
    }


    public UsedVehiclePage clickOnUsedVehicleLink() throws InterruptedException {
        ScrollToUsedVehicle();

        Thread.sleep(5000);
        js.executeScript("arguments[0].click()", UsedVehicle);
        return new UsedVehiclePage();
    }

    public EnterpriseLoginPage clickOnEnterpriseLogin() {

        LoginDropDown.click();
        driver.findElement(By.xpath("//a[text()='Enterprise Login']")).click();
        return new EnterpriseLoginPage();
    }
}
