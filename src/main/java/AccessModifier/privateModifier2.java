package AccessModifier;
/**
 * 
 * If you make any class constructor private, you cannot create the instance of that class from outside the class
 *
 */
class A{
	private A() {} //private constructor  
	private void display() {
		System.out.println("Hello");
	}
}
public class privateModifier2 {

	public static void main(String[] args) {

		A obj =new A();//Compile Time Error  

	}

}
