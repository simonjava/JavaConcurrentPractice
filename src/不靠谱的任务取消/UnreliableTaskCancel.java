package 不靠谱的任务取消;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class UnreliableTaskCancel {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Task task = new Task();
		exec.execute(task);
		Thread.sleep(10000);
		task.cancel();
		System.out.println("Main over");
	}

}

class Task implements Runnable
{
	private volatile boolean cancelled=false;
	BlockingQueue<Integer> blockQueue = new LinkedBlockingDeque<Integer>(4);
	@Override
	public void run() {
		while(!cancelled)
		{
			try {
				// 会阻塞
				blockQueue.put(1);
				System.out.println(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("over");
	}
	
	public void cancel()
	{
		cancelled=true;
	}
	
}
