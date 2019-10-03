package animal1;

public class ExceptionDemo {
	public void display() {
		try {
			System.out.println(10/0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Dividing by Zero is not Possible");
		}
		
		try {
			int marks[]=new int[-5];
			System.out.println(marks[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("Array index is out of bound");
		}catch(NegativeArraySizeException e) {
			System.out.println("Negative storage for array");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionDemo demo=new ExceptionDemo();
		demo.display();
	}

}
