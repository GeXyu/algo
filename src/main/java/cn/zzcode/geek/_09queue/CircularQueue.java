package cn.zzcode.geek._09queue;

public class CircularQueue {

	private String[] data;

	private int head = 0;

	private int tail = 0;

	public int count;

	public CircularQueue(int capacity) {
		data = new String[capacity + 1];
	}

	/**
	 * 入队
	 * 
	 * @param value
	 */
	public void enqueue(String value) {

		int next = (tail + 1) % data.length;
		// 队满
		if (next == head) {
			return;
		}
		data[tail] = value;
		tail = next;
		count++;
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public String dequeue() {
		String result = data[head];
		head = (head + 1) % data.length;
		count--;
		return result;
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
		for (int curr = head; curr % data.length != tail; curr++) {
			System.out.print(data[curr] + " ");
		}
		System.out.println();
	}
}
