package com.obv.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obv.qa.base.TestBase;
import org.openqa.selenium.support.ui.Select;

public class Home extends TestBase{
	//page factory
	
	@FindBy(name="category")
	WebElement category;
	
	@FindBy(name="make")
	WebElement make;
	
	@FindBy(name="model")
	WebElement model;
	
	
	@FindBy(name="year")
	WebElement year;
	
	
	@FindBy(name="trim")
	WebElement trim;
	
	@FindBy(name="kms_driven")
	WebElement kms_driven;

	@FindBy(id = "check_price_used_false")
	WebElement submit_btn;
	
	public Home()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}

	public void newFillForm(String my_category, String my_make, String my_model, String my_year, String my_trim, String my_kms)
	{
		Select categorySelect=new Select(category);
		Select makeSelect=new Select(make);
		Select modelSelect=new Select(model);
		Select yearSelect=new Select(year);
		Select trimSelect=new Select(trim);

		categorySelect.selectByValue(my_category);
		makeSelect.selectByValue(my_make);
		modelSelect.selectByValue(my_model);
		yearSelect.selectByValue(my_year);
		trimSelect.selectByValue(my_trim);

		if(my_category.equals("5"))
		{
			System.out.println("This is bicycle case");
			submit_btn.click();
			return;
		}
		kms_driven.sendKeys(my_kms);
		submit_btn.click();
	}
	
}
