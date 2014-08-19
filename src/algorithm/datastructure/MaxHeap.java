package algorithm.datastructure;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

	public MaxHeap(){
		super();
	}
	public MaxHeap(int capacity) {
		super(capacity);
	}
	
	public MaxHeap(T[] a){
		super(a);
	}

	
	@Override
	protected void percolateDown(int pos) {
		T t = array[pos];
		int child;
		for (; pos * 2 <= size; pos = child){
			child = pos * 2;
			if (child != size && array[child].compareTo(array[child + 1]) < 0){
				child++;
			}
			if (t.compareTo(array[child]) < 0){
				array[pos] = array[child];
			}else {
				break;
			}
		}
		array[pos] = t;
	}

	@Override
	protected void percollateUp(int pos) {
		T t = array[pos];
		for (; pos > 1; pos /= 2){
			if (t.compareTo(array[pos / 2]) > 0){
				array[pos] = array[pos / 2];
			} else {
				break;
			}
		}
		array[pos] = t;
	}
	
	public T findMax() {
		return findRoot();
	}
	
	public T extractMax() {
		return extractRoot();
	}
	
	public static void main(String[] args) {
		Double[] a = {5., 4., 7., 2., 8., 9., 1., 3., 0., 6.};
		MaxHeap<Double> h = new MaxHeap<Double>(a);
		h.print();
		h.insert(5.);
		h.print();
		double m1 = h.extractRoot();
		System.out.println(m1);
		h.print();
		h.delete(5.);
		h.print();
		h.deletePos(2);
		h.print();
	}


}
