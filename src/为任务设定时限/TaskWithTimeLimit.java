package 为任务设定时限;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TaskWithTimeLimit {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<String> result = exec.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "Succ";
			}
		});
		try {
			System.out.println(result.get(50, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		} catch (TimeoutException e) {
			
			e.printStackTrace();
		}
		System.out.println("over");
	}

}
