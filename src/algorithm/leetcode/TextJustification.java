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

	public List<String> fullJustify(String[] words, int L) {
		List<String> res = new ArrayList<>();
		if (words.length == 0) {
			return res;
		}

		int i = 0;
		int charNum = 0;
		List<String> lineWords = new ArrayList<>();
		while (i < words.length) {
			String word = words[i];
			charNum += word.length();
			if (charNum == L) {
				if (i == words.length - 1) {
					lineWords.add(word);
					String line = constructLine(lineWords, L, true);
					res.add(line);
					break;
				} else {
					lineWords.add(word);
					String line = constructLine(lineWords, L, false);
					res.add(line);
					lineWords.clear();
					charNum = 0;
					i++;
				}
			} else if (charNum > L) {
				String line = constructLine(lineWords, L, false);
				res.add(line);
				lineWords.clear();
				charNum = 0;
			} else {
				if (i == words.length - 1) {
					lineWords.add(word);
					String line = constructLine(lineWords, L, true);
					res.add(line);
					break;
				} else {
					charNum++;
					lineWords.add(word);
					i++;
				}
			}

		}

		return res;
	}

	private String constructLine(List<String> lineWords, int l, boolean lastLine) {
		int wordNum = lineWords.size();
		StringBuilder sb = new StringBuilder();
		if (wordNum == 1) {
			sb.append(lineWords.get(0));
		} else{
			int charNum = 0;
			for (String word : lineWords) {
				charNum += word.length();
			}
			int spaces = l - charNum;
			int avgSpace = spaces / (wordNum - 1);
			int moreSpace = spaces % (wordNum - 1);
	
			for (int i = 0; i < wordNum - 1; i++) {
				String word = lineWords.get(i);
				sb.append(word);
				if (lastLine){
					sb.append(" ");
				} else{
					for (int j = 0; j < avgSpace; j++) {
						sb.append(" ");
					}
					if (moreSpace > 0) {
						sb.append(" ");
						moreSpace--;
					}
				}
			}
			sb.append(lineWords.get(wordNum - 1));
		}
		for(int i = sb.length(); i< l; i++){
			sb.append(" ");
		}
		return sb.toString();
	}

}
