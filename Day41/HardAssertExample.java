package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {
	@Test
	public void TestCase1(){
		int explinks=10;
		int actlinks=12;
		System.out.println("A");
		try{
			Assert.assertEquals(actlinks, explinks);
		}catch (Throwable t) {
			// TODO: handle exception
			System.out.println(t.getMessage());
		}
		System.out.println("B");
	}

}
