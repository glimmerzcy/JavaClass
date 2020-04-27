package edu.tju.experiment4.test;

import java.util.Date;

import edu.tju.experiment4.martix.Matrix;
import edu.tju.experiment4.multiply.MatrixMultiply;

public class Test {

	public static void main(String[] args) {
		
		// 最大线程数
		final int threadNumber = 10;
        // 矩阵边长从100-1000，以100递增
		final int base = 100, max = 11;
        // 计算五次取平均值
		final int times = 5;
		
		int[][] executeTime = new int[max][];
		System.out.print("\t");
		for (int j = 0; j <= threadNumber; j ++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int i = 1; i < max; i ++) {
			int a = i * base;
			executeTime[i] = getExecuteTime(a, a, a, threadNumber, times);
			System.out.print(a + "\t");
			for (int j = 0; j <= threadNumber; j ++) {
				System.out.print(executeTime[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static int[] getExecuteTime(int a, int b, int c, int threadNumber, int times) {
		int[] executeTime = new int[threadNumber + 1];
		
		Matrix M1 = new Matrix(a, b);
		M1.random();
		Matrix M2 = new Matrix(b, c);
		M2.random();
		long ss = new Date().getTime();
		Matrix M3 = MatrixMultiply.serialMultiply(M1, M2);
		long ee = new Date().getTime();
		executeTime[0] = (int) (ee - ss);

		
		Matrix[] res = new Matrix[threadNumber + 1];
		for (int i = 1; i <= threadNumber; i ++) {
			
			for (int j = 0; j < times; j ++) {
				long startTime = new Date().getTime();
				res[i] = MatrixMultiply.multiThreadMultiply(M1, M2, i);
				long endTime = new Date().getTime();
				executeTime[i] += (int) (endTime - startTime);
				assert res[i].equals(M3) : "Wrong Answer";
			}
			executeTime[i] /= times;
//			System.out.println(i + ": pass in " + executeTime);
		}

		return executeTime;
	}

}
