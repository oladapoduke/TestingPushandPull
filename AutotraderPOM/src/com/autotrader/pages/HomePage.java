package com.autotrader.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.autotrader.helper.AutotraderHelper;

public class HomePage
{
	private WebElement autoTraderLogo;
	private WebElement postcode;
	private WebElement distance;
	private WebElement make;
	private WebElement submitButton;

	public void andIAMOnAutotraderHomepage() throws Exception
	{
		autoTraderLogo = AutotraderHelper.getElementByClassName("site-header__logo");
		Assert.assertTrue("Autotrader Homepage is not dispplayed", autoTraderLogo.isDisplayed());
	}
	
	public void whenIEnterValidPostcode() throws Exception

	{
	postcode = AutotraderHelper.getElementByID("postcode");
	postcode.sendKeys("OL9 8LE");
	
	}

	public void andISelectDistanctToPostcode() throws Exception
	{
	distance = AutotraderHelper.getElementByID("radius");
	AutotraderHelper.selectByValue(distance, "50");
	}

	public void andISelectACarMake() throws Exception

	{
	
		make= AutotraderHelper.getElementByID("searchVehiclesMake");
		AutotraderHelper.selectByValue(make, "AUDI");
	}	


	public SearchResultPage andIclickOnSearchCarButton() throws Exception
	{
		submitButton = AutotraderHelper.getElementByID("search");
		submitButton.click();
		return new SearchResultPage();
	}

	}
