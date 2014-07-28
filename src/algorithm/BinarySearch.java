package algorithm;
public class BinarySearch {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BinarySearch binarySearch = new BinarySearch();
		int pos = binarySearch.iterativeBinarySearch(a, 3);
		System.out.println(pos);
		pos = binarySearch.search(a, 9);
		System.out.println(pos);
	}

	public int iterativeBinarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length;
		while (low < high - 1) {
			int mid = (low + high) / 2;
			if (x == a[mid]){
				return mid;
			} if(x < a[mid]){
				high = mid;
			} else{
				low = mid+1;
			}
		}
		if (a[low] == x){
			return low;
		} else {
			return -1;
		}
	}
	private int search(int[] a, int i) {
		return recursiveBinarySearch(a, 0, a.length, i);
	}

	public int recursiveBinarySearch(int[] a, int low, int high, int x){
		if (low < high - 1) {
			int mid = (low + high) / 2;
			if (x == a[mid]){
				return mid;
			} else if (x < a[mid]){
				return recursiveBinarySearch(a, low, mid, x);
			} else {
				return recursiveBinarySearch(a, mid + 1, high, x);
			}
		}
		if (a[low] == x){
			return low;
		} else {
			return -1;
		}
	}
}
