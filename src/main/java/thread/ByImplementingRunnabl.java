package thread; 

public class ByImplementingRunnabl implements Runnable{
	public void run() {
		System.out.println("by implementing Runnable interface");
		for(int i=0;i<10;i++) {
			System.out.println(i+" ");
		}
	}
	public static void main(String[] args) {
		ByImplementingRunnabl r=new ByImplementingRunnabl();
		Thread t= new Thread(r);
		t.start();	
	}
}
