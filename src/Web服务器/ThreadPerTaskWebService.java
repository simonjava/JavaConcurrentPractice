package Web������;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author simin
 * Web������Ϊÿ�����񴴽�һ���̴߳�������
 * ��Ҫ��ô����������Ϊÿ�����񶼴���һ���̣߳�����̫���Ҳ��ȶ�
 * ʹ�û���   ������-�����ߵ� Executor ��������Щ�߳�
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
					//��������
//					handleRequest(connection);
				}
			}).start();
		}
	}

}
