package dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubMatrix {

	private Integer[][] matrix;

	public SubMatrix(Integer[][] matrix) {
		this.matrix = matrix;
	}

	public Integer[][] getMatrix() {
		return matrix;
	}

	public Integer[][] getSubMatrix(int x, int y, int n) {
		if (matrix == null || matrix.length < 2)
			return null;
		if (matrix[0] == null || matrix[0].length < 2 || matrix.length != matrix[0].length) {
			return null;
		}
		int firstRowLength = matrix[0].length;
		for (Integer[] row : matrix) {
			if (row == null || row.length != firstRowLength)
				return null;
		}
		if (x >= matrix.length || y >= matrix.length) {
			return null;
		}
		Integer[][] result = new Integer[n * 2 + 1][n * 2 + 1];
		for (int i = -n; i <= n; i++) {
			for (int j = -n; j <= n; j++) {
				if (x + i >= 0 && x + i < matrix.length) {
					boolean resultRowValid = i + n >= 0 && i + n < result.length;
					boolean resultColValid = j + n >= 0 && j + n < result[i + n].length;
					boolean matrixRowValid = x + i >= 0 && x + i < matrix.length;
					boolean matrixColValid = y + j >= 0 && y + j < matrix[x + i].length;
					if (resultRowValid && resultColValid && matrixRowValid && matrixColValid) {
						result[i + n][j + n] = matrix[x + i][y + j];
					}
				}
			}
		}
		return result;
	}
	public Integer[][] getSubMatrixWithList(int x, int y, int n) {
		if (matrix == null || matrix.length < 2)
			return null;
		if (matrix[0] == null || matrix[0].length < 2 || matrix.length != matrix[0].length) {
			return null;
		}
		int firstRowLength = matrix[0].length;
		for (Integer[] row : matrix) {
			if (row == null || row.length != firstRowLength)
				return null;
		}
		if (x >= matrix.length || y >= matrix.length) {
			return null;
		}
		List<Integer[]> list = new ArrayList<>();
		List<Integer> rowList = new ArrayList<>();
		for (int i = -n; i <= n; i++) {
			for (int j = -n; j <= n; j++) {
				if (x + i >= 0 && x + i < matrix.length) {
					boolean matrixRowValid = x + i >= 0 && x + i < matrix.length;
					boolean matrixColValid = y + j >= 0 && y + j < matrix[x + i].length;
					if (matrixRowValid && matrixColValid) {
						rowList.add(matrix[x + i][y + j]);
					}
				}
			}
			if (rowList.size() > 0) {
				list.add(rowList.toArray(new Integer[1]));
			}
			rowList.clear();
		}
		Integer[][] result = new Integer[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int matrixSize = 7;
		Integer[][] matrix = new Integer[matrixSize][];
		int num = 0;
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new Integer[matrixSize];
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = num;
				num++;
			}
		}
		for (Integer[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		SubMatrix sm = new SubMatrix(matrix);
		Integer[][] subMatrixWithList = sm.getSubMatrixWithList(4, 4, 10);
		System.out.println();
		for (Integer[] is : subMatrixWithList) {
			System.out.println(Arrays.toString(is));
		}
		Integer[][] subMatrix = sm.getSubMatrix(4, 4, 10);
		System.out.println();
		for (Integer[] is : subMatrix) {
			System.out.println(Arrays.toString(is));
		}
	}
}
