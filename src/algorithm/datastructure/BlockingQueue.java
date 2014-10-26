package algorithm.datastructure;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
	
	Queue<T> queue = new LinkedList<T>();
	private int capacity;
	
	public BlockingQueue(int capacity){
		this.capacity = capacity;
	}
	
	public synchronized void enqueue(T t) throws InterruptedException{
		while(queue.size() == capacity){
			wait();
		}
		if(queue.size() == 0) {
			notifyAll();
		}
		queue.add(t);
	}
	
	public synchronized T dequeue() throws InterruptedException{
		while(queue.size() == 0){
			wait();
		}
		if (queue.size() == capacity){
			notifyAll();
		}
		T res = queue.remove();
		return res;
	}
	

	public static void main(String[] args) {
		final BlockingQueue<Integer> bq = new BlockingQueue<>(2);
		Thread producer = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					bq.enqueue(1);
					System.out.println("put 1");
					bq.enqueue(2);
					System.out.println("put 2");
					bq.enqueue(3);
					System.out.println("put 3");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producer.start();
		
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println(bq.dequeue());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		consumer.start();
		
	}

}
