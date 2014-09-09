package 生产者和消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	public static final int NUM_PRODUCER = 5;
	public static final int NUM_CONSUMER = 5;
	public static final int SIZE_QUEUE = 20;
	
	public static void main(String[] args) {
		BlockingQueue<Item> queue = new LinkedBlockingDeque<Item>(SIZE_QUEUE);
		for(int i=0;i<NUM_PRODUCER;i++)
		{
			new Thread(new Producer(queue, String.valueOf(i))).start();
		}
		
		for(int i=0;i<NUM_CONSUMER;i++)
		{
			new Thread(new Consumer(queue, String.valueOf(i))).start();
		}
	}

}
