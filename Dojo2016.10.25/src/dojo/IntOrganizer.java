package dojo;

public class IntOrganizer {
	// input = {9,7,5,3,1,6,9,4};
	//
	// output = {1,4,3,6,5,7,9};
	public static int[] organize(int[] inputArray) {
		int[] distinct = removeDuplicates(inputArray);
		int[] sorted = sortAscendingly(distinct);
		int[] evenNumbers = getEvenNumbers(sorted);
		int[] oddNumbers = getOddNumbers(sorted);
		int[] result = merge(evenNumbers, oddNumbers);
		return result;
	}

	// public static int[] merge(int[] evenNumbers, int[] oddNumbers) {
	// int[] result = new int[evenNumbers.length + oddNumbers.length];
	//
	// int evenIndex = 0;
	// int oddIndex = 0;
	// for (int i = 0; i < result.length; i++) {
	// if (i % 2 != 0) {
	// result[i] = oddNumbers[oddIndex];
	// oddIndex++;
	// }
	// else {
	// result[i] = evenNumbers[evenIndex];
	// evenIndex++;
	// }
	// }
	// return result;
	// }
	public static int[] merge(int[] evenNumbers, int[] oddNumbers) {
		int[] result = new int[evenNumbers.length + oddNumbers.length];
		if (evenNumbers.length < oddNumbers.length) {
			for (int i = 0; i < evenNumbers.length; i++) {
				result[2 * i] = oddNumbers[i];
			}
			for (int i = 0; i < evenNumbers.length; i++) {
				result[2 * i + 1] = evenNumbers[i];
			}
			for (int i = evenNumbers.length; i < oddNumbers.length; i++) {
				result[evenNumbers.length + i] = oddNumbers[i];
			}
		} else {
			for (int i = 0; i < oddNumbers.length; i++) {
				result[2 * i] = oddNumbers[i];
			}
			for (int i = 0; i < oddNumbers.length; i++) {
				result[2 * i + 1] = evenNumbers[i];
			}
			for (int i = oddNumbers.length; i < evenNumbers.length; i++) {
				result[oddNumbers.length + i] = evenNumbers[i];
			}
		}
		return result;
	}

	public static int[] removeDuplicates(int[] inputArray) {
		int count = 0;
		int[] temp = new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			if (count(temp, inputArray[i]) == 0) {
				temp[count] = inputArray[i];
				count++;
			}
		}
		int[] result = new int[count];
		System.arraycopy(temp, 0, result, 0, result.length);
		return result;
	}

	public static int count(int[] inputArray, int number) {
		int count = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == number) {
				count++;
			}
		}
		return count;
	}

	public static int[] getEvenNumbers(int[] inputArray) {
		int[] result;
		int count = 0;
		for (int i : inputArray) {
			if (i % 2 == 0) {
				count++;
			}
		}
		result = new int[count];
		int numberIndex = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] % 2 == 0) {
				result[numberIndex] = inputArray[i];
				numberIndex++;
			}
		}
		return result;
	}

	public static int[] getOddNumbers(int[] inputArray) {
		int[] result;
		int count = 0;
		for (int i : inputArray) {
			if (i % 2 == 1) {
				count++;
			}
		}
		result = new int[count];
		int numberIndex = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] % 2 == 1) {
				result[numberIndex] = inputArray[i];
				numberIndex++;
			}
		}
		return result;
	}

	public static int[] sortAscendingly(int[] inputArray) {
		int[] result = new int[inputArray.length];
		int previousMin = 0;
		int max = max(inputArray);
		for (int i = 0; i < result.length; i++) {
			int min = max + 1;
			for (int j = 0; j < inputArray.length; j++) {
				if (inputArray[j] < min && ((i == 0) || inputArray[j] > previousMin)) {
					min = inputArray[j];
				}
			}
			result[i] = min;
			previousMin = min;
		}
		return result;
	}

	public static int min(int[] inputArray) {
		int result = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] < result) {
				result = inputArray[i];
			}
		}
		return result;
	}

	public static int max(int[] inputArray) {
		int result = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] > result) {
				result = inputArray[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = { 5, 9, 9, 9, 7, 5, 3, 1, 6, 9, 4 };
		int[] result = organize(input);
		// int[] evenNums = getEvenNumbers(input);
		// int[] oddNums = getOddNumbers(input);
		// int[] sorted = sortAscendingly(input);
		// int[] distinct = removeDuplicates(input);
		// System.out.println("Count:" + count(input, 8));
		// for (int i : result) {
		// System.out.print(i + " ");
		// }
		System.out.println();
		for (int i : result) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
}