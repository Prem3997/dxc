package com.seleniumConcepts.day3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class KeyboardAction {
	public static WebDriver driver;
	public String Browser = "chrome";
	@Test
	public void WorkWithMouserOver() throws InterruptedException, AWTException{
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
		WebElement panditWebElement=driver.findElement(By.xpath("//img[@class='dpFooterLogoImage']"));
		Actions rightClickAction=new Actions(driver);
		rightClickAction.contextClick(panditWebElement).build().perform();
		/*for(int i=0;i<2;i++){
			rightClickAction.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(2000);
		}*/
		Robot r=new Robot();
		for(int i=0;i<2;i++){
			r.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
	}
}
