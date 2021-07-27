package channel;

import java.io.IOError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Data
{
	Path p;
	AsynchronousFileChannel fc;
}

public class P3
{
	public static void main(String[] args) throws IOException
	{
		int procs = Runtime.getRuntime().availableProcessors();
		ExecutorService exec;
		exec = Executors.newFixedThreadPool(procs);
		
		for(int i=0 ; i<10 ; i++)
		{
			Path p = Paths.get("./file" + i + ".txt");
			Files.createDirectories(p.getParent());
			EnumSet<StandardOpenOption> ops;
			ops = EnumSet.of(StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
			
			AsynchronousFileChannel fc;
			fc = AsynchronousFileChannel.open(p, ops, exec);
			
			Data data = new Data();
			data.p = p;
			data.fc = fc;
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buffer = charset.encode("안녕하세요.");
			
			CompletionHandler<Integer, Data> handler =
					new CompletionHandler<Integer, Data>()
					{
						@Override
						public void completed(Integer result, Data dadta)
						{
							System.out.print(data.p.getFileName()+ " : " + result);
							System.out.println(" bytes written : " + Thread.currentThread().getName());
							
							try
							{
								data.fc.close();
							} 
							catch (IOException e)
							{
								throw new IOError(e);
							}
						}

						@Override
						public void failed(Throwable exc, Data data)
						{
							exc.printStackTrace();
							
							try
							{
								data.fc.close();
							} 
							catch (IOException e)
							{
								throw new IOError(e);
							}
						}
					};
					
			fc.write(buffer,0, data, handler);
		}
		
		exec.shutdown();
	}
}
