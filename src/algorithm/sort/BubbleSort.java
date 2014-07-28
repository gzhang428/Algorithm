package algorithm.sort;
public class BubbleSort extends Sort {

	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(a);

	}
	@Override
	public void sort(int[] a){
		for (int j = a.length - 1; j > 0; j--){
			System.out.println(j);
			boolean swapped = false;
			for (int i = 0; i < j; i++){
				System.out.println("i=" + i);
				if (a[i] > a[i + 1]){
					swap(a, i, i + 1);
 					swapped = true;
				}
			}
			print(a);
			if (!swapped){
				break;
			}
		}
	}
}
