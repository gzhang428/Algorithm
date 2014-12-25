package algorithm.leetcode;

public class Sqrt {

	public static void main(String[] args) {
		int res = new Sqrt().sqrt(2147395599);
		System.out.println(res);
	}

	public int sqrt(int x) {
        if (x == 0){
            return 0;
        }   
        if (x == 1){
            return 1;
        }
        int low = 1;
        int high = x / 2;
        
        while (low <= high){
            int mid = (low  + high) / 2;
        	long r1 = (long)mid * (long)mid;
        	long r2 = (long)(mid + 1) * (long)(mid + 1);
            if (r1 <= x && r2 > x){
                return mid;
            } else if (r1 > x){
                high = mid - 1;
            } else if (r2 <= x){
                low = mid + 1;
            }
            
        }
        return -1;
        
    }
}
