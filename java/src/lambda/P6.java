package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P6
{
	public static void main(String[] args) throws IOException
	{
		Path path = Paths.get("C:/windows/system32/drivers/etc/hosts");
		
		System.out.println(path);
		if(Files.isDirectory(path))
		{
			System.out.println("���丮�Դϴ�.");
		}
		if(Files.isRegularFile(path))
		{
			System.out.println("�Ϲ� �����Դϴ�.");
		}
		System.out.println("ũ�� : " + Files.size(path));
		System.out.println("������ : " + Files.getOwner(path).getName());
		if(Files.isHidden(path)) 
		{
			System.out.println("���� �����Դϴ�.");
		}
		if(Files.isReadable(path))
		{
			System.out.println("�б� �����մϴ�.");
		}
		if(Files.isWritable(path))
		{
			System.out.println("���� �����մϴ�.");
		}
		System.out.println("���� ���� �ð� : " + Files.getLastModifiedTime(path));
	}
}
