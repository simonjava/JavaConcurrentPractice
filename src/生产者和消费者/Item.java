package 生产者和消费者;


/**
 * @author simin
 * 商品
 */
public class Item {
	//被谁生产
	String producer;
	//被谁消费
	String consumer;
	//里面的内容，用一个整数表示
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
