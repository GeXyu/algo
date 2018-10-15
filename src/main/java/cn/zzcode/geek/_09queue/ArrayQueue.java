package cn.zzcode.geek._09queue;

/**
 * <p>
 * Title: ArrayQueue
 * </p>
 * <p>
 * Description:基于数组
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月15日 下午9:23:08
 * @modified [who date description]
 * @check [who date description]
 */
public class ArrayQueue {

	private int head;

	private int tail;

	private String[] data;

	private int count;

	public ArrayQueue() {
		head = 0;
		tail = 0;
		data = new String[10];
	}

	/**
	 * 入队
	 * 
	 * @param value
	 */
	public void enqueue(String value) {
		if (count > data.length) {
			return;
		}

		data[tail] = value;
		tail++;
		count++;
	}

	/**
	 * 出队
	 */
	public String dequeue() {
		if (count <= 0) {
			return "";
		}

		String result = data[head];

		String[] newData = new String[data.length];
		count--;

		// 拷贝数组  节省空间
		System.arraycopy(data, head + 1, newData, 0, count);
		data = newData;
		tail--;

		return result;
	}

	/**
	 * 
	 */
	public void print() {
		for (int curr = 0; curr < count; curr++) {
			System.out.print(data[curr] + " ");
		}
		System.out.println();
	}

}
