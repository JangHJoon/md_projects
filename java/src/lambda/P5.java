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
			System.out.println("����̹� �̸� : " + s.name());
			System.out.println("���� �ý��� : " + s.type());
			long total = s.getTotalSpace();
			long free = s.getUnallocatedSpace();
			System.out.println("��ü ���� : " + total + " bytes");
			System.out.println("��� ���� ���� : " + (total - free) + " bytes");
			System.out.println("��� ������ ���� : " + free + " bytes");
			System.out.println();
		}
	}
}