package algorithm.datastructure;

public interface Queue<T> {
	boolean isEmpty();
	int size();
	void enqueue(T t);
	T dequeue();
}
