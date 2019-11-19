package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annot {
	@BeforeClass
	public void bclass(){
		System.out.println("Start Server");
	}
	@BeforeMethod
	public void bmethod(){
		System.out.println("Open Browser");
	}
	@Test
	public void TestCase1(){
		System.out.println("Compose Mail");
	}
	@Test
	public void TestCase2(){
		System.out.println("Save Mail");
	}
	@Test
	public void TestCase3(){
		System.out.println("Delete Mail");
	}
	@AfterMethod
	public void amethod(){
		System.out.println("Close Browser");
	}
	@AfterClass
	public void aclass(){
		System.out.println("Stop Server");
	}
}
