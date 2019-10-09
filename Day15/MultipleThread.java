class Music extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Music Run called by "+Thread.currentThread().getName());
	}
}
class Score extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Score Run called by "+Thread.currentThread().getName());
	}
}
public class MultipleThread {
	Thread t1,t2;
	public MultipleThread() {
		// TODO Auto-generated constructor stub
		t1=new Thread(new Music());
		t1.setName("Music");
		t1.start();
		t2=new Thread(new Score());
		t2.setName("Score");
		t2.start();
		System.out.println("CONS CALLED BY "+Thread.currentThread().getName());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread T=Thread.currentThread();
		T.setName("Main Boss");
		new MultipleThread();
		System.out.println("Main called by "+Thread.currentThread().getName());
	}

}
