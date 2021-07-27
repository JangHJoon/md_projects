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
			System.out.println("디렉토리입니다.");
		}
		if(Files.isRegularFile(path))
		{
			System.out.println("일반 파일입니다.");
		}
		System.out.println("크기 : " + Files.size(path));
		System.out.println("소유자 : " + Files.getOwner(path).getName());
		if(Files.isHidden(path)) 
		{
			System.out.println("숨김 파일입니다.");
		}
		if(Files.isReadable(path))
		{
			System.out.println("읽기 가능합니다.");
		}
		if(Files.isWritable(path))
		{
			System.out.println("수정 가능합니다.");
		}
		System.out.println("최종 수정 시간 : " + Files.getLastModifiedTime(path));
	}
}
