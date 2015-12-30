package SimpleBFSCrawler;

import java.util.LinkedList;

public class Queue {
	//链表实现队列
	private LinkedList<String> queue = new LinkedList<String>();
	//入
	public void enQueue(String t) {
		queue.addLast(t);
	}
	//出
	public Object deQueue() {
		return queue.removeFirst();
	}
	//判空
	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}
	//判断包含
	public boolean contians(Object t) {
		return queue.contains(t);
	}
	//判空
	public boolean empty() {
		return queue.isEmpty();
	}

}
