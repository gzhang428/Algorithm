package algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class PrintPowSet {

	public static void main(String[] args) {
		new PrintPowSet().print(5);
	}

	private void print(int n) {
		List<Integer> list = new ArrayList<>();
		print(n, 1, list);
	}

	private void print(int n, int start, List<Integer> list){
		System.out.println(list);
		for (int i = start; i <= n; i++){
			list.add(i);
			print(n, i + 1, list);
			list.remove(list.size() - 1);
		}
	}
}
