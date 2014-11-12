package algorithm.leetcode;

public class LongestPalindrome {

	public static void main(String[] args) {
		String res = new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
		System.out.println(res);
	}

	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()){
			return "";
		}
		int n = s.length();
		boolean[][] a = new boolean[n][n];
		int start = 0;
		int maxLength = 1;
		
		for (int i = 0; i < n; i++){
			a[i][i] = true;
		}
		
		for (int i = 0; i < n - 1; i++){
			if (s.charAt(i) == s.charAt(i + 1)){
				a[i][i + 1] = true;
				start = i;
				maxLength  = 2;
			}
		}
		
		for (int l = 3; l <= n; l++){
			for (int i = 0; i < n - l + 1; i++){
				int j = i + l - 1;
				a[i][j] = a[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
				if (a[i][j] ){
					start = i;
					maxLength = l;
				}
			}
		}
		return s.substring(start, start + maxLength);   
	}
}
