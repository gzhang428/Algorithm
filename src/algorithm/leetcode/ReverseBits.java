package algorithm.leetcode;

public class ReverseBits {

	public static void main(String[] args) {
		int res = new ReverseBits().reverseBits(2);
	}

	public int reverseBits(int n) {
		int m = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {

				m |= 1 << (31 - i);
				System.out.println(Integer.toBinaryString(m));
			}
		}
		return m;
	}

}
