package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import xls.ShineXlsReader;

public class WorkWithExcel {
	@Test(dataProvider="getData")
	public void testcase1(String cname,String cpassword){
		System.out.println(cname+" "+cpassword);
	}
	@DataProvider
	public Object[][] getData(){
		ShineXlsReader xls=new ShineXlsReader("TestData.xlsx");
		int rowCount = xls.getRowCount("Sheet1");
		int columnCount = xls.getColumnCount("Sheet1");
		System.out.println("Row Count:"+rowCount);
		System.out.println("Column Count: "+columnCount);
		Object obj[][]=new Object[rowCount-1][columnCount];
		for(int i=2;i<=rowCount;i++){
			for(int j=0;j<columnCount;j++){
				obj[i-2][j]=xls.getCellData("Sheet1", j, i);
			}
		}
		return obj;
	}
	
	
	
	

}
