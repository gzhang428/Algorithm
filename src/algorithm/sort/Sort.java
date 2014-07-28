package algorithm.sort;

public abstract class Sort {
	public abstract void sort(int[] a);
	protected void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	protected void swap(int[] a, int n, int m ) {
		int t = a[n];
		a[n] = a[m];
		a[m] = t;
	}
}
