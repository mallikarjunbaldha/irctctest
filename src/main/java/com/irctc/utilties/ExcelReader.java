package com.irctc.utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
static FileInputStream fip;
static String filepath = "E:\\Selenium3.0\\irctctest\\src\\main\\java\\com\\irctc\\testdata\\Irctc_Test_Data.xlsx";
static Workbook workbook;


public static Object[][] getData(String sheetname){
	
	
	try {
		fip = new FileInputStream(filepath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
		workbook = WorkbookFactory.create(fip);
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	Sheet sheet = workbook.getSheet(sheetname);
	Row row = sheet.getRow(0);
	System.out.println(sheet.getLastRowNum());
	System.out.println(sheet.getRow(0).getLastCellNum());
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i =0; i< sheet.getLastRowNum();i++) {
		for(int j=0;j<row.getLastCellNum();j++) {
		data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	
	
	return data;
}
	
}
