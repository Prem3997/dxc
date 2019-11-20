package com.seleniumConcepts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkWithLinks {
	public WebDriver driver;
	public String Browser = "chrome";
	@Test
	public void WorkWithSelect() throws InterruptedException, IOException{
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
		driver.get("https://in.yahoo.com/");
		driver.manage().window().maximize(); //maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		for(int i=0;i<findElements.size();i++){
			if(!findElements.get(i).getText().isEmpty()){
				System.out.println(findElements.get(i).getText());
			}
		}
		driver.findElement(By.linkText("News")).click();
		Thread.sleep(3000);
		/*driver.navigate().back();
		driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());
		driver.manage().deleteAllCookies();*/

	}
}
