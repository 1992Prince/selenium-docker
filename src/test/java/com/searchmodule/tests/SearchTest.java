package com.searchmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;

public class SearchTest extends BaseTest {

	@Test
	@Parameters({ "keyword" })
	public void search(String keyword) throws InterruptedException {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		Thread.sleep(3000);
		searchPage.doSearch(keyword);
		Thread.sleep(3000);
		searchPage.goToVideos();
		Thread.sleep(3000);
		int size = searchPage.getResult();
		Thread.sleep(3000);
		Assert.assertTrue(size > 0);
	}

}
