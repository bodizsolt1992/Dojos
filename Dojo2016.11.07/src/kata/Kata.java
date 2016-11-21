package kata;

import java.util.Arrays;

public class Kata {
	public static final char[] FIRSTARRAY = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
	public static final char[] SECONDARRAY = new char[] { 'h', 'i', 'j', 'k', 'l', 'm', 'n' };
	public static final String TEXT = "There certainly are times when it makes sense to use StringBuffer - in particular when you're creating a string in a loop, especially if you aren't sure that there will be few iterations in the loop. Note that it's not just a matter of creating new objects - it's a matter of copying all the text data you've appended already. Also bear in mind that object allocation is only essentially free if you don't consider garbage collection. Yes, if there's enough room in the current generation, it's basically a matter of incrementing a pointer... but: That memory must have been cleared at some point. That's not free. You're shortening the time until the next GC is required. GC isn't free. If your object lives into the next generation, it may take longer to be cleaned up - again, not free. All of these things are reasonably cheap in that it's 'usually' not worth bending a design away from elegance to avoid creating objects... but you shouldn't regard them as free. On the other hand, there is no point in using StringBuffer in cases where you won't need the intermediate strings. For example:";

	public static String shuffleIndexes(String text) {
		char[] textArray = text.toCharArray();
		String result = "";
		for (int i = 0; i < textArray.length; i++) {
			int index = Arrays.binarySearch(FIRSTARRAY, Character.toLowerCase(textArray[i]));
			result = index >= 0 ? result + SECONDARRAY[index] : result + textArray[i];
		}
		return result;
	}

	public static String shuffleIndexesStringBuilder(String text) {
		char[] textArray = text.toCharArray();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < textArray.length; i++) {
			int index = Arrays.binarySearch(FIRSTARRAY, Character.toLowerCase(textArray[i]));
			if (index >= 0) {
				result.append(SECONDARRAY[index]);
			} else {
				result.append(textArray[i]);
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(TEXT.length());
		long before = System.currentTimeMillis();
		System.out.println(shuffleIndexes(TEXT));
		long after = System.currentTimeMillis();
		System.out.println(after - before);
		before = System.currentTimeMillis();
		System.out.println(shuffleIndexesStringBuilder(TEXT));
		after = System.currentTimeMillis();
		System.out.println(after - before);
	}

}