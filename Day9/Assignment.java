import java.util.Scanner;

public class Assignment {
	Scanner sc=new Scanner(System.in);
	int firstNumber,secondNumber;
	public void addNumbers() {
		System.out.println("Enter First Number");
		firstNumber=sc.nextInt();
		System.out.println("Enter Second Number");
		secondNumber=sc.nextInt();
		if((firstNumber<0)||(secondNumber<0)) {
			System.out.println("Enter Only Positive Numbers!");
		}
		else {
			System.out.println("The sum of two numbers is "+(firstNumber+secondNumber));
		}
	}
	public void swapTwoNumbers() {
		System.out.println("Enter Two Numbers!!!");
		firstNumber=sc.nextInt();
		secondNumber=sc.nextInt();
		System.out.println("The value of FirstNumber is "+firstNumber+" and the value of SecondNumber is "+secondNumber);
		firstNumber=firstNumber+secondNumber;
		secondNumber=firstNumber-secondNumber;
		firstNumber=firstNumber-secondNumber;
		System.out.println("After Swapping");
		System.out.println("The value of FirstNumber is "+firstNumber+" and the value of SecondNumber is "+secondNumber);
	}
	public void findLeapYear(){
		System.out.println("Enter the Year!!!");
		int year=sc.nextInt();
		if((year%4==0)&&(year%100!=0)||(year%400==0)) {
			System.out.println("Leap Year");
		}
		else {
			System.out.println("Not a Leap Year");
		}
	}
	public void checkVowel() {
		System.out.println("Enter the character");
		char c=sc.next().charAt(0);
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
			System.out.println("Vowel");
		}
		else {
			System.out.println("Consonant");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment a=new Assignment();
		a.swapTwoNumbers();
		a.findLeapYear();
		a.checkVowel();
		a.addNumbers();
	}

}
