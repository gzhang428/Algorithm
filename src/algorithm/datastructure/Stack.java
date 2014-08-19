package algorithm.datastructure;

public interface Stack<T> {
	boolean isEmpty();
	int size();
	void push(T t);
	T pop();
}
