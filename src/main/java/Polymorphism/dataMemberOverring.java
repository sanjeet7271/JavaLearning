package Polymorphism;

/*
 * In Java, we can override methods only, not the variables(data members), 
 * so runtime polymorphism cannot be achieved by data members. 
 */
class A{
	int a=10;
}
class B extends A{
	int b=20;
}
public class dataMemberOverring {
	public static void main(String[] args) {
		A a=new B();
		System.out.println("varaible overriding :"+a.a);
	}
	
}
