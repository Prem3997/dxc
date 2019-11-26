package com.seleniumConcepts.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkWithToolTip {
	public WebDriver driver;
	public String Browser = "chrome";
	@Test
	public void WorkWithTable() throws InterruptedException{
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
		driver.get("https://www.drikpanchang.com/"); //open url
		driver.manage().window().maximize(); //maximize browser
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		String tooltiptext=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/a[11]/img[1]")).getAttribute("alt");
		System.out.println("Tooltiptext="+tooltiptext);
	}
}
