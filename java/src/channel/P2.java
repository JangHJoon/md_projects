package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class P2
{
	public static void main(String[] args) throws IOException
	{
		Path path = Paths.get("./file.txt");
		Files.createDirectories(path.getParent());
		
		FileChannel filechannel = FileChannel.open(path, 
				StandardOpenOption.READ);
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
		
		StringBuffer sb = new StringBuffer();
		int byteCount;
		while((byteCount = filechannel.read(buffer)) >= 0)
		{
			buffer.flip();
			sb.append(charset.decode(buffer));
			buffer.clear();
		}
		
		System.out.println(sb);
		
		filechannel.close();
	}
}
