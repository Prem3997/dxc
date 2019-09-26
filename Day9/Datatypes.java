
public class Datatypes {
	int i;
	float f;
	byte b;
	boolean bool;
	double d;
	short s;
	long l;
	char c=100;
	int main='c';
	public void display() {
		System.out.println("Default value of int is "+i);
		System.out.println("Default value of float is "+f);
		System.out.println("Default value of byte is "+b);
		System.out.println("Default value of boolean is "+bool);
		System.out.println("Default value of double d is "+d);
		System.out.println("Default value of short is "+s);
		System.out.println("Default value of char is "+c);
		System.out.println("Default value of long is "+i);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datatypes d=new Datatypes();
		d.display();	
	}

}
