package com.dxc.client;

import junit.framework.TestCase;

public class addNumbersTest extends TestCase {
	addNumbers a=new addNumbers();
	public void testSum() {
		int res=a.add(2, 2);
		assertEquals(4, res);
		
	}
	public void testSum1() {
		int res1=a.add(4, 3);
		assertEquals(6, res1);
	}

}
