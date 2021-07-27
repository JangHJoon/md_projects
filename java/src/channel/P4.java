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

class Data2
{
	Path p;
	AsynchronousFileChannel fc;
	ByteBuffer bf;
}

public class P4
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
			ops = EnumSet.of(StandardOpenOption.READ);
			
			AsynchronousFileChannel fc;
			fc = AsynchronousFileChannel.open(p, ops, exec);
			ByteBuffer bf = ByteBuffer.allocate((int)fc.size());
			
			Data2 data = new Data2();
			data.p = p;
			data.fc = fc;
			data.bf = bf;
			
			CompletionHandler<Integer, Data2> handler =
					new CompletionHandler<Integer, Data2>()
					{
						@Override
						public void completed(Integer result, Data2 data)
						{
							data.bf.flip();
							Charset charset = Charset.defaultCharset();
							String txt = charset.decode(data.bf).toString();
							
							System.out.print(data.p.getFileName()+ " : " + txt);
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
						public void failed(Throwable exc, Data2 data)
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
					
			fc.read(bf, 0, data, handler);
		}
		
		exec.shutdown();
	}
}
