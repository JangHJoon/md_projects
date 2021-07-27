package thread;

public class P5
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
	
	
	public static void main(String[] args) throws InterruptedException
	{
		MyThread t1 = new MyThread("th1");
		MyThread t2 = new MyThread("th2");
		
		t1.start();
		t2.start();
		
		// 메인 스레드를 기다리게 만듦
		t1.join();
		t2.join();
		System.out.println("MAIN");
	}
}
