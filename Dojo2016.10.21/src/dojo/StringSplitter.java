package dojo;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

	public static String splitString(String text, int rowLength) {
		String result = "";
		String[] splittedString = text.split(" ");
		List<String> rows = new ArrayList<>();
		String row = "";
		for (int i = 0; i < splittedString.length; i++) {
			while (splittedString[i] != "") {
				if (splittedString[i].length() + row.length() > rowLength) {
					rows.add(row);
					row = "";
				}
				if (splittedString[i].length() + row.length() <= rowLength) {
					row += splittedString[i] + " ";
					splittedString[i] = "";
				}
				if (splittedString[i].length() > rowLength) {
					rows.add(splittedString[i].substring(0, rowLength));
					splittedString[i] = splittedString[i].substring(rowLength);
				}
			}
		}
		rows.add(row);
		for (String string : rows) {
			result += string + System.lineSeparator();
		}
		return result;
	}

	public static void main(String[] args) {
		String sample = "A vér ugyan tartalmaz elég oxigént, de a sejtek nem képesek felhasználni, úgy nevezett cytotoxikus hypoxia alakul ki, a halál pár percen belül fulladás miatt áll be.";
		sample = splitString(sample, 10);
		System.out.println(sample);
	}
}
