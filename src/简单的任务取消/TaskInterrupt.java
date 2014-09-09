package �򵥵�����ȡ��;

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
				System.out.println("�ж���");
				break;
			}
			try {
				System.out.println("task1 "+k++);
				// ������
				blockQueue.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("task over");
	}
	
	public void cancel()
	{
		System.out.println(Thread.currentThread().getName());//�������Main
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
	
				//���������һ����ǡ�ò����쳣
				if(Thread.currentThread().isInterrupted())
				{
					System.out.println("�ж���");
					break;
				}
				try 
				{
					System.out.println("task2 "+k++);
					// ������
					blockQueue.put(1);
				} catch (InterruptedException e) {
					System.out.println("task2 �����쳣");
					e.printStackTrace();
				}
			}
		}finally
		{
			System.out.println("�ָ��ж�");
			Thread.currentThread().interrupt();
		}
		System.out.println("task2 over");
	}
	
	public void cancel()
	{
		System.out.println(Thread.currentThread().getName());//���Main
//		Thread.currentThread().interrupt(); //�޷�ʹ���ж�
		interrupt(); //�ܹ�ʹ���ж�
	}
	
}
