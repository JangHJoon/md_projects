package buffer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class P2
{
	private static ByteBuffer buffer;
	
	public static void main(String[] args) throws IOException
	{
		buffer = ByteBuffer.allocate(9);
		printMsg("buffer is created");
		printState();
		
		buffer.put(new byte[3]);
		printMsg("3 Bytes are relatively put.");
		printState();
		
		buffer.put(new byte[2]);
		printMsg("2 Bytes are relatively put.");
		printState();
		
		buffer.flip();
		// limit = position
		// position = 0
		printMsg("flip() is called.");
		printState();
		
		buffer.get(new byte[2]);
		printMsg("2 Bytes are relatively get.");
		printState();
		
		buffer.mark();
		printMsg("mark() is called");
		printState();
		
		buffer.get(new byte[3]);
		printMsg("3 Bytes are relatively get.");
		printState();
		
		buffer.reset();
		// position = mark
		printMsg("reset() is called.");
		printState();
		
		buffer.get(new byte[2]);
		printMsg("2 Bytes are relatively get.");
		printState();
		
		buffer.rewind();
		// position = 0;
		// mark x
		printMsg("rewind() is called.");
		printState();
		
		buffer.put(new byte[2]);
		printMsg("2 Bytes are relatively put.");
		printState();
		
		buffer.clear();
		printMsg("clear() is called.");
		printState();
	}
	
	public static void printState()
	{
		System.out.println("\tposition : " + buffer.position());
		System.out.println("\tlimit : " + buffer.limit());
		System.out.println("\tcapacity : " + buffer.capacity());
	}
	
	public static void printMsg(String str)
	{
		System.out.println("[" + str + "]");
	}
}
