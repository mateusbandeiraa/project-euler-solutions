package projectEuler;

import java.math.BigInteger;

public class Euler_16 {
	public static void main(String[] args) {
		BigInteger power = new BigInteger("2").pow(1000);
		char[] chars = power.toString().toCharArray();
		
		int sum = 0;
		for(int i = 0; i< chars.length; i++) {
			sum += Character.getNumericValue(chars[i]);
		}
		
		System.out.println(sum);
	}
}
