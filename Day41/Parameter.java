package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameter {
	@Test(dataProvider="getData1")
	public void testcase1(String cn,String cp){
		System.out.println(cn+" "+cp);
	}
	@DataProvider
	public Object[][] getData1(){
		Object obj[][]=new Object[3][2];
		obj[0][0]="Name1";
		obj[0][1]="Password1";
		
		obj[1][0]="Name2";
		obj[1][1]="Password2";
		
		obj[2][0]="Name3";
		obj[2][1]="Password3";
		return obj;
	}
	@Test(dataProvider="getData2")
	public void testcase2(String cn,String cp){
		System.out.println(cn+" "+cp);
	}
	@DataProvider
	public Object[][] getData2(){
		Object obj[][]=new Object[3][2];
		obj[0][0]="Name4";
		obj[0][1]="Password4";
		
		obj[1][0]="Name5";
		obj[1][1]="Password5";
		
		obj[2][0]="Name6";
		obj[2][1]="Password6";
		return obj;
	}

}
