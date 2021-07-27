package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class P8
{
	static AtomicInteger value;
	
	
	static private class MyThread extends Thread
	{
		public MyThread(String name)
		{
			super(name);
		}

		@Override
		public void run()
		{
			for(int i=0 ; i<10000 ; i++)
			{
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		Thread[] arrT = new Thread[100];
		for(int i=0 ; i<arrT.length ; i++)
		{
			arrT[i] = new MyThread("th" + (i+1));
		}
		
		for(int i=0 ; i<arrT.length ; i++)
		{
			arrT[i].start();
		}
	}
}
