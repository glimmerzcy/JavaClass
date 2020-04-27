package edu.tju.experiment4.martix;

import java.util.Arrays;

public class Matrix {
	private double[][] val;
	private int row, col;

	/**
	 * @param row 行数
	 * @param col 列数
	 * @return 返回一个 row 行 col 列的矩阵，元素的值为0至1之间的随机值
	 * @author zcy
	 */
	public Matrix(int row, int col) {
		val = new double[row][col];
		this.row = row;
		this.col = col;
	}
	
	/**
	 * 将矩阵填入随机数据
	 */
	public void random() {
		for (int i = 0; i < row; i ++) {
			for (int j = 0; j < col; j ++) {
				val[i][j] = Math.random();
			}		
		}
	}
	
	/**
	 * 打印该矩阵
	 */
	public void print() {
		for (int i = 0; i < row; i ++) {
			for (int j = 0; j < col; j ++) {
				System.out.print(val[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public double[][] getVal() {
		return val;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		result = prime * result + Arrays.deepHashCode(val);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Matrix))
			return false;
		Matrix other = (Matrix) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		if (!Arrays.deepEquals(val, other.val))
			return false;
		return true;
	}
	
	
}
