package thread;

public class ByExtendingThreadClass extends Thread{
	public void run() {
		System.out.println("thread running by extending thread class");
	}
	public static void main(String[] args) {
		//Thread t=new Thread();
		ByExtendingThreadClass t=new ByExtendingThreadClass();
		t.start();
		
	}

}
