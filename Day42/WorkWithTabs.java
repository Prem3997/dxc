package com.seleniumConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkWithTabs {
	public WebDriver driver;
	public String Browser = "chrome";
	@Test
	public void WorkWithSelect() throws InterruptedException{
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
		driver.get("https://www.msn.com/en-in");
		driver.manage().window().maximize(); //maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='amazon sponsored']//span[contains(text(),'Sponsored')]")).click();
		Set<String> allWindowIds=driver.getWindowHandles();
		Iterator<String> iterator = allWindowIds.iterator();
		String mId=iterator.next();
		String tId=iterator.next();
		driver.switchTo().window(tId);
		driver.findElement(By.xpath("//span[contains(@class,'nav-line-2')][contains(text(),'Account & Lists')]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("RoshanCoderTester");
		driver.close();
		driver.switchTo().window(mId);
		driver.findElement(By.xpath("//h3[contains(text(),'Skype')]")).click();
		driver.findElement(By.xpath("//span[@class='title x-hidden-focus']")).click();
	}
}
