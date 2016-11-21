package dojo;

import java.util.Arrays;

public class Suitcase {
	private final static char[] KEYS = new char[9];
	static {
		for (int i = 0; i < KEYS.length; i++) {
			KEYS[i] = (char) (i + '0');
		}
	}

	public static String[] crack(int num) {
		String[] result = new String[(int) Math.pow(KEYS.length, num)];
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i <= num; i++) {
			temp.append('0');
		}
		int count = 0;
		char[] array = new char[num];
		for (int i = 0; i < result.length; i++) {
			result[i] = temp.toString();
			array = result[i].toCharArray();

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(crack(2)));
	}

}
