package dojo;

import java.util.Arrays;

public class TriangleArray {
	public static final String TEXT = "Hello";

	public static char[][] toTriangleArray(String text) {
		char[][] result = new char[text.length() * 2 - 1][];
		for (int i = 0; i < result.length; i++) {
			result[i] = (i <= text.length() - 1) ? new char[i + 1] : new char[(result.length) - i];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = text.charAt(text.length() - j - 1);
			}
		}
		Arrays.sort(result[0]);
		return result;
	}

	public static void main(String[] args) {
		char[][] caTriangle = toTriangleArray(TEXT);
		for (char[] cs : caTriangle) {
			System.out.println(Arrays.toString(cs));
		}
		/*
		 * [o] [o, l] [o, l, l] [o, l, l, e] [o, l, l, e, H] [o, l, l, e] [o, l,
		 * l] [o l] [o]
		 */
	}
}