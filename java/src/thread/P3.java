package thread;

public class P3
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
		// 순서제어 1, 우선순위 설정
		MyThread t1 = new MyThread("th1");
		MyThread t2 = new MyThread("th2");
		MyThread t3 = new MyThread("th3");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("MAIN");
	}
}
