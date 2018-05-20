package projectEuler;

/*
 * https://projecteuler.net/problem=19
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * - 1 Jan 1900 was a Monday.
 * 
 * - Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * 
 * - A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * COMPLETED ON 19/05/18
 * 
 * I know there's probably a cleverer way to do this, but I did use this method
 * because not only it can do what is meant to in the problem, but can also
 * return the total sundaysCount in the 20th century.
 */
public class Euler_19 {
	public static void main(String[] args) {
		// This is the first Sunday of the twentieth century.
		int day = 6;
		int month = 1;
		int year = 1901;
		int sundaysCount = 0;
		int sundaysFirstCount = 0;

		while (year <= 2000) {
			while (month <= 12) {
				int monthDaysCount = monthDaysCount(month, year);

				while (day <= monthDaysCount) {
					if (day == 1) {
						sundaysFirstCount++;
					}
					sundaysCount++;
					day += 7;
				}
				day -= monthDaysCount;
				month++;
			}
			month = 1;
			year++;
		}

		System.out.println(sundaysFirstCount + " out of " + sundaysCount + " Sundays are the first of the month.");
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}

	public static int monthDaysCount(int month, int year) {
		int[] monthsDaysCountList = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int monthDays = monthsDaysCountList[month - 1];

		if (month == 2 && isLeapYear(year)) {
			monthDays++;
		}

		return monthDays;
	}
}
