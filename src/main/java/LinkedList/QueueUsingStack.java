package LinkedList;

import java.util.Stack;

class Queue{
	static Stack<Integer> s1=new Stack<Integer>();
	static Stack<Integer> s2=new Stack<Integer>();
	static void enQueue(int x) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(x);
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		//s2.push(x);
	}
	static int deQueue() {
		if(s1.isEmpty()) {
			System.out.println("Q is Empty");
			System.out.println(0);
		}
		int x=s1.peek();
		s1.pop();
		return x;
	}
}
public class QueueUsingStack {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Queue q = new Queue();  
	    q.enQueue(1);  
	    q.enQueue(2);  
	    q.enQueue(3);  
	  
	    System.out.println(q.deQueue());  
	    System.out.println(q.deQueue()); 
	    System.out.println(q.deQueue()); 
	}
	

}
