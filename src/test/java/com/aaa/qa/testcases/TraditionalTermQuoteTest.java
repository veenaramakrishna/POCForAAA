package com.aaa.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aaa.qa.base.TestBase;
import com.aaa.qa.pages.TraditionalTermQuote;
import com.aaa.qa.pages.TraditionalTermQuoteResult;
import com.aaa.qa.util.TestUtil;
/*
 * TraditionalTermQuoteTest class inherits the TestBase class
 * */
public class TraditionalTermQuoteTest extends TestBase {
	TraditionalTermQuote traditionalTermQuote; /* traditionalTermQuote variable defined at the class level */
	TraditionalTermQuoteResult traditionaltermquoteresult; /* traditionaltermquoteresult variable defined at the class level */
	
	String sheetName = "TTQuote"; /* Name of the sheet of the traditional quote in the test data excel file in the TestData folder is stored in a variable 'sheetName'*/
		
	/* Constructor of the TraditionalTermQuoteTest class
	 * super() used to call the parent class constructor 
	 *
	 * */
	public TraditionalTermQuoteTest() {
		super();
	}
		
	/* TestNg annotation used Before method executed before Test section is executed */	
	@BeforeMethod
	public void setUp(){
		initialization(); /* Method in the parent class that initiates reading browser name and other properties */
		 traditionalTermQuote = new TraditionalTermQuote(); /*object of TraditionalTermQuote class created */
		 traditionaltermquoteresult = new TraditionalTermQuoteResult(); /*object of TraditionalTermQuoteResult class created */
	}
	
	/* TestNg dataprovider block that supplies Testdata from the excel file 
	 * Method calls the function getTestData in the TestUtil class. It returns 2D Object array
	 * */
	
	@DataProvider(name="getTTQuoteData")
	public Object[][] getData(){
		/* Get the test data */
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	/*
	 * 
	 * Test block that makes use of data driven approach. TestData got from the Dataprovider section above.
	 * */	
	@Test(dataProvider="getTTQuoteData")
	public void ValidateTTQuoteTest(String zip, String gender, String month, String day, String year, String isMember, String email, 
			String height, String inches, String weight, String nicotine, String healthcon, String covamt, String termlength) {
	
		 traditionalTermQuote.getTraditionalQuote(zip, gender, month, day, year, isMember, email, height, inches, weight, nicotine, healthcon, covamt, termlength);
		  
		 /* Verifying if quote result page is seen */
		 String QuoteResultPageTitle = traditionaltermquoteresult.verifyQuoteResultPageTitle();
		 Assert.assertEquals(QuoteResultPageTitle, "Life Insurance Quote - See Your Results | AAA Life Insurance Company", "Not landed in the quote result page");
	 
	}
	
	/*
	 * After method will be executed after Test block is executed once. In this block the browser will be closed.
	 * */	
	@AfterMethod
	public void tearDown() {		
		driver.quit();
	}
}
