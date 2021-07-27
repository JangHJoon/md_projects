package buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class P3
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
		
		Charset cs = Charset.forName("UTF-8");
		ByteBuffer buffer;
		for(int i=0 ; i<data.length ; i++)
		{
			buffer = cs.encode(data[i]);
			System.out.println(cs.decode(buffer));
		}
	}

}
