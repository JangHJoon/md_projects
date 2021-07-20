package lambda;

import java.io.IOError;
import java.io.IOException;
import java.io.RandomAccessFile;

public class P3
{
	public static void main(String[] args) throws IOException
	{
		try(RandomAccessFile raf = new RandomAccessFile("test.txt", "rw"))
		{
			for(int i=0 ; i<10 ; i++)
			{
				raf.write(i);
			}
			
			for(int i=9 ; i>=0 ; i--)
			{
				raf.seek(i);
				System.out.println(raf.read());
			}
		}
		catch(IOException e)
		{
			new IOError(e);
		}
	}
}
