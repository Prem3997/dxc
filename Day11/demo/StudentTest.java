package demo;

public class StudentTest {

	public static void display(int regno) {
		System.out.println("Registration No. " + regno);
	}

	public static void display(String name) {
		System.out.println("Name. " + name);
	}
	static void go(int...x) {
		System.out.println("int");
	}
	static void go(byte...x) {
		System.out.println("byte");
	}
	

	public static void main(String str[]) {
		Student s1 = new Student(198,"Prem");
		display(s1.getName());
		display(s1.getRegNo());
		s1.setName("Roshan");
		display(s1.getName());
		byte b=5;
		go(b,b);
	}
}