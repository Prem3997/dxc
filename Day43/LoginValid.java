package com.seleniumConcepts.day3;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginValid {
	public static WebDriver driver;
	public String Browser = "chrome";
	@Test
	public void WorkWithLoginValid() throws InterruptedException, AWTException{
		SoftAssert st=new SoftAssert();
		if(Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver(); //OpenBrowser
		}else if(Browser.equalsIgnoreCase("mozilla")){
			System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
			 driver=new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession"); //open url
		driver.manage().window().maximize(); //maximize browser
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//WebDriverWait driverWait=new WebDriverWait(driver, 10);
		Wait<WebDriver> driverWait=new FluentWait<WebDriver>(driver).withTimeout(10,TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("roshanthomascoder@gmail.com");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='o6cuMc']"))));
		String errorText =driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
		System.out.println(errorText);
	}
}
