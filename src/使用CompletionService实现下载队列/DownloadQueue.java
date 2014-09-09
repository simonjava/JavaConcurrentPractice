package ʹ��CompletionServiceʵ�����ض���;

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
 * ����CompletionServiceʵ��Callable,�����з���ֵ�����ض��е�ʵ�֡�
 * ���ض����еĺ��ȥ��������ܻ���ִ�кã���ִ�кõ���ȡ�������
 */
public class DownloadQueue {

	static final int NUM_TASK = 7;
	static final int NUM_THREAD = 5;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newFixedThreadPool(NUM_THREAD);
		CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
		long begin = System.currentTimeMillis();
		//��ȻExecutorThreadPool��Сֻ��5�����ǵ�������̵߳�ǰ����߳�ִ����Ϻ����ܷ��䵽�߳�
		
		for(int i=0;i<NUM_TASK;i++)
		{
			completionService.submit(new DownloadTask(String.valueOf(i)));
		}
		for(int i=0;i<NUM_TASK;i++)
		{
			Future<String> task = completionService.take();
			long end = System.currentTimeMillis();
			System.out.println("����"+(end-begin)+"ns");
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
