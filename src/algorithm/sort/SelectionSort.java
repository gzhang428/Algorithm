package algorithm.sort;

public class SelectionSort extends Sort {
	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(a);
		selectionSort.print(a);

	}

	//minimize number of swap
	@Override
	public void sort(int[] a) {
		for(int j = 0; j < a.length-1; j++){
			int min = j;
			for(int i = j + 1; i < a.length; i++){
				if(a[i] < a[min]){
					min = i;
				}
			}
			swap(a, j, min);
		}		
	}
}
