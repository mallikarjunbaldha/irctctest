package com.irctc.utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	static String Test_Data_Sheet_Path="E:\\Selenium3.0\\irctctest\\src\\main\\java\\com\\irctc\\testdata\\amazonTestData.xlsx";
	static Workbook workbook ;
	static Sheet sheet;

	/**
	 * @param sheetname
	 * @return
	 */
	@DataProvider(name = "TestData")
	public static Object[][] getDataProvider(String sheetname){
	    FileInputStream file = null;
		try {
			file = new FileInputStream(Test_Data_Sheet_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		try {
			 workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetname);
		Object[][] testdata = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j =0; j<sheet.getRow(0).getLastCellNum();j++) {
				
				testdata[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		
		return testdata;
		
	}
}
