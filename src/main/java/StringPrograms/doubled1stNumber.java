package StringPrograms;

class number1{
	public static void numberdouble(String str) {
		String[] split=str.split(" ");
		StringBuffer sb=new StringBuffer();
		String temp=split[0];
		//System.out.println(temp);
		//int n=String.valueOf(temp);
		int n=(Integer.parseInt(temp))*2;
		sb.append(n);
		for(int i=1;i<split.length;i++) {
			sb.append(" ");
			sb.append(split[i]);
			
			
		}
		System.out.println(sb);
		
	}
}
public class doubled1stNumber {
	public static void main(String[] args) {
		number1 obj=new number1();
		String str="8 123 1234 1322134 123124 1212 12312412";
		obj.numberdouble(str);
	}
}
