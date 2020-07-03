package com.aaa.qa.pages;

import com.aaa.qa.base.TestBase;

/* Class with a method for retrieving the title of the result page */
public class TraditionalTermQuoteResult extends TestBase{	
	
	public String verifyQuoteResultPageTitle(){
		return driver.getTitle();
	}

}
