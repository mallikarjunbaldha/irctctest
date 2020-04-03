package com.irctc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.irctc.utilties.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {

	WebDriver driver;
	String sheetname = "Sheet1";
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "E:\\Selenium3.0\\irctctest\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.linkText("Start here.")).click();
		// registration page
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test(dataProvider = "Amazon_TestData")
	public void test(String name, String number) {
		WebElement name1 = driver.findElement(By.name("customerName"));
		 name1.sendKeys(name);
		 WebElement num = driver.findElement(By.id("ap_phone_number"));
		 num.sendKeys(number);
	}
	@DataProvider(name ="Amazon_TestData")
	public Object[][] getData_Amazon_TestData(){
		 Object[][] data = ExcelReader.getData(sheetname);
			return data;
		}
	
	@DataProvider(name ="getData")
	public Object[] getData() {
		Object[][] data = new Object[3][2];
		// 1st row
		data[0][0] ="sampleuser1";
		data[0][1] = "abcdef";

		// 2nd row
		data[1][0] ="testuser2";
		data[1][1] = "zxcvb";
		
		// 3rd row
		data[2][0] ="guestuser3";
		data[2][1] = "pass123";
		return data;
	}
		
	}
	


