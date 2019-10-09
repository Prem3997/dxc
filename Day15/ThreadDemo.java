
public class ThreadDemo extends Thread{
	Thread t1;
	public ThreadDemo() {
		// TODO Auto-generated constructor stub
		t1=new Thread(this);
		t1.start();
		System.out.println("Cons Called"+Thread.currentThread().getName());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("Run Called"+Thread.currentThread().getName());
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadDemo();
		System.out.println("Main Called"+Thread.currentThread().getName());
		

	}

}
