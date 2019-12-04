package AccessModifier;

class A5{
	public void display() {
		System.out.println("Display Functions in A");
	}
}

class B5 extends A5 {
	protected void display() {
		System.out.println("Display Functions in B");
	}
}

public class methodOverridingWithAccessModifier5 {

	public static void main(String[] args) {
		A5 a=new A5();
		//a.display(); //getting error due to visibility of the object

	}

}
