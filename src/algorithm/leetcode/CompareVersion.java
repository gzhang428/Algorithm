package algorithm.leetcode;

public class CompareVersion {

	public static void main(String[] args) {
		int res = new CompareVersion().compareVersion("1.1", "1.01.0");
		System.out.println(res);
	}

	public int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");

		
		int i = 0;
		while (i < Math.min(str1.length, str2.length)){
			int v1 = Integer.parseInt(str1[i]);
			int v2 = Integer.parseInt(str2[i]);
			if (v1 > v2){
				return 1;
			} else if (v1 < v2 ){
				return -1;
			} else {
				i ++;
			}
		}
		
		while(i < str1.length){
			int v1 = Integer.parseInt(str1[i]);
			if (v1 > 0){
				return 1;
			} else {
				i ++;
			}
		}
		while (i < str2.length){
			int v2 = Integer.parseInt(str2[i]);
			if (v2 > 0){
				return -1;
			} else {
				i ++;
			}
		}
		return 0;

	}
}
