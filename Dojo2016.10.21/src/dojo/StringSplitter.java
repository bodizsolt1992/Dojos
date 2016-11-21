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
		String sample = "A v�r ugyan tartalmaz el�g oxig�nt, de a sejtek nem k�pesek felhaszn�lni, �gy nevezett cytotoxikus hypoxia alakul ki, a hal�l p�r percen bel�l fullad�s miatt �ll be.";
		sample = splitString(sample, 10);
		System.out.println(sample);
	}
}
