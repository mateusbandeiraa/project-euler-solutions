package projectEuler;

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
					if(day == 1) {
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

		System.out.println(sundaysFirstCount + " out of " + sundaysCount + " Sundays are the first of the month." );
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
