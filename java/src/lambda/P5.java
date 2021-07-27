package lambda;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class P5
{
	public static void main(String[] args) throws IOException
	{
		FileSystem fs = FileSystems.getDefault();
		
		for(FileStore s : fs.getFileStores())
		{
			System.out.println("드라이버 이름 : " + s.name());
			System.out.println("파일 시스템 : " + s.type());
			long total = s.getTotalSpace();
			long free = s.getUnallocatedSpace();
			System.out.println("전체 공간 : " + total + " bytes");
			System.out.println("사용 중인 공간 : " + (total - free) + " bytes");
			System.out.println("사용 가능한 공간 : " + free + " bytes");
			System.out.println();
		}
	}
}