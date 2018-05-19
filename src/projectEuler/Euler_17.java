package projectEuler;

import java.util.ArrayList;
import java.util.List;

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out 
 * in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and 
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 
 * letters. The use of "and" when writing out numbers is in compliance with British usage.
 * 
 */
public class Euler_17 {
	public static final String[] ONE_TO_NINE = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };
	public static final String[] TEN_FOURTEEN = { "ten", "eleven", "twelve", "", "fourteen" };
	public static final String[] PREFIXES = { "", "", "twen", "thir", "for", "fif", "six", "seven", "eigh", "nine" };

	public static void main(String[] args) {
		String chain = "";
		for (int i = 1; i <= 1000; i++) {
			String number = nameNumber(i);
			System.out.println(number);
			chain += number.replaceAll("\\W", "");
		}
		System.out.println(chain.length());
	}

	public static String nameNumber(int number) {
		String output = String.valueOf(number);
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < output.length(); i++) {
			numbers.add(Character.getNumericValue(output.charAt(i)));
		}
		output = "";
		if (numbers.size() == 4) {
			output += "one thousand";
		}

		if (numbers.size() == 3) {
			output += ONE_TO_NINE[numbers.get(0)] + " hundred";
			if (numbers.get(1) != 0 || numbers.get(2) != 0) {
				output += " and ";
			} else {
				numbers.remove(0);
			}
			numbers.remove(0);
		}

		if (numbers.size() == 2) {
			if (numbers.get(0) == 1) {
				if (numbers.get(1) <= 2 || numbers.get(1) == 4) {
					output += TEN_FOURTEEN[numbers.get(1)];
				} else {
					output += PREFIXES[numbers.get(1)] + "teen ";
				}
				numbers.remove(0);
			} else if (numbers.get(0) != 0){
				output += PREFIXES[numbers.get(0)] + "ty";
			}
			numbers.remove(0);
		}

		if (numbers.size() == 1) {
			output += ONE_TO_NINE[numbers.get(0)];
		}

		return output;
	}
}
