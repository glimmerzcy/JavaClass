package edu.tju.experiment4.multiply;

import edu.tju.experiment4.martix.Matrix;

public class MatrixMultiply {
	
	/**
	 * 使用多个线程进行矩阵计算
	 * @param M1 待乘矩阵
	 * @param M2 待乘矩阵
	 * @param threadNumber 计算乘法的线程数
	 * @return 结果矩阵
	 * @throws MatrixMultiplyException 两个矩阵不可相乘
	 */
	public static Matrix multiThreadMultiply(Matrix M1, Matrix M2, int threadNumber) {
		if (M1.getCol() != M2.getRow()) {
			throw new MatrixMultiplyException();
		}
		
		Matrix M3 = new Matrix(M1.getRow(), M2.getCol());
		Thread[] threads = new Thread[threadNumber];
		for (int i = 0; i < threadNumber; i ++) {
			threads[i] = new MatrixMultiplyThread(M1, M2, M3, i, threadNumber);
			threads[i].start();
		}
		
		for (int i = 0; i < threadNumber; i ++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return M3;
	}
	
	/**
	 * 用串行的方式进行矩阵计算
	 * @param M1 待乘矩阵
	 * @param M2 待乘矩阵
	 * @return 结果矩阵
	 * @throws MatrixMultiplyException 两个矩阵不可相乘
	 */
	public static Matrix serialMultiply(Matrix M1, Matrix M2) {
		if (M1.getCol() != M2.getRow()) {
			throw new MatrixMultiplyException();
		}
		
		double[][] m1 = M1.getVal(), m2 = M2.getVal();
		int a = M1.getRow(), b = M2.getCol(), c = M1.getCol();
		Matrix M3 = new Matrix(a, b);
		double[][] res = M3.getVal();
		
		for (int i = 0; i < a; i ++) {
			for (int j = 0; j < b; j ++) {
				for (int k = 0; k < c; k ++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return M3;
	}
}
