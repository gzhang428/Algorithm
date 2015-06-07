package algorithm.interview;


public class MoveNonZeros {

	public static void main(String[] args) {
		int[] a = { 0, 0, 1, 1, 0, 1, 0, 0, 1 };
		int res = new MoveNonZeros().move(a);
		System.out.println(res);
	}

	private int move(int[] a) {
		int k = 0;
		int i = 0;
		while(i < a.length){
			if (a[i] != 0){
				swap(a, i, k);
				k ++;
			}
			i ++;
		}
		return k;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
