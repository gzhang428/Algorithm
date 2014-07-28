package algorithm.sort;
public class ShellSort extends Sort {
	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		ShellSort shellSort = new ShellSort();
		shellSort.sort(a);
		shellSort.print(a);

	}

	@Override
	public void sort(int[] a) {
		for (int h = a.length / 2; h > 0; h /= 2) {
			for (int j = h; j < a.length; j++) {
				int t = a[j];
				int i;
				for (i = j; i >= h; i -= h) {
					if (a[i - h] > t){
						a[i] = a[i - h];
					}else {
						break;
					}
				}
				a[i] = t;
			}
			print(a);
		}
	}
}
