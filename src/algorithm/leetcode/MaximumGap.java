package algorithm.leetcode;

import java.util.Arrays;

public class MaximumGap {

	public static void main(String[] args) {
		int[] num = {7, 2, 1, 5};
		int res = new MaximumGap().maximumGap(num );
		System.out.println(res);
	}

	public int maximumGap(int[] num) {
		int n = num.length;
		int max = num[0];
		int min = num[0];
		for (int i = 1; i < num.length; i++){
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}
		
		int bucketLen = (int) Math.ceil((double)(max - min) / (n - 1));
		int bucketCount = (max - min) / bucketLen + 1;
		int[] bucketMin = new int[bucketCount];
		int[] bucketMax = new int[bucketCount];
		Arrays.fill(bucketMin, -1);
		Arrays.fill(bucketMax, -1);
		
		for (int k: num){
			int bucketNum = (k - min) / bucketLen;
			if (bucketMin[bucketNum] == -1){
				bucketMin[bucketNum] = k;
			} else {
				bucketMin[bucketNum] = Math.min(bucketMin[bucketNum], k);
			}
			if (bucketMax[bucketNum] == -1){
				bucketMax[bucketNum] = k;
			} else{
				bucketMax[bucketNum] = Math.max(bucketMax[bucketNum], k);
			}
		}
		int maxGap = Integer.MIN_VALUE;
		int maxNum = bucketMax[0];
		for (int i = 1; i < bucketCount; i++){
			if (bucketMin[i] == -1){
				continue;
			} else {
				int gap = bucketMin[i] - maxNum;
				maxNum = bucketMax[i];
				maxGap = Math.max(maxGap, gap);
			}
		}
		
		return maxGap;
	}

}
