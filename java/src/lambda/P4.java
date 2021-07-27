package lambda;

import java.nio.file.Path;
import java.nio.file.Paths;

public class P4
{
	public static void main(String[] args)
	{
		Path path = Paths.get("C:/windows/system32/drivers/etc/hosts");
		
		System.out.println("���� �̸� : " + path.getFileName());
		System.out.println("���� ���� : " + path.getParent().getFileName());
		
		System.out.println("��� ���� : " + path.getNameCount());
		System.out.print("���� ��� : ");
		for(int i=0 ; i<path.getNameCount() ; i++)
		{
			System.out.print(path.getName(i) + "/");
		}
		
		System.out.print("\n���� ��� : ");
		for(Path p : path)
		{
			System.out.print(p.getFileName() + "/"); 
		}
	}
}
