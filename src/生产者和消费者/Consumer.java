package 生产者和消费者;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author simin
 * 消费者
 */
public class Consumer implements Runnable{

	BlockingQueue<Item> queue;
	String id;
	public Consumer(BlockingQueue<Item> queue,String id)
	{
		this.queue = queue;
		this.id = id;
	}
	
	@Override
	public void run() {
		while(true)
		{
			try {
				Item e = queue.take();
				e.setConsumer(id);
				System.out.println(e);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
