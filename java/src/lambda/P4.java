package lambda;

import java.nio.file.Path;
import java.nio.file.Paths;

public class P4
{
	public static void main(String[] args)
	{
		Path path = Paths.get("C:/windows/system32/drivers/etc/hosts");
		
		System.out.println("파일 이름 : " + path.getFileName());
		System.out.println("상위 폴더 : " + path.getParent().getFileName());
		
		System.out.println("경로 길이 : " + path.getNameCount());
		System.out.print("현재 경로 : ");
		for(int i=0 ; i<path.getNameCount() ; i++)
		{
			System.out.print(path.getName(i) + "/");
		}
		
		System.out.print("\n현재 경로 : ");
		for(Path p : path)
		{
			System.out.print(p.getFileName() + "/"); 
		}
	}
}
