package PrintfMenupulations;

/*
 * Left-justifying printf integer output
To left-justify integer output with printf, just add a minus sign (-) after the % symbol, like this
 * 
 * 
 */
public class Example4 {
	public static void main(String[] args) {
		
		System.out.printf("%03d\n", 0);
		System.out.printf("%03d\n", 1);
		System.out.printf("%03d\n", 121231313);
		System.out.printf("%03d\n", -10);
		System.out.printf("%03d",-131320);
		//System.out.printf("%03d", 0);
	}

}
