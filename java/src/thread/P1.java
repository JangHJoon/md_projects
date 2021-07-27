package thread;

public class P1
{
	static private class MyThread1 extends Thread
	{
		@Override
		public void run()
		{
			System.out.println("Thread created by Thread Class");
		}
		
	}
	
	static private class MyThread2 implements Runnable
	{

		@Override
		public void run()
		{
			System.out.println("Thread created by Runnable Interface");
		}
	}
	
	
	public static void main(String[] args)
	{
		MyThread1 t1 = new MyThread1();
		t1.start();
		
		Thread t2 = new Thread(new MyThread2());
		t2.start();
	}
}
