package StringPrograms;

public class convertCharToString {
	public static void main(String[] args) {
		char ch='A';
		String str=Character.toString(ch);
		System.out.println(str);
		
		String str1=String.valueOf(ch);
		System.out.println(str1);
	}

}
