package com.aaa.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import com.aaa.qa.base.TestBase;

public class TestUtil extends TestBase {
	/* Name and location of the excel sheet with Testdata stored in a global variable.*/	
	public static String TESTDATA_SHEET_PATH = "/D:/Selenium_2019/eclipse-workspace"
			+ "/AAATest/src/main/java/com/aaa/qa/testdata/TraditionalTermQuoteTestData.xlsx";
    
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	/* method to extract rows and column values from the provided excel sheet */

public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		
		book = new XSSFWorkbook(file);
		
	} 
	
	catch (IOException e) {
		e.printStackTrace();
	}
	
	sheet = book.getSheet(sheetName);
	
	/* Values in the excel browsed row wise and column wise using two for loops. The result is stored in an 2D Object Array data */
	
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
		}
	}
	return data;
}
}
