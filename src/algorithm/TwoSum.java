package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		//long[] a = twoSum.readArray("D:/algo1-programming_prob-2sum.txt");
		//int n = twoSum.count(a);
		int[] a = {1, 4, 6, 4, 2, 9, 7, 4, 2};
		List<int[]> res = twoSum.findTwoSum(a, 8);
		for (int[] pair: res){
			System.out.println(Arrays.toString(pair));
		}
	}

	
	public List<int[]> findTwoSum(int[] a, int t) {
		List<int[]> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i: a){
			if (map.containsKey(t - i) && map.get(t - i) > 0){
				int[] pair = new int[2];
				pair[0] = i;
				pair[1] = t - i;
				res.add(pair);
				map.put(t - i, map.get(t - i) - 1);
			} else {
				if (map.containsKey(i)){
					map.put(i, map.get(i) + 1);
				} else {
					map.put(i, 1);
				}
			}
		}
		return res;
	}
	
	
	
	
	private int count(long[] a) {
		Set<Long> set = new HashSet<>();
		for (long n: a){
			set.add(n);
		}
		int count = 0;
		for (long i = -10000; i <= 10000; i++){
			for (long n: a){
				if (n  + n != i  && set.contains(i - n)){
					System.out.println(i + " " + n);
					count ++;
					break;
				}
			}
			if (i % 100 == 0){
				System.out.println(i + " " + count);
			}
		}
		return count;
	}

	private  long[] readArray(String file) {
		long[] a = new long[1000000];
		try {
			String line = null;
			int i = 0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				a[i] = Long.parseLong(line);
				i ++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

}
