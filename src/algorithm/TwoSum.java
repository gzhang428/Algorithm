package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		long[] a = twoSum.readArray("D:/algo1-programming_prob-2sum.txt");
		int n = twoSum.count(a);
		System.out.println(n);
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
