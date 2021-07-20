package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class P2
{
	public static void main(String[] args)
	{
		Consumer<String> con = a -> System.out.println("Hello " + a + "!");
		con.accept("Java");
		
		Supplier<Integer> sup = () -> (int)(Math.random()*10);
		System.out.println(sup.get());
		
		Function<String, Integer> func = (s) -> Integer.parseInt(s)+10;
		System.out.println(func.apply("123"));
	}
}
