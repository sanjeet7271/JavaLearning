package StringPrograms;

import java.util.Stack;

public class PalidromUsingStack {
	
	public static void main(String[] args) {
		String str="abcdba";
		Stack stack=new Stack();
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
		}
		String reverse="";
		while(!stack.isEmpty()) {
			reverse =reverse+stack.pop();
		}
		System.out.println(reverse);
		if(str.equals(reverse)) {
			System.out.println(str+" is palidrome string");
		}else {
			System.out.println(str+" is not palidrome string");
		}
	}

}
