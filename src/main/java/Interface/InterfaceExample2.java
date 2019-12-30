package Interface;

interface Example1{
	int a=10;
	void m1();
	void m2();
}
public class InterfaceExample2 implements Example1{

	@Override
	public void m1() {
		System.out.println("method m1()");
		
	}

	@Override
	public void m2() {
		System.out.println("method m2()");
		
	}
	public static void main(String[] args) {
		InterfaceExample2 itr=new InterfaceExample2();
		itr.m1();
		itr.m2();
		System.out.println("Vriable :"+itr.a);
	}
}
