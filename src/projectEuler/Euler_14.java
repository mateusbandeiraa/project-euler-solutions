package projectEuler;

public class Euler_14 {
	
	
	public static void main(String[] args) {
		long recordHolder = 0;
		long recordChain = 0;
		for(long i = 2; i < 1000000; i++) {
			long number = i;
			long curChain = 0;
			//System.out.println("number: " + i);
			while(number != 1) {
				number = nextlong(number);
				//System.out.println("  ᴸ" + number);
				curChain++;
			}
			if(curChain > recordChain) {
				recordHolder = i;
				recordChain = curChain;
				//System.out.println("NEW RECORD: " + recordHolder + "→" + recordChain);
			}
		}
		
		System.out.println("RECORD: " + recordHolder + " → " + recordChain);
	}
	
	public static long nextlong(long number) {
		long output = -1;
		
		if(number != 1) {
			if (number % 2 == 0) {
				output = number / 2;
			} else {
				output = number * 3 + 1;
			}
		}
		
		return output;
	}
}
