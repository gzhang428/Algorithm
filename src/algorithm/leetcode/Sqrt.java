package algorithm.leetcode;

public class Sqrt {

	public static void main(String[] args) {
		int res = new Sqrt().mySqrt(2147395599);
		System.out.println(res);
	}

	public int mySqrt(int x) {
		int low = 0;
		int high = x;
		
		while(low <= high){
			int mid = (low + high) / 2;
			long s = (long)mid * mid;
			if (s == x){
				return mid;
			} else if (s > x){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}
}
