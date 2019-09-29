import java.util.Scanner;

public class SumOfPostiveNumbers {
	int num=0;
	int sum=0;
	int choice=0;
	int count=0;
	Scanner sc=new Scanner(System.in);
	public void display() {
		do {
			System.out.println("Enter Number "+(++count)+"(Only 0-100)");
			num=sc.nextInt();
			if(num>100) {
				System.out.println("Out of the Loop");
				break;
			}
			if(num<0) {
				System.out.println("Negative Numbers are not allowed");
				count--;
				choice=1;
				continue;
			}
			sum+=num;
			System.out.println("Enter 1 to continue!Enter any number to exit");
			choice=sc.nextInt();
		}while(choice==1);
		System.out.println("The sum is "+sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfPostiveNumbers ofPostiveNumbers=new SumOfPostiveNumbers();
		ofPostiveNumbers.display();

	}
	

}
