package projectEuler;

import java.math.BigDecimal;

public class Euler_15 {
	public static void main(String[] args) {
		BigDecimal factorial40 = new BigDecimal(1);
		for(int i = 2; i <= 40; i++) {
			factorial40 = factorial40.multiply(new BigDecimal(i));
		}
		
		BigDecimal factorial20 = new BigDecimal(1);
		for(int i = 2; i <= 20; i++) {
			factorial20 = factorial20.multiply(new BigDecimal(i));
		}
		
		BigDecimal output = factorial40.divide(factorial20.multiply(factorial20));
		
		System.out.println(output.toString());
	}
}
