package buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class P5
{
	public static void main(String[] args) throws IOException
	{
		int[] src = {10, 20, 30, 40};
		int[] dst;
		
		System.out.println(Arrays.toString(src));
		ByteBuffer bBuffer;
		IntBuffer isrcBuffer, idstBuffer;
		
		isrcBuffer = IntBuffer.wrap(src);
		bBuffer = ByteBuffer.allocate(isrcBuffer.capacity()*4);
		
		for(int i=0 ; i<isrcBuffer.capacity() ; i++)
		{
			bBuffer.putInt(isrcBuffer.get(i));
		}
		
		bBuffer.flip();
		
		idstBuffer = bBuffer.asIntBuffer();
		dst = new int[idstBuffer.capacity()];
		for(int i=0 ; i<dst.length ; i++)
		{
			dst[i] = idstBuffer.get();
		}
		
		System.out.println(Arrays.toString(dst));
	}
}
