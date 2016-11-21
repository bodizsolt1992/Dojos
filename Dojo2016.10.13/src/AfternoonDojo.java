import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AfternoonDojo {
	public static int[] generateNumbers(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = (int) (Math.random() * 20);
		}
		return result;
	}

	public static Integer[][] splitArray(int[] intArray) {
		List<Integer[]> list = new ArrayList<>();
		List<Integer> prevIntegers = new ArrayList<>();
		for (Integer is : intArray) {
			if (!prevIntegers.contains(is))
				prevIntegers.add(is);
			else {
				Integer[] a = new Integer[prevIntegers.size()];
				for (int i = 0; i < a.length; i++) {
					a[i] = prevIntegers.get(i);
				}
				list.add(a);
				prevIntegers.clear();
				prevIntegers.add(is);
			}
		}
		Integer[] a = new Integer[prevIntegers.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = prevIntegers.get(i);
		}
		list.add(a);
		Integer[][] result = new Integer[list.size()][];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] n = generateNumbers(30);
		System.out.println(Arrays.toString(n));
		Integer[][] sample = splitArray(n);
		for (Integer[] is : sample) {
			System.out.println(Arrays.toString(is));
		}
	}
}
