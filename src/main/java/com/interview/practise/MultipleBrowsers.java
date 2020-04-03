package com.interview.practise;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsers {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("http://toolsqa.com/automation-practice-switch-windows/");
driver.findElement(By.xpath("//a[text()='ACCEPT']")).click();
WebElement close = driver.findElement(By.xpath("//img[@alt='close-link']"));

WebDriverWait wait = new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.elementToBeClickable(close));
close.click();

String mainWindow = driver.getWindowHandle();
driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();

System.out.println(mainWindow);

Set<String> windows = driver.getWindowHandles();
String lastWindow="";
for(String name : windows) {
	System.out.println("Switching to: "+  name);
	driver.switchTo().window(name);
	driver.get("https://www.google.com");
	lastWindow = name ;
}
driver.switchTo().window(mainWindow);
driver.close();
driver.switchTo().window(lastWindow);
driver.get("http://toolsqa.com");
	}

}
