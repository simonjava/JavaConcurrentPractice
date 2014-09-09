package 简单的任务取消;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;


public class TaskInterrupt {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Task task = new Task();
		Task2 task2 = new Task2();
//		exec.execute(task);
//		exec.execute(task2);
		new Thread(task).start();
		task2.start();
		Thread.sleep(2000);
		task.cancel();
		task2.cancel();
		System.out.println("Main over");
	}

}

class Task implements Runnable
{
	BlockingQueue<Integer> blockQueue = new LinkedBlockingDeque<Integer>(4);
	@Override
	public void run() {
		int k=0;
		while(true)
		{
			
			if(Thread.currentThread().isInterrupted())
			{
				System.out.println("中断了");
				break;
			}
			try {
				System.out.println("task1 "+k++);
				// 会阻塞
				blockQueue.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("task over");
	}
	
	public void cancel()
	{
		System.out.println(Thread.currentThread().getName());//输出的是Main
		Thread.currentThread().interrupt();
	}
	
}


class Task2 extends Thread
{
	BlockingQueue<Integer> blockQueue = new LinkedBlockingDeque<Integer>(4);
	@Override
	public void run() {
		int k=0;
		try
		{
			while(true)
			{
	
				//这个方法不一定能恰好捕获到异常
				if(Thread.currentThread().isInterrupted())
				{
					System.out.println("中断了");
					break;
				}
				try 
				{
					System.out.println("task2 "+k++);
					// 会阻塞
					blockQueue.put(1);
				} catch (InterruptedException e) {
					System.out.println("task2 捕获异常");
					e.printStackTrace();
				}
			}
		}finally
		{
			System.out.println("恢复中断");
			Thread.currentThread().interrupt();
		}
		System.out.println("task2 over");
	}
	
	public void cancel()
	{
		System.out.println(Thread.currentThread().getName());//输出Main
//		Thread.currentThread().interrupt(); //无法使其中断
		interrupt(); //能够使其中断
	}
	
}
