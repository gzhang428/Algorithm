package algorithm;

public class KaratsubaMultiplication {

	public static void main(String[] args) {
		KaratsubaMultiplication test = new KaratsubaMultiplication();
		int product = test.multiply(1234567, 12);
		System.out.println(product);
	}

	private int multiply(int i, int j) {
		System.out.println(i + "*" + j );
		if (digit(i) == 1 || digit(j) == 1){
			System.out.println("=" + i*j);
			return i * j;
		}
		int n = Math.max(digit (i), digit(j)) / 2;
		int m  = (int)Math.pow(10, n);
		int b = i % m;
		int a = (i - b) / m;
		int d = j % m;
		int c = (j - d) / m;
		System.out.println("A=" + a + " B=" + b + " C=" + c + " D=" + d);
		int r1 = multiply(a, c);
		int r2 = multiply(b, d);
		int r3 = multiply(a + b,  c + d);
		System.out.println("AC=" + r1 + " BD=" + r2 + " (A+C)(B+D)=" + r3);
		int r = r1 * m * m + r2 + (r3 - r2 - r1) * m;
		System.out.println("R=" + r);
		return r;
	}
	
	private int digit(int n){
		if (n == 0){
			return 1;
		}
		return (int)Math.log10(n) + 1;
	}

}
