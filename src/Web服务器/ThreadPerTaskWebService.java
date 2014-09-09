package Web服务器;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author simin
 * Web服务器为每个任务创建一个线程处理任务
 * 不要这么做！！！！为每个任务都创建一个线程，开销太大且不稳定
 * 使用基于   生产者-消费者的 Executor 来管理这些线程
 */
public class ThreadPerTaskWebService {

	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while(true)
		{
			final Socket connection = socket.accept();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					//处理任务
//					handleRequest(connection);
				}
			}).start();
		}
	}

}
