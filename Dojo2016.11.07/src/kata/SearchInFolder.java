package kata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchInFolder {

	String folderPath;

	public SearchInFolder(String folderPath) {
		this.folderPath = folderPath;
	}

	public String getfolderPath() {
		return folderPath;
	}

	public void generateFiles() {
		generateFile("abrahgfha.txt", 200);
		generateFile("abrasda.txt", 200);
		generateFile("abraca.txt", 200);
		generateFile("abracadabra.txt", 20);
		generateFile("abracadabr.txt", 20);
	}

	public void generateFile(String filename, int size) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
			for (int i = 0; i < size; i++) {
				writer.write('a');
			}
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Map<Long, Set<File>> searchInFolder() {
		Map<Long, Set<File>> result = new HashMap<>();
		Set<File> filesSameSize = new HashSet<>();
		File dir = new File(this.folderPath);
		File[] files = dir.listFiles();
		int counter = 0;
		while (counter < files.length) {
			if (files[counter].isDirectory()) {
				counter++;
				continue;
			}
			Long size = files[counter].length();
			for (int i = 0; i < files.length; i++) {
				if (size == files[i].length()) {
					filesSameSize.add(files[i]);
				}
			}
			if (!result.containsKey(size)) {
				result.put(size, filesSameSize);
				System.out.println("Put" + filesSameSize);
			}
			filesSameSize.clear();
			counter++;
		}
		return result;

	}

	public static void main(String[] args) {
		SearchInFolder sf = new SearchInFolder("C:\\JavaProjects\\dojo\\dojo2016.11.07");
		sf.generateFiles();
		Map<Long, Set<File>> result = sf.searchInFolder();
		for (Long name : result.keySet()) {
			System.out.println(name + " " + result.get(name));
		}
		System.out.println("Done!");
	}
}
