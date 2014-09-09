package Callable��ʹ��;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author simin
 * Callable���з���ֵ������ʹ��ExecutorServiceִ��
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
		//callable�Ѿ���ʼִ����
		Thread.sleep(5000);
		System.out.println(result.get());
		System.out.println(result.isDone());
		
	}

}
