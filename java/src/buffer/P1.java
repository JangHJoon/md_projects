package buffer;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class P1
{
	public static void main(String[] args) throws IOException
	{
		int c = 1024*1024*1024; // 1GB
		Buffer bf = ByteBuffer.allocate(c);
		System.out.println(bf.capacity() + "bytes buffered is created.");
		
		ByteBuffer dbf = ByteBuffer.allocateDirect(c);
		dbf.order(ByteOrder.nativeOrder());
		System.out.println(dbf.capacity() + "bytes directed buffered is created.");
	}
}
