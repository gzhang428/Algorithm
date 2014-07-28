package algorithm.sort;

public class InsertionSort extends Sort {
	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(a);

	}
	@Override
	public void sort(int[] a) {
		for (int j = 1; j < a.length; j++){
			int i;
			int t = a[j];
			System.out.println("j=" + j + " t=" + t);
			for (i = j; i > 0; i--){
				if (a[i - 1] > t){
					a[i] = a[i - 1];
					System.out.println("i=" + i);
					print(a);
				} else{
					break;
				}
			}
			a[i] = t;
			System.out.println("i=" + i);
			print(a);
		}
	}
}
