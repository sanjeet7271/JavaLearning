package PrintfMenupulations;

/*
 * Left-justifying printf integer output
To left-justify integer output with printf, just add a minus sign (-) after the % symbol, like this
 * 
 * 
 */
public class Example3 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.printf("%-3d", i);
		}

		for (int i = 0; i < 5; i++) {
			System.out.printf("%-3d\n", i);
		}

	}

}
