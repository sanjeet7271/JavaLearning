package AccessModifier;

class A3{
	public void display() {
		System.out.println("Display Functions in A");
	}
}

class B3 extends A3 {
	private void display() {
		System.out.println("Display Functions in B");
	}
}

public class methodOverridingWithAccessModifier2 {

	public static void main(String[] args) {
		A3 a=new A3();
		//a.display(); //getting error due to visibility of the object

	}

}
