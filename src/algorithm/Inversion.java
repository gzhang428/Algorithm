package algorithm;

public class Inversion {

	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		Inversion inversion = new Inversion();
		int num = inversion.bruteForce(a);
		System.out.println(num);
		num = inversion.divideAndConquer(a);
		System.out.println(num);
	}
	
	public int bruteForce(int[] a){
		int num = 0;
		for (int j = 0; j < a.length - 1; j++){
			for (int i = j + 1; i < a.length; i++){
				if (a[i] < a[j]){
					num ++;
				}
			}
		}
		return num;
	}
	
	
	public int divideAndConquer(int[] a){
		int[] t = new int[a.length];
		return sortAndCount(a, t, 0, a.length);
	}

	private int sortAndCount(int[] a, int[] t, int low, int high) {
		if (low < high - 1){
			int mid = (low + high) / 2;
			int left = sortAndCount(a, t, low, mid);
			int right = sortAndCount(a, t, mid, high);
			int split = mergeAndCountSplit(a, t, low, mid, high);
			return left + right + split;
		}
		return 0;
	}

	private int mergeAndCountSplit(int[] a, int[] t, int low, int mid, int high) {
		int inversionNum = 0;
		for (int i = low; i < high; i++){
			t[i] = a[i];
		}
		int i = low;
		int j = mid;
		int k = low;
		
		while (i < mid && j < high){
			if (t[i] <= t[j]){
				a[k] = t[i];
				i++;
				k++;
			} else {
				a[k] = t[j];
				j++;
				k++;
				inversionNum += mid - i;
			}
		}
		
		while ( i < mid){
			a[k] = t[i];
			i++;
			k++;
		}
		
		while (j < high){
			a[k] = t[j];
			j++;
			k++;
		}
		return inversionNum;
	}

}
