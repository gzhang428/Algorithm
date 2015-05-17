package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort{

	public static void main(String[] args) {
		int[] a = { 3, 11, 5, 7, 3, 7, 8, 0, 4, 16, 7};
		new BucketSort().sort(a, 5);
		System.out.println(Arrays.toString(a));
	}

	public void sort(int[] a, int n) {
		int max = a[0];
		int min = a[0];
		for (int i = 1; i < a.length; i++){
			max = Math.max(a[i], max);
			min = Math.min(a[i], min);
		}

		double len = (double)(max - min) / (n - 1);
		System.out.println(len);
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < n; i++){
			buckets.add(new ArrayList<Integer>());
		}
		
		for (int num: a){
			int b = (int) ((num - min) / len);
			buckets.get(b).add(num);
		}
		System.out.println(buckets);
		int pos = 0;
		for (List<Integer> bucket: buckets){
			Collections.sort(bucket);
			for (int num: bucket){
				a[pos ++] = num;
			}
		}
		
	}

	
}
