package com.seleniumConcepts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkWithSikuliUpload {
	public WebDriver driver;
	public String Browser = "chrome";
	@Test
	public void WorkWithSelect() throws FindFailed{
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
		driver.get("https://pdf2doc.com/");
		driver.manage().window().maximize(); //maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Upload Files')]")).click();
		Pattern pattern = new Pattern("C:\\Users\\pbalaji5\\dxc\\SeleniumDemo\\SikuliImages\\FileName.PNG");
		Pattern pattern1 = new Pattern("C:\\Users\\pbalaji5\\dxc\\SeleniumDemo\\SikuliImages\\Open.PNG");
		Screen screen=new Screen();
		screen.type(pattern,"C:\\Users\\pbalaji5\\dxc\\ProposedReport.pdf");
		screen.click(pattern1);
		
	}
}
