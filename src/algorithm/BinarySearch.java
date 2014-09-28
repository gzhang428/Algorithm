package algorithm;
public class BinarySearch {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BinarySearch binarySearch = new BinarySearch();
		int pos = binarySearch.iSearch(a, 10);
		System.out.println(pos);
		int pos2 = binarySearch.rSearch(a, 10);
		System.out.println(pos2);
	}

	public int iSearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]){
				return mid;
			} if(x < a[mid]){
				high = mid - 1;
			} else{
				low = mid + 1;
			}
		}
		throw new RuntimeException("Element not found");
	}
	
	public int rSearch(int[] a, int i) {
		return rSearch(a, 0, a.length - 1, i);
	}

	private int rSearch(int[] a, int low, int high, int x){
		if (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]){
				return mid;
			} else if (x < a[mid]){
				return rSearch(a, low, mid - 1, x);
			} else {
				return rSearch(a, mid + 1, high, x);
			}
		}
		throw new RuntimeException("Element not found");
	}
}
