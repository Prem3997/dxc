package demo;

import java.util.StringTokenizer;

public class Z {
	W w=new W();
	{
		System.out.println("Instance Block");
	}
	public void finalize() {
		System.out.println("Garbage Collection");
	}
	static {
		System.out.println("Static Block");
	}
	public Z() {
		System.out.println("Z constructor");
	}
	public static int sum(int p,int...numbers) {
		int sum=0;
		for(int i:numbers)
			sum+=i;
		return sum;
	}
	public static void main(String args[]) {
		System.out.println("Main");
		new Z();
		System.gc();	
		String A="ABC";
		String B=A;
		System.out.println(A==B);
		String message="string;is;immutable;whereas;";
		StringTokenizer st=new StringTokenizer(message,";");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println(sum(4,5,6));
		
	}
}