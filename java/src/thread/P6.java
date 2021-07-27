package thread;

public class P6
{
	static private class MyThread extends Thread
	{
		private Thread next = null;
		
		public MyThread(String name)
		{
			super(name);
		}

		@Override
		public void run()
		{
			for(int i=0 ; i<10 ; i++)
			{
				try
				{
					sleep(1000000);
				}
				catch(InterruptedException e)
				{
					System.out.println(getName() + " " + i);
					if(next.isAlive()) next.interrupt();
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		MyThread t1 = new MyThread("th1");
		MyThread t2 = new MyThread("th2");
		MyThread t3 = new MyThread("th3");
		t1.next = t2;
		t2.next = t3;
		t3.next = t1;
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.interrupt();
		t1.join();
		t2.join();
		t3.join();
		
	}
}
