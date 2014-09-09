package Callable的使用;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author simin
 * Callable带有返回值的任务，使用ExecutorService执行
 */
public class DownImage {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> task = new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(3000);
				return "Download succ";
			}
		};
		ExecutorService executor = Executors.newCachedThreadPool();
	
		Future<String> result = executor.submit(task);
		System.out.println(result.isDone());
		System.out.println("do other thing");
		//callable已经开始执行了
		Thread.sleep(5000);
		System.out.println(result.get());
		System.out.println(result.isDone());
		
	}

}
