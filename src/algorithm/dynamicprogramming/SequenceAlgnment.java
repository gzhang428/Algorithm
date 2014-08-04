package algorithm.dynamicprogramming;

public class SequenceAlgnment {
	
	

	private static final int GAP_PENALTY = -1;
	private static final int MATCH_SCORE = 1;
	private static final int MISMATCH_PENALTY = -2;

	public static void main(String[] args) {
		String str1 = "AGGGCT";
		String str2 = "AGGCA";
		
		SequenceAlgnment sequenceAlgnment = new SequenceAlgnment();
		int value = sequenceAlgnment.find(str1, str2);
		System.out.println(value);
				
	}

	private int find(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] a = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++){
			a[i][0] = i * GAP_PENALTY;
		}
		
		for (int j = 0; j <= n; j++){
			a[0][j] = j * GAP_PENALTY;
		}
		
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <=n; j++){
				char c1 = str1.charAt(i - 1);
				char c2 = str2.charAt(j - 1);
				a[i][j] = Math.max(a[i - 1][j - 1] + ((c1 == c2)? MATCH_SCORE: MISMATCH_PENALTY), Math.max( a[i - 1][j] + GAP_PENALTY, a[i][j - 1] + GAP_PENALTY));
			}
		}
		
		return a[m][n];
	}

}
