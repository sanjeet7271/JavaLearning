
public class AddNumbers {
	public static void sumOfNumbers(String str) {
		String temp="";
		int sum=0;
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
		String str="qw12rdd12d1";
		sumOfNumbers(str);
	}

}
