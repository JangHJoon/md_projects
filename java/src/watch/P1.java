package watch;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class P1
{
	public static void main(String[] args) throws Exception
	{
		WatchService ws;
		
		ws = FileSystems.getDefault().newWatchService();
		Path path = Paths.get("C:\\temp");
		path.register(ws, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE, 
				StandardWatchEventKinds.ENTRY_MODIFY);
		
		while(true)
		{
			WatchKey key = ws.take();
			for(WatchEvent<?> event : key.pollEvents())
			{
				Kind<?> k = event.kind();
				Path p = (Path)event.context();
				
				if(k == StandardWatchEventKinds.ENTRY_CREATE)
				{
					System.out.println("File " + p.getFileName() + " is created.");
				}
				else if(k == StandardWatchEventKinds.ENTRY_DELETE)
				{
					System.out.println("File " + p.getFileName() + " is deleted.");
				}
				else if(k == StandardWatchEventKinds.ENTRY_MODIFY)
				{
					System.out.println("File " + p.getFileName() + " is modified.");
				}
			}
			
			boolean valid = key.reset();
			if(!valid) break;
		}
	}
}
