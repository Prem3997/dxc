import java.util.Date;
import java.util.Scanner;

public class Datedemo {
	Scanner sc=new Scanner(System.in);
	int age;
	String name;
	public void display() {
		Date d=new Date();
		System.out.println(d);
		System.out.println("Enter Name and age!");
		name=sc.next();
		age=sc.nextInt();
		
		System.out.println("Your Name is "+name+" and Age is "+age);
		
		
				
	}
	int firstNumber;
	int secondNumber;
	public void addNumbers() {
		System.out.println("Enter First Number");
		firstNumber=sc.nextInt();
		System.out.println("Enter Second Number");
		secondNumber=sc.nextInt();
	}
	public void displayAdd() {
		System.out.println("The Result is "+(firstNumber+secondNumber));
	}
	
	int i=100;
	public void displayVariable() {
		int j=0;
		if(i<200) {
			j=20;
		}
		System.out.println(i+j);
	}
	public static void main(String[] args) {
		Datedemo d1=new Datedemo();
		d1.display();
		d1.addNumbers();
		d1.displayAdd();
		d1.displayVariable();
	}
}
