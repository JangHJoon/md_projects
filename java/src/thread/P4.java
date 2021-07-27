package thread;

public class P4
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
				if("th1".equals(getName()))
				{
					yield();
				}
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		// 순서제어 2. yield() 메소드로 다른 스래드에 양보
		MyThread t1 = new MyThread("th1");
		MyThread t2 = new MyThread("th2");
		MyThread t3 = new MyThread("th3");
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("MAIN");
	}
}
