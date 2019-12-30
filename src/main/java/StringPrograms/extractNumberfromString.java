package StringPrograms;
/*
 * sum each and every number from String
 */
public class extractNumberfromString {
	public static void main(String[] args) {
		String str="1abc23";
		int sum=0,sum1=0;
		char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(Character.isDigit(ch[i])) {
				sum+=Character.getNumericValue(ch[i]);
				//will take ASCII value og 1,2 and 3 and add them
				sum1+=Integer.valueOf(ch[i]);
			}
		}
		System.out.println(sum);
		System.out.println(sum1);
	}

}
