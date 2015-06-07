package algorithm.interview;

public class SmallestCharacter {

	public static void main(String[] args) {
		char[] chars = {'c', 'c', 'k'};
		char res = new SmallestCharacter().find(chars , 'f');
		System.out.println(res);
	}

	private char find(char[] chars, char c) {
		int n = chars.length;
		int low = 0;
		int high = n - 1;
		while(low <= high){
			int mid = (low + high) / 2;
			if (chars[mid] == c){
				if (mid == n -1){
					return chars[0];
				} else {
					return chars[mid + 1];
				}
			} else if (chars[mid]> c){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (low > n - 1){
			return chars[0];
		} else {
			return chars[low];
		}
	}

}
