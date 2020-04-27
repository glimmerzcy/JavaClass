package edu.tju.experiment4.multiply;

import edu.tju.experiment4.martix.Matrix;

public class MatrixMultiplyThread extends Thread {
	
	double[][] m1, m2, m3;
	int a, b, c;
	int start, step;
	
	/**
	 * @param M1 待乘矩阵
	 * @param M2 待乘矩阵
	 * @param M3 目标矩阵
	 * @param start 开始计算的行数
	 * @param step 每次递增的行数
	 * @throws MatrixMultiplyException 两个矩阵不可相乘
	 */
	public MatrixMultiplyThread(Matrix M1, Matrix M2, Matrix M3, int start, int step) {
		if (M1.getCol() != M2.getRow()) {
			throw new MatrixMultiplyException();
		}
		a = M3.getRow();
		b = M3.getCol();
		c = M1.getCol();
		m1 = M1.getVal();
		m2 = M2.getVal();
		m3 = M3.getVal();
		this.start = start;
		this.step = step;
	}
	

	@Override
    public void run() {
		for (int i = start; i < a; i += step) {
			for (int j = 0; j < b; j ++) {
				for (int k = 0; k < c; k ++) {
					m3[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
    }
}
