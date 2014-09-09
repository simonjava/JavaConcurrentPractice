package Web服务器;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author simin
 * 使用Executor来管理线程的产生。最多只会有100个线程处理任务。
 */
public class ExecutorWebService {

	static final int NUM_THREAD = 100;
	static final Executor exec = Executors.newFixedThreadPool(NUM_THREAD);
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while(true)
		{
			final Socket connection = socket.accept();
			exec.equals(new Runnable() {
				
				@Override
				public void run() {
					//处理任务
//					handleRequest(connection);
				}
			});
		}
	}

}
