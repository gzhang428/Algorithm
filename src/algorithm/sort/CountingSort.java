package algorithm.sort;

import java.util.Arrays;

public class CountingSort extends Sort{

	public static void main(String[] args) {
		int[] a = {3, 11, 5, 7, 3, 7, 8, 0, 4, 16, 7};
		new CountingSort().sort(a );
		System.out.println(Arrays.toString(a));
	}

	@Override
	public void sort(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++){
			max = Math.max(max, a[i]);
		}
		int[] count = new int[max + 1];
		for (int num: a){
			count[num] ++;
		}
		System.out.println(Arrays.toString(count));
		for (int i = 1; i < count.length; i++){
			count[i] += count[i - 1];
		}
		System.out.println(Arrays.toString(count));
		int pos = 0;
		for (int i = 0; i < count.length; i++){
			while(pos < count[i]){
				a[pos ++] = i;
			}
		}
	}

}
