package dev.bandeira.projecteulersolutions.problem22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * https://projecteuler.net/problem=22
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * COMPLETED ON 20/05/18
 */
public class Problem22 {
	public static void main(String[] args) {
		String[] unsortedNames = getNames();
		ArrayList<String> sortedNames = new ArrayList<>(); // Is using an ArrayList considered cheating?
		int scoreSum = 0;

		sortedNames.add(unsortedNames[0]);
		for (int i = 1; i < unsortedNames.length; i++) { // At least I didn't use Collections.sort() :)
			String curName = unsortedNames[i];
			int curIndex = 0;
			while (curIndex < i && curName.compareTo(sortedNames.get(curIndex)) > 0) {
				curIndex++;
			}
			sortedNames.add(curIndex, unsortedNames[i]);
		}

		for (int i = 0; i < sortedNames.size(); i++) {
			scoreSum += score(sortedNames.get(i), i);
		}

		System.out.println(scoreSum);
	}

	public static String[] getNames() {
		String[] names = new String[0];
		try (BufferedReader br = new BufferedReader(new FileReader("res/Euler_22_names.txt"))) {
			String text = br.readLine();
			text = text.replace("\"", "");
			names = text.split(",");
		} catch (Exception ex) {
			names = new String[0];
		}
		return names;
	}

	public static int score(String name, int position) {
		char[] nameChars = name.toCharArray();
		int sum = 0;
		for (char c : nameChars) {
			sum += (int) c; // This line adds the ASCII decimal value of the char.
			sum -= Character.isUpperCase(c) ? 64 : 96;
			// Since the uppercase alphabet starts at position 65 and the
			// lowercase at 97 in the ASCII table, we need to subtract those
			// values to make 'A' = 'a' = 1, 'B' = 'b' = 2 ... 'Z' = 'z' = 26

		}
		return sum * (position + 1); // We need to add 1 to the position because ArrayList indexing starts at 0, but
										// the problem requires it to start at 1.
	}
}
