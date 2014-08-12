package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination<T> {

	public static void main(String[] args) {
		Combination<String> combination = new Combination<String>();
		String[] input = {"a", "b", "c", "d"};
		List<Set<String>> res = combination.find(input, 2);
		System.out.println(res);
	}

	public List<Set<T>> find(T[] input, int k) {
		List<Set<T>> res = new ArrayList<>();
		T[] buff = (T[]) new Object[k];
		combine(input, k, 0, buff, 0, res);
		return res;
	}
	
	private void combine(T[] array, int k, int arrayIndex, T[] buff, int buffIndex, List<Set<T>> res) {
		if (buffIndex == k) {
			Set<T> set = new HashSet<T>(Arrays.asList(buff));
			res.add(set);
			return;
		}

		for (int i = arrayIndex; i < array.length; i++) {
			buff[buffIndex] = array[i];
 			combine(array, k, i + 1, buff, buffIndex + 1, res);
		}
	}

}
