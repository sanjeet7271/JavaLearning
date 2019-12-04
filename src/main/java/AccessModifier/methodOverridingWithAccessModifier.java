package AccessModifier;
/*
 * make class A method public and Class B method also public
 */
class A1{
	public void display() {
		System.out.println("Display Functions in A");
	}
}

class B extends A1 {
	public void display() {
		System.out.println("Display Functions in B");
	}
}

public class methodOverridingWithAccessModifier {

	public static void main(String[] args) {
		A1 a=new A1();
		a.display();

	}

}
