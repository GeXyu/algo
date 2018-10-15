package cn.zzcode.geek._09queue;

/**
 * <p>
 * Title: LinkedQueue
 * </p>
 * <p>
 * Description:基于链表
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月15日 下午9:23:29
 * @modified [who date description]
 * @check [who date description]
 */
public class LinkedQueue {

	private Node sentry;

	private Node head;

	private Node tail;

	private int count;

	public LinkedQueue() {
		sentry = new Node(null, null);
		tail = sentry;
		head = sentry;
		count = 0;
	}

	/**
	 * 入队
	 * 
	 * @param value
	 */
	public void enqueue(String value) {
		Node node = new Node(value, null);
		tail.next = node;
		tail = node;
		count++;
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public String dequeue() {
		Node next = sentry.next;
		head = next.next;
		sentry.next = head;

		count--;
		return next.data;

	}

	/**
	 * 长度
	 * 
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * 打印
	 */
	public void print() {
		Node currNode = sentry.next;
		while (currNode != null) {

			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();
	}

	// ---------------------
	public class Node {
		public String data;
		public Node next;

		public Node(String data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		/**
		 * @author XiuYu.Ge
		 * @created 2018年10月13日 上午9:19:38
		 * @return
		 */
		@Override
		public String toString() {
			return this.data;
		}
	}

}
