package algorithm;

public class MatrixMultiplication {

	public static void main(String[] args) {
		double[][] m = {{1,2,3,4}, 
				     {5,6,7,8}, 
				     {9,10,11,12}, 
				     {13,14,15,16}};
		MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
		double[][] product = matrixMultiplication.multiply(m, m);
		matrixMultiplication.print(product);
		product = matrixMultiplication.strassenMultiply(m, m);
		matrixMultiplication.print(product);
	}

	private void print(double[][] m) {
		int row = m.length;
		int column = m[0].length;
		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	private double[][] add(double[][] m1, double[][] m2){
		int row = m1.length;
		int column  = m1[0].length;
		double[][] sum = new double[row][column];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				sum[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return sum;
	}
	
	private double[][] subtract(double[][] m1, double[][] m2){
		int row = m1.length;
		int column  = m1[0].length;
		double[][] sum = new double[row][column];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				sum[i][j] = m1[i][j] - m2[i][j];
			}
		}
		return sum;
	}
	
	public double[][] multiply(double[][] m1, double[][] m2) {
		int a = m1.length;
		int b = m1[0].length;
		int c = m2[0].length;
		
		double[][] product = new double[a][c];
		for (int i = 0; i < a; i++){
			for (int j = 0; j< c; j++){
				for (int k = 0; k < b; k++){
					product[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return product;
	}

	private double[][] getBlock(double[][] m, int i0, int in, int j0, int jn){
		int row = in - i0 + 1;
		int column = jn - j0 + 1;
		double[][] block = new double[row][column];
		
		int it = 0;
		for (int i = i0; i <= in; i++){
			int jt = 0;
			for (int j = j0; j <= jn; j++){
				block[it][jt] = m[i][j];
				jt++;
			}
			it++;
		}
		return block;
	}
	
	// For square matrix with matrix size 2^i only
	public double[][] strassenMultiply(double[][] m1, double[][] m2){
		if (m1.length > 1){
			int low = 0;
			int high = m1.length - 1;
			int mid = (low + high) / 2;
			double[][] a = getBlock(m1, low, mid, low, mid);
			double[][] b = getBlock(m1, low, mid, mid + 1, high);
			double[][] c = getBlock(m1, mid + 1, high, low, mid);
			double[][] d = getBlock(m1, mid + 1, high, mid + 1, high);
			double[][] e = getBlock(m2, low, mid, low, mid);
			double[][] f = getBlock(m2, low, mid, mid + 1, high);
			double[][] g = getBlock(m2, mid + 1, high, low, mid);
			double[][] h = getBlock(m2, mid + 1, high, mid + 1, high);
			
			double[][] p1 = strassenMultiply(a, subtract(f, h));
			double[][] p2 = strassenMultiply(add(a, b), h);
			double[][] p3 = strassenMultiply(add(c, d), e);
			double[][] p4 = strassenMultiply(d, subtract(g, e));
			double[][] p5 = strassenMultiply(add(a, d), add(e, h));
			double[][] p6 = strassenMultiply(subtract(b, d), add(g, h));
			double[][] p7 = strassenMultiply(subtract(a, c), add(e, f));
			
			return formMatrix(add(subtract(add(p5, p4), p2), p6), add(p1, p2), add(p3, p4), subtract(subtract(add(p1, p5), p3), p7));
		}
		
		double[][] res = new double[1][1];
		res[0][0] = m1[0][0] * m2[0][0];
		return res;
	}

	private double[][] formMatrix(double[][] upLeft, double[][] upRight, double[][] downLeft, double[][] downRight) {
		int row = upLeft.length + downLeft.length;
		int column = upLeft[0].length + upRight[0].length;
		double[][] res = new double[row][column];
		
		int it = 0;
		for (int i = 0; i < upLeft.length; i++){
			int jt = 0;
			for (int j = 0; j < upLeft[0].length; j++){
				res[it][jt] = upLeft[i][j];
				jt++;
			}
			it++;
		}
		
		it = 0;
		for(int i = 0; i < upRight.length; i++){
			int jt = upLeft[0].length;
			for (int j = 0; j < upRight[0].length; j++){
				res[it][jt] = upRight[i][j];
				jt++;
			}
			it++;
		}
		
		it = upLeft.length;
		for (int i = 0; i < downLeft.length; i++){
			int jt = 0;
			for (int j = 0; j < downLeft[0].length; j++){
				res[it][jt] = downLeft[i][j];
				jt++;
			}
			it++;
		}
		
		it = upRight.length;
		for (int i = 0; i < downRight.length; i++){
			int jt = downLeft[0].length;
			for (int j = 0; j < downRight[0].length; j++){
				res[it][jt] = downRight[i][j];
				jt++;
			}
			it++;
		}
		return res;
	}
}
