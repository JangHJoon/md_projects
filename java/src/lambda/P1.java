package lambda;

public class P1
{
	interface MyInterface1
	{
		public void action(int a, int b);
	}
	
	interface MyInterface2
	{
		public void action(int a);
	}
	
	interface MyInterface3
	{
		public int action(int a, int b);
	}
	
	public static void main(String[] args)
	{
		MyInterface1 mif1;
		MyInterface2 mif2;
		MyInterface3 mif3;
		
		mif1 = new MyInterface1()
		{
			@Override
			public void action(int a, int b)
			{
				System.out.println(a+b);
			}
		};
		mif1 = (int a, int b) -> {System.out.println(a+b);};
		mif1 = (a,b) -> {System.out.println(a+b);};
		mif1 = (a,b) -> System.out.println(a+b);
		mif1.action(1, 3);
		
		
		mif2 = new MyInterface2()
		{
			@Override
			public void action(int a)
			{
				System.out.println(a);
			}
		};
		mif2 = (int a) -> {System.out.println(a);};
		mif2 = a -> System.out.println(a);
		mif2.action(4);
		
		mif3 = new MyInterface3()
		{
			
			@Override
			public int action(int a, int b)
			{
				return a+b;
			}
		};
		mif3 = (int a, int b)->{return a+b;};
		mif3 = (a, b)-> a+b;
		System.out.println(mif3.action(5, 4));
		
	}
}
