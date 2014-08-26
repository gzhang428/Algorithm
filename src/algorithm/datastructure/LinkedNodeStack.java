package algorithm.datastructure;

public class LinkedNodeStack<T> implements Stack<T> {
	private LinkedNode<T> top;
	private int size;
	
	public LinkedNodeStack (){
		top = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void push(T t) {
		LinkedNode<T> node = new LinkedNode<>(t);
		node.next  = top;
		top = node;
		size ++;
	}
	

	@Override
	public T pop() {
		if (isEmpty()){
			throw new RuntimeException("Empty Stack");
		}
		T res = top.data;
		top = top.next;
		size --;
		return res;
	}
	
	public static void main(String[] args){
		LinkedNodeStack<Integer> stack = new LinkedNodeStack<>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.size());
		stack.push(3);
		System.out.println(stack.pop());
	}

}
