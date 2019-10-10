
public class DemoThread extends Thread {
	public DemoThread(int i) {
		// TODO Auto-generated constructor stub
		setName(i+"");
		Thread.currentThread().setName("M");
		if(i==3)
			setPriority(10);
		start();
		
	}
	public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Run Called "+Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new DemoThread(i);
		}
		System.out.println("Main Called "+Thread.currentThread().getName());
	}

}
