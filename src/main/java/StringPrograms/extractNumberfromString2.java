package StringPrograms;
/*
 * sum each and every number from String
 */
public class extractNumberfromString2 {
	public static void sumOfNumber(String str) {
		int sum=0;
		String temp="";
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(Character.isDigit(ch)) {
				temp+=ch;
			}else {
				sum+= Integer.parseInt(temp);
				temp="0";
			}
		}
		sum+=Integer.parseInt(temp);
		System.out.println(sum);
	}
	public static void main(String[] args) {
		String str="1abc23";
		sumOfNumber(str);
	}

}
