package �����ߺ�������;


/**
 * @author simin
 * ��Ʒ
 */
public class Item {
	//��˭����
	String producer;
	//��˭����
	String consumer;
	//��������ݣ���һ��������ʾ
	int content;
	public Item(String producer, int content) {
		super();
		this.producer = producer;
		this.content = content;
	}
	
	public void setConsumer(String consumer)
	{
		this.consumer = consumer;
	}

	@Override
	public String toString() {
		return "Item [producer=" + producer + ", consumer=" + consumer
				+ ", content=" + content + "]";
	}

	
}
