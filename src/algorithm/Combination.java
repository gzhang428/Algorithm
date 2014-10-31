package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination<T> {

	public static void main(String[] args) {
		Combination<String> combination = new Combination<String>();
		String[] input = {"a", "b", "c", "d"};
		List<List<String>> res = combination.find(input, 2);
		System.out.println(res);
	}

	public List<List<T>> find(T[] input, int k) {
		List<List<T>> res = new ArrayList<>();
		T[] buff = (T[]) new Object[k];
		find(input, k, 0, buff, 0, res);
		return res;
	}
	
	private void find(T[] array, int k, int arrayIndex, T[] buff, int buffIndex, List<List<T>> res) {
		if (buffIndex == k) {
			List<T> combination = new ArrayList<T>(Arrays.asList(buff));
			res.add(combination);
			return;
		}

		for (int i = arrayIndex; i < array.length; i++) {
			buff[buffIndex] = array[i];
 			find(array, k, i + 1, buff, buffIndex + 1, res);
		}
	}

}
