package com.autotrader.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.autotrader.helper.AutotraderHelper;

public class SearchResultPage 
{
private List<WebElement> searchResult;



public void thenIAmonSearchResultPage() throws Exception
{
searchResult = AutotraderHelper.getElementsByClassName("search-result__title"); 

Assert.assertTrue("Search result list not displayed", searchResult.size()>0);
}
}
