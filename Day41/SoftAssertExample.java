package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	SoftAssert st=new SoftAssert();
	@Test
	public void TestCase1(){
		int explinks=10;
		int actlinks=12;
		System.out.println("A");
		st.assertEquals(actlinks, explinks,"comparing number of links");
		st.assertEquals("Bangalore", "Bengaluru","Comapring String");
		System.out.println("B");
		st.assertEquals(10, 10);
		System.out.println("C");
		st.assertAll();
	}

}
