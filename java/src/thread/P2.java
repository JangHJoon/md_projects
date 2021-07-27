package thread;

public class P2
{
	static private class MyThread extends Thread
	{
		
		public MyThread(String name)
		{
			super(name);
		}

		@Override
		public void run()
		{
			for(int i=0 ; i<10 ; i++)
			{
				System.out.println(getName() + " " + i);
			}
		}
		
	}
	
	
	public static void main(String[] args)
	{
		MyThread t1 = new MyThread("th1");
		MyThread t2 = new MyThread("th2");
		MyThread t3 = new MyThread("th3");
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("MAIN");
	}
}
