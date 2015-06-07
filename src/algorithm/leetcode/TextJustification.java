package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text",
				"justification." };
		List<String> res = new TextJustification().fullJustify(words, 16);
		System.out.println(res);
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		int i = 0;
		List<String> list = new ArrayList<>();
		int len = 0;
		List<String> res = new ArrayList<>();
		while (i < words.length) {
			String word = words[i];
			if (len + word.length() <= maxWidth) {
				list.add(word);
				len += word.length() + 1;
			} else {
				res.add(createLine(maxWidth, list, false));
				list.clear();
				list.add(word);
				len = word.length() + 1;
			}
			i++;
		}
		res.add(createLine(maxWidth, list, true));
		return res;
	}

	private String createLine(int maxWidth, List<String> list, boolean isLast) {
		StringBuilder sb = new StringBuilder();
		int n = list.size();
		if (n == 1 || isLast) {
			for (int i = 0; i < n - 1; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append(list.get(n - 1));
			while (sb.length() < maxWidth) {
				sb.append(" ");
			}
			return sb.toString();
		}
		int len = 0;
		for (String word : list) {
			len += word.length();
		}
		int spaces = (maxWidth - len) / (n - 1);
		int extras = (maxWidth - len) % (n - 1);
		for (int i = 0; i < n - 1; i++) {
			sb.append(list.get(i));
			int j = 0;
			while (j < spaces) {
				sb.append(" ");
				j++;
			}
			if (extras > 0){
				sb.append(" ");
				extras--;
			}
		}
		sb.append(list.get(n - 1));
		return sb.toString();
	}

}
