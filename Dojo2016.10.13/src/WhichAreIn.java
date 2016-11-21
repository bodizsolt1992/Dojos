import java.util.Arrays;

public class WhichAreIn {

	public static String[] inArray(String[] array1, String[] array2) {
		String resultString = "";
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array1.length; j++) {
				if (array2[i].contains(array1[j])) {
					if (!resultString.contains(array1[j])) {
						resultString += array1[j] + " ";
					}
				}
			}
		}
		if (resultString.endsWith(" ")) {
			resultString = resultString.substring(0, resultString.length() - 1);
			String[] result = resultString.split(" ");
			Arrays.sort(result);
			return result;
		}
		String[] result = new String[0];
		return result;
	}
}