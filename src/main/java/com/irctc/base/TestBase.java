package com.irctc.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.irctc.utilties.DataProviderClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	WebElement name1;
	WebElement ccode1;
	WebElement number1;
	WebElement email1;
	WebElement password1;
	WebElement country1;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "E:\\Selenium3.0\\irctctest\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.xpath("//a[text()='Start here.']")).click();
		  name1 = driver.findElement(By.name("customerName"));
		  country1 = driver.findElement(By.id("auth-country-picker-container"));
		 country1.click();;
		  ccode1 = driver.findElement(By.xpath("//a[text()='Italy +39']"));
		  email1 = driver.findElement(By.id("ap_email"));
		  password1 = driver.findElement(By.id("ap_password"));
		 
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(dataProvider = "TestData", dataProviderClass=DataProviderClass.class)
	public void test(String name, String ccode, String number, String email, String password) {
		name1.sendKeys(name);
		ccode1.sendKeys(ccode);
		number1.sendKeys(number);
		email1.sendKeys(email);
		password1.sendKeys(password);

		
	}
	
	
		
		
	
	
 
 
}
