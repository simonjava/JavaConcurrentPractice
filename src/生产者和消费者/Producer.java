package �����ߺ�������;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author simin
 * ������
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
			//add ���ӳɹ�����true �� ����û�п��ÿռ䣬����IllegalStateException�쳣
	//		queue.add(i);
			try {
				//put ���û�пռ䣬��waitֱ���п��ÿռ�
				queue.put(i);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
