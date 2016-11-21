package rotatematrix;

import java.util.Arrays;

public class RotateMatrix {
	public static int[][] rotate(int[][] matrix, int rotateRating) {
		rotateRating %= 4;
		int[][] result = matrix;
		while (rotateRating != 0) {
			result = rotateOnce(result);
			rotateRating--;
		}
		return result;
	}

	public static int[][] rotateOnce(int[][] array) {
		int[][] result = new int[array[0].length][array.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][result[i].length - 1 - j] = array[j][i];
			}
		}
		return result;
	}

	public static int[][] generateMatrix(int n, int m) {
		int[][] intArray = new int[n][m];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				intArray[i][j] = count;
				count++;
			}
		}
		return intArray;
	}

	public static void main(String[] args) {
		int[][] intArray = generateMatrix(5, 5);
		System.out.println("Original Matrix");
		for (int[] is : intArray) {
			System.out.println(Arrays.toString(is));
		}
		int[][] tempintArray = intArray;
		System.out.println();
		System.out.println("Rotated Matrix: 90percent");
		intArray = RotateMatrix.rotate(intArray, 1);
		for (int[] is : intArray) {
			System.out.println(Arrays.toString(is));
		}
		intArray = tempintArray;
		System.out.println();
		System.out.println("Rotated Matrix: 180percent");
		intArray = RotateMatrix.rotate(intArray, 2);
		for (int[] is : intArray) {
			System.out.println(Arrays.toString(is));
		}
		intArray = tempintArray;
		System.out.println();
		System.out.println("Rotated Matrix: 270percent");
		intArray = RotateMatrix.rotate(intArray, 3);
		for (int[] is : intArray) {
			System.out.println(Arrays.toString(is));
		}
	}
}