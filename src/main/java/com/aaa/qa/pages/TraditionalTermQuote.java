package com.aaa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aaa.qa.base.TestBase;

/* TraditionalTermQuote class inherits TestBase class */

public class TraditionalTermQuote extends TestBase {
	
	/* Page factory of Traditional term quote page
	 * All the WebElements on the Traditional term quote page is written PageFactory format / Page object 
	 *  */
	
	@FindBy(id="zip")
	WebElement zip;
	
	@FindBy(xpath="//select[@id='gender']")
	WebElement gender;
	
	@FindBy(xpath="//select[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//select[@id='day']")
	WebElement day;
	
	@FindBy(xpath="//select[@id='year']")
	WebElement year;
	
	@FindBy(id="isMemberYes")
	WebElement isMemberYes;
	
	@FindBy(id="isMemberNo")
	WebElement isMemberNo;
	
	@FindBy(id="contact_email")
	WebElement contact_email;
	
	@FindBy(id="feet")
	WebElement feet;
	
	@FindBy(id="inches")
	WebElement inches;
	
	@FindBy(id="weight")
	WebElement weight;
	
	@FindBy(id="nicotineUse")
	WebElement nicotineUse;
	
	@FindBy(id="rateYourHealth")
	WebElement rateYourHealth;
	
	@FindBy(id="coverageAmount")
	WebElement coverageAmount;
	
	@FindBy(id="termLength")
	WebElement termLength;	
	
	@FindBy(id="seeQuote")
	WebElement seeQuote;	
	
	@FindBy(xpath="//span[@class='summaryPremium']")
	WebElement summaryPremium;
	
	/* Initailizing the Web elements with the object 'driver' using initElements method
	 * 'this' points to the current class object
	 * */
	
	public TraditionalTermQuote() {
		
		PageFactory.initElements(driver, this);
	}
	
	/***
	 * Method to send values to each field of the Traditional term Quote web page in order to get a quote
	 * 
	 */
	public void getTraditionalQuote(String zp, String gend, String mnth, String dy, String yr, String isMber, String email, 
			String ft, String inchs, String wght, String nictne, String healthcon, String covamt, String trmlngth){		
		
		zip.sendKeys(zp);
		gender.sendKeys(gend);
		month.sendKeys(mnth);
		day.sendKeys(dy);
		year.sendKeys(yr);
		if(isMber == "Yes") {
			isMemberYes.click();
		}
		else {
			isMemberNo.click();			
		}
		contact_email.sendKeys(email);
		feet.sendKeys(ft);
		inches.sendKeys(inchs);
		weight.sendKeys(wght);
		nicotineUse.sendKeys(nictne);
		rateYourHealth.sendKeys(healthcon);
		coverageAmount.sendKeys(covamt);
		termLength.sendKeys(trmlngth);
		
		seeQuote.click();
	}	
}
