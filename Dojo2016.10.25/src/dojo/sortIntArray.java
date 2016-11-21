package dojo;

import java.util.Arrays;
import java.util.Random;

public class sortIntArray {

	public static int[] sortIntArray(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		for (int i = 0; i < max; i++) {

		}
		return null;
	}

	public static int[] sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int k = i - 1;
			while (k >= 0 && array[k] > key) {
				array[k + 1] = array[k];
				k--;
			}
			array[k + 1] = key;
		}
		Arrays.sort(array);
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[10];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		int[] temp = array;
		array = temp;
		long beforeTime = System.currentTimeMillis();
		array = sort(array);
		long afterTime = System.currentTimeMillis();
		System.out.println(Arrays.toString(array));
		System.out.println(afterTime - beforeTime);
	}

}
