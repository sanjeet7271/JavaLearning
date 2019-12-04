package AccessModifier;

class A4{
	protected void display() {
		System.out.println("Display Functions in A");
	}
}

class B4 extends A4 {
	public void display() {
		System.out.println("Display Functions in B");
	}
}

public class methodOverridingWithAccessModifier4 {

	public static void main(String[] args) {
		A4 a=new A4();
		//a.display(); //getting error due to visibility of the object

	}

}
