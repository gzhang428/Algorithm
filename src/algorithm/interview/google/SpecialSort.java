package algorithm.interview.google;

public class SpecialSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 3, 2, 1, 5, 6, 7, 4};
		new SpecialSort().specialSort(arr);
	}

	private void specialSort(int[] arr) {
		boolean bigger = true;
		
		for (int i = 1; i < arr.length; i++){
			if (bigger && arr[i] < arr[i - 1]){
				swap(arr, i, i - 1);
			} else if (!bigger && arr[i] > arr[i - 1]){
				swap(arr, i, i - 1);
			}
			bigger = !bigger;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
