package com.seleniumConcepts;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;

public class Test3 {
	public WebDriver driver;
	public String Browser = "chrome";

	@Test
	public void testcase1(){
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
		driver.get("http://localhost:9000/login.do"); //open url
		driver.manage().window().maximize(); //maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		driver.findElement(By.xpath("//a[@class='content tasks']//img[@class='sizer']")).click();
		//driver.findElement(By.xpath()).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Projects & Customers')]")).click();
		driver.findElement(By.xpath("//body/div[@id='container']/form[@id='customersProjectsForm']/table[@class='mainContentPadding rightPadding']/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/input[1]")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("CustomerC");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("DescriptionC");
		driver.findElement(By.xpath("//input[@id='add_more_customers_action']")).click();
		driver.findElement(By.xpath("//input[@name='createCustomerSubmit']")).click();
		try{
			driver.findElement(By.xpath(".//*[@id='SuccessMessages']/tbody/tr/td/span")).isDisplayed();
			//Logout
					driver.findElement(By.xpath(".//*[@id='logoutLink']")).click();
			}catch(Throwable t){
				Assert.fail("Sucess msg does not displayed...");
				//Logout
				driver.findElement(By.xpath(".//*[@id='logoutLink']")).click();
				//cancel creation
				driver.findElement(By.xpath(".//*[@id='DiscardChangesButton']")).click();
			}
		driver.quit();
		//driver.close();
		st.assertAll();
		
	}
}
