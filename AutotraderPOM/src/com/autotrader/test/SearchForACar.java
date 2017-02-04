package com.autotrader.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.autotrader.helper.AutotraderHelper;
import com.autotrader.pages.HomePage;
import com.autotrader.pages.SearchResultPage;

public class SearchForACar extends AutotraderHelper
{
  private HomePage homepage;

 private SearchResultPage searchResultPage;
 
	@Before
	public void setup() throws Exception
	{
		launchBrowser ("Chrome");
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();  
	}
	@After
	public void tearDown() throws Exception
	{
		closeBrowser();
	}
	@Test
	public void SearchForACarTest() throws Exception
	{
		GivenINavigateAutotraderHomePage();

		homepage.andIAMOnAutotraderHomepage();
		homepage.whenIEnterValidPostcode();
		homepage.andISelectDistanctToPostcode();
		homepage.andISelectACarMake();
		homepage.andISelectACarMake();
		homepage.andIclickOnSearchCarButton();
		searchResultPage.thenIAmonSearchResultPage();
		
		
		
		
		
	}
}
