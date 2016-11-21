package dojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffle {
	public static String shuffle(String word) {
		String result = "";
		char[] chars = word.toCharArray();
		List<Character> charlist = new ArrayList<>();
		for (char c : chars) {
			charlist.add(c);
		}
		Collections.shuffle(charlist);
		for (Character c : charlist) {
			result += c;
		}
		return result;
	}

	public static String splitString(String text) {
		String result = "";
		String[] words = text.split(" ");
		for (String word : words) {
			if (word.length() > 3) {
				result += word.charAt(0) + shuffle(word.substring(1, word.length() - 1))
						+ word.charAt(word.length() - 1) + " ";
			} else {
				result += word + " ";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String sampleText = "A videó után kommentben jöhetnek a sztorik ki mit felejtett eddig az autó tetején";
		sampleText = splitString(sampleText);
		System.out.println(sampleText);
	}
}