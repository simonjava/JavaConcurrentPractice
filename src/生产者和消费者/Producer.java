package 生产者和消费者;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author simin
 * 生产者
 */
public class Producer implements Runnable{

	BlockingQueue<Item> queue;
	String id;
	public Producer(BlockingQueue<Item> queue,String id)
	{
		this.queue = queue;
		this.id = id;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		while(true)
		{
			Item i = new Item(id, r.nextInt());
			//add 增加成功返回true ， 否则没有可用空间，返回IllegalStateException异常
	//		queue.add(i);
			try {
				//put 如果没有空间，则wait直到有可用空间
				queue.put(i);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
