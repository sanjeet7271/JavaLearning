package Interface;

interface Example2{
	void m1();
}
interface Example3{
	void n();
}
public class multipleInheritance implements Example2, Example3{

	@Override
	public void n() {
		System.out.println("method n()");
		
	}

	@Override
	public void m1() {
		System.out.println("method m()");
		
	}
	public static void main(String[] args) {
		multipleInheritance m=new multipleInheritance();
		m.n();
		m.m1();
	}

}
