package test;

import org.testng.annotations.Test;

public class Order {
	@Test(priority=-1)
	public void Login(){
		System.out.println("Login");
	}
	@Test(priority=0)
	public void Compose(){
		System.out.println("Compose Mail");
	}
	@Test(priority=1)
	public void Save(){
		System.out.println("Save Mail");
	}
	@Test(priority=3)
	public void Delete(){
		System.out.println("Delete Mail");
	}
	@Test(priority=4)
	public void Logout(){
		System.out.println("Logout");
	}
}
