package AccessModifier;

class AB {
	protected void fun() {
		System.out.println("Hello p");
	}
}

class BC extends AB {
	protected void fun() {
		System.out.println("Hello c");
	}
}

public class sinleInheritance {
	public static void main(String[] args) {
		AB obj = new BC();
		obj.fun();
	}
	
}
