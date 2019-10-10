class PrintClass{
	public static synchronized void printNames(String firstName,String secondName) {
		System.out.println("First Name:"+firstName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Last Name:"+secondName);
	}
}
public class ThreadSynchronizationDemo extends Thread {
	Thread t1,t2;
	public ThreadSynchronizationDemo() {
		// TODO Auto-generated constructor stub
		t1=new Thread(this);
		t1.start();
		t2=new Thread(this);
		t2.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		PrintClass.printNames("Prem", "Balaji");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadSynchronizationDemo();
	}

}
