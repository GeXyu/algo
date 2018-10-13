package cn.zzcode.geek._08stack;

/**
 * <p>
 * Title: LinkedListAlgo
 * </p>
 * <p>
 * Description: 基于链表的栈
 * 
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月12日 下午12:59:24
 * @modified [who date description]
 * @check [who date description]
 */
public class StackBasedLinkedList {

	private Node sentry;

	private int count;

	public StackBasedLinkedList() {
		sentry = new Node(0, null);
		count = 0;
	}

	/**
	 * 入栈
	 * 
	 * @param value
	 */
	public void push(int value) {
		Node node = new Node(value, sentry.next);
		sentry.next = node;
		count++;
	}

	/**
	 * 出栈
	 */
	public int pop() {
		if (count <= 0) {
			return -1;
		}
		Node pop = sentry.next;
		sentry.next = pop.next;
		count--;
		return pop.data;
	}

	/**
	 * 
	 */
	public void print() {

		Node curr = sentry.next;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println("");
	}

	/// -----------------------
	public class Node {

		public int data;
		public Node next;

		public Node(int data, Node next) {
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
			return String.valueOf(this.data);
		}
	}
}
