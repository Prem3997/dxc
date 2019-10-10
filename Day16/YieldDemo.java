public class YieldDemo extends Thread
{
	private int countDown = 3;
	private static int threadCount = 0;
	public YieldDemo()
	{
		super("" + ++threadCount);
    		start();
	}
	public String toString()
	{
		return "#" + getName() + ": " + countDown;
	}
	public void run()
	{
		while (true)
		{
			System.out.println(this);
			if (--countDown == 0)
				return;
			yield();
		}
  	}
	public static void main(String[] args)
	{
		for (int i = 0; i <3; i++)
			new YieldDemo();
	}
}