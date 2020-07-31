package czytytanie.plik;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerFileText {

	public static Logger log = Logger.getLogger(ScannerFileText.class.getName());

	public static void main(String args[]) throws FileNotFoundException {

		ClassLoader classLoader = ScannerFileText.class.getClassLoader();

		File text = new File(classLoader.getResource("zadanie.txt").getFile());
		Scanner scnr = null;

		try {
			scnr = new Scanner(text);

			SortedMap<String, PairCountPosition> sortedMap = new TreeMap<String, PairCountPosition>();

			int lineNumber = 1;
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();

				String[] words = line.split("\\s+");

				for (String word : words) {
					word = word.toLowerCase();
					if (sortedMap.containsKey(word)) {
						PairCountPosition pairCount = sortedMap.get(word);
						pairCount.incremateCount();
						pairCount.addPosition(lineNumber);
					} else {
						sortedMap.put(word, new PairCountPosition(lineNumber));
					}
				}
				lineNumber++;
			}

			for (String keyWord : sortedMap.keySet()) {
				System.out.println(keyWord + " - " + sortedMap.get(keyWord).getCount() + " - pozycje - "
						+ sortedMap.get(keyWord).getPositions());
			}
		} catch (Exception e) {
			log.log(Level.INFO, "Exception", e);
		} finally {
			scnr.close();
		}
	}
}