package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class P9
{
	public static void main(String[] args) throws IOException
	{
		// 파일 복사
		Path source = Paths.get("C:/windows/system32/drivers/etc/hosts");
		Path target = Paths.get("./hosts");
		
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
	}
}
