package Interface;

interface Exam{
	void m();
}
interface Exam1{
	void m();
}
public class multipleInheritance2 implements Exam, Exam1{

	@Override
	public void m() {
		System.out.println("method m()");
		
	}
	public static void main(String[] args) {
		multipleInheritance2 m=new multipleInheritance2();
		m.m();
	}

}
