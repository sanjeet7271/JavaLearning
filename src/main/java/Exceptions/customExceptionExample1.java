package Exceptions;
class CustomException extends Exception{
	public CustomException(String s) {
		super(s);
	}
}
public class customExceptionExample1 {
	public static void main(String[] args) {
		try {
			throw new CustomException("Hello custom exception!!");
		}catch(CustomException ce) {
			System.out.println("exception caught");
			System.out.println(ce.getMessage());
		}
	}
}
