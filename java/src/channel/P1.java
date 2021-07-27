package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class P1
{
	public static void main(String[] args) throws IOException
	{
		String[] data = {
				"안녕하세요. 여러분,",
				"Java프로그래밍 언어의 세계로 오신 것을 환영합니다.",
				"JDK를 설치하는 방법에서부터",
				"Java프로그램을 compile하고 실행시키는",
				"모든 방법에 대해 공부해 봅시다."
			};
		
		Path path = Paths.get("./file.txt");
		Files.createDirectories(path.getParent());
		
		FileChannel filechannel = FileChannel.open(path, 
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buffer;
		int byteCount = 0;
		for(int i=0 ; i<data.length ; i++)
		{
			buffer = charset.encode(data[i]);
			byteCount = filechannel.write(buffer);
			System.out.println(byteCount);
		}
		
		filechannel.close();
	}
}
