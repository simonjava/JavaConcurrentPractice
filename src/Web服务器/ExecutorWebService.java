package Web������;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author simin
 * ʹ��Executor�������̵߳Ĳ��������ֻ����100���̴߳�������
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
					//��������
//					handleRequest(connection);
				}
			});
		}
	}

}
