package 使用CompletionService实现下载队列;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author simin
 * 利用CompletionService实现Callable,即带有返回值的下载队列的实现。
 * 下载队列有的后进去的任务可能会先执行好，现执行好的先取出结果。
 */
public class DownloadQueue {

	static final int NUM_TASK = 7;
	static final int NUM_THREAD = 5;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newFixedThreadPool(NUM_THREAD);
		CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
		long begin = System.currentTimeMillis();
		//虽然ExecutorThreadPool大小只有5，但是当后面的线程当前面的线程执行完毕后还是能分配到线程
		
		for(int i=0;i<NUM_TASK;i++)
		{
			completionService.submit(new DownloadTask(String.valueOf(i)));
		}
		for(int i=0;i<NUM_TASK;i++)
		{
			Future<String> task = completionService.take();
			long end = System.currentTimeMillis();
			System.out.println("过了"+(end-begin)+"ns");
			System.out.println(task.get());
		}
	}

}

class DownloadTask implements Callable<String>
{
	String id;
	public DownloadTask(String id)
	{
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		Random r = new Random();
		int time = r.nextInt(10000);
		Thread.sleep(time);
		return "id:"+id+",sleeptime:"+time;
	}
	
}
