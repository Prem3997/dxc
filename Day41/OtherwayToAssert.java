package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OtherwayToAssert {
	@Test
	public void TestCase1(){
		SoftAssert st=new SoftAssert();
		String expstr="Bangalore";
		String actstr="Bengaluru";
		System.out.println("A");
		if(!expstr.equals(actstr)){
			st.fail("Not Matched");
		}
		System.out.println("B");
		st.assertAll();
	}
}
