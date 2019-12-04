package Exceptions;

class CustomException extends Exception{
	public CustomException() {
		
	}
}

public class customExceptionExample2 {
	public static void main(String[] args) {
		try {
			throw new CustomException();
			
		}catch(CustomException ce) {
			System.out.println("exception caught");
			System.out.println(ce.getMessage());
		}
	}

}
