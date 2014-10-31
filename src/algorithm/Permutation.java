package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation<T> {

	
	public static void main(String[] args) {
		Permutation<String> permutation = new Permutation<>();
		String[] input = {"a", "b", "c"};
		List<List<String>> res = permutation.find(input, 3);
		System.out.println(res);
	}

	private List<List<T>> find(T[] input, int k) {
		Combination<T> c = new Combination<>();
		List<List<T>> combinations = c.find(input, k);
		List<List<T>> res = new ArrayList<>();
		
		for (List<T> combination: combinations){
			permutate((T[]) combination.toArray(), 0, res);
		}
		return res;
	}

	public void permutate(T[] buff, int start,  List<List<T>> res) {
		if (start == buff.length - 1){
			List<T> perm = new ArrayList<>(Arrays.asList(buff));
			res.add(perm);
			return;
		}
		
		for (int i = start; i < buff.length; i++){
			swap(buff, start, i);
			permutate(buff, start + 1, res);
			swap(buff, start, i);
		}
		
	}

	private void swap(T[] buff, int i, int j) {
		T t = buff[i];
		buff[i] = buff[j];
		buff[j] = t;
	}

}
