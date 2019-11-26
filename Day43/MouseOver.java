package com.seleniumConcepts.day3;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MouseOver {
	public static WebDriver driver;
	public String Browser = "chrome";
	@Test
	public void WorkWithMouserOver() throws InterruptedException{
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
		driver.get("https://www.naukri.com/"); //open url
		driver.manage().window().maximize(); //maximize browser
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String mainWindowHandle = driver.getWindowHandle();
		closeAllWindowsHandles(mainWindowHandle);
		driver.switchTo().window(mainWindowHandle);
		WebElement findElementRecruiter = driver.findElement(By.xpath("//div[contains(text(),'Recruiters')]"));
		Actions actionMouseOver=new Actions(driver);
		actionMouseOver.moveToElement(findElementRecruiter).build().perform();
	}
	public static void closeAllWindowsHandles(String mainWindowHandle) {
		// TODO Auto-generated method stub
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String x:allWindowHandles){
			if(!x.equals(mainWindowHandle)){
				driver.switchTo().window(x);
				driver.close();
			}
		}
	}
}
