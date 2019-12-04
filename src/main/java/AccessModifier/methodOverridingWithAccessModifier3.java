package AccessModifier;

class A2{
	private void display() {
		System.out.println("Display Functions in A");
	}
}

class B2 extends A2 {
	public void display() {
		System.out.println("Display Functions in B");
	}
}

public class methodOverridingWithAccessModifier3 {

	public static void main(String[] args) {
		A2 a=new A2();
		//a.display(); //getting error due to visibility of the object

	}

}
