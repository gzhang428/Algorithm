package algorithm.interview;

public class FixedPoint {

	public static void main(String[] args) {
		
	}
	
	public int findFixedPoint(int[] a){
		int low = 0;
		int high = a.length - 1;
		while(low <= high){
			int mid = (low + high) / 2;
			if (mid == a[mid]){
				return mid;
			}
			if (mid > a[mid]){
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
