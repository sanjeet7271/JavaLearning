package AccessModifier;
/**
 * 
 In this example, we have created two classes A and Simple. A class contains private data member and private method. We are accessing these private members from outside the class, so there is a compile-time error.
 *
 */
class A{
	private int i=10;
	private void display() {
		System.out.println("Hello Java");
	}
}
public class privateModifier1 {

	public static void main(String[] args) {
		A obj=new A();
		System.out.println(obj.i); //Compiler Error as private variable not visible outside the class
		obj.display();//Compiler Error as private method not visble outside the class
		

	}

}
