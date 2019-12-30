package PrintfMenupulations;

/*
 * The %3d specifier is used with integers, and means a minimum width of three spaces, which, by default, will be right-justified:
 * 
 * 
 */
public class Example2 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.printf("%3d", i);
		}

		for (int i = 0; i < 5; i++) {
			System.out.printf("%3d\n", i);
			System.out.printf("%12d\n", i - 1);
		}

	}

}
