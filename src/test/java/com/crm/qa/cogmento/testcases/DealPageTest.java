package com.crm.qa.cogmento.testcases;

import org.testng.annotations.Test;

import com.crm.dev.PageObjects.DealPage;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;

public class DealPageTest extends BaseTestSuite{

	
	@Test
	public void tc001_cogmento_deal() {
		
		//check
		DealPage dealpage = new DealPage(driver());
		dealpage.createDeal();
	}
}
