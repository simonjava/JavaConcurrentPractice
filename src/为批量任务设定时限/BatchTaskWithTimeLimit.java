package 为批量任务设定时限;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BatchTaskWithTimeLimit {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(4);
		List<Task> tasks = new ArrayList<Task> (); 
		tasks.add(new Task(2000));
		tasks.add(new Task(100));
		List<Future<TaskResult>> results = null;
		try {
			 results = exec.invokeAll(tasks, 1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Future<TaskResult> r:results)
		{
			try {
				if(!r.isCancelled())
					System.out.println(r.get().info);
				else
					System.out.println("取消");
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("over");
	}

}

class Task implements Callable<TaskResult>
{
	int sleep = 0;
	public Task(int sleep)
	{
		this.sleep = sleep;
	}
	@Override
	public TaskResult call() throws Exception {
		Thread.sleep(sleep);
		return new TaskResult(sleep);
	}
	
}

class TaskResult
{
	int info;
	public TaskResult(int info)
	{
		this.info=info;
	}
}