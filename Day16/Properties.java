import java.util.Enumeration;

public class Properties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Properties all=System.getProperties();
		System.out.println(all);
		Enumeration<Object> elements=all.elements();
		while(elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
	}
}
