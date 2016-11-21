package dojo;

public class ArrayDojo {
	public static int[][] dojo(int[][] input) {
		int[][] result = new int[input[0].length][];
		for (int i = 0; i < result.length; i++) {
			result[i] = new int[input.length];
			for (int j = 0; j < input.length; j++) {
				result[i][j] = input[j][i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] sample = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		sample = dojo(sample);
		for (int[] row : sample) {
			System.out.println();
			for (int i : row) {
				System.out.print(i);
			}
		}
	}
}