package amoba;

import java.util.Arrays;
import java.util.Random;

public class Amoba {
	private char[][] field;

	public Amoba() {
		field = new char[10][10];
		fillField();
	}

	public Amoba(char[][] field) {
		this.field = field;

	}

	public char[][] getField() {
		return field;
	}

	public static final int[][] DIRECTIONS = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 } };

	public boolean isItOver() {
		return scanField();
	}

	public void fillField() {
		Random rn = new Random();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = rn.nextInt(10) % 3 == 0 ? 'X' : 'O';
			}
		}
	}

	public boolean scanField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (i == 0 && j == 0)
					continue;
				if (count(i, j, field[i][j]) >= 5) {
					return true;
				}
			}
		}
		return false;
	}

	public int count(int x, int y, char c) {
		int count = 0;
		for (int[] is : DIRECTIONS) {
			while (count < 5) {
				int di = (is[0] * count) + x;
				int dj = (is[1] * count) + y;
				if (di >= 0 && di < field.length && dj >= 0 && dj < field[di].length && field[di][dj] == c) {
					count++;
				} else {
					break;
				}
			}
			if (count >= 5) {
				return count;
			}
			count = 0;
		}
		return count;
	}

	public static void main(String[] args) {
		Amoba amoba = new Amoba();
		for (int i = 0; i < amoba.field.length; i++) {
			System.out.println(Arrays.toString(amoba.field[i]));
		}
		System.out.println(amoba.isItOver());
	}

}
