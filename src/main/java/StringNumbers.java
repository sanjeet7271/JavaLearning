
public class StringNumbers {
	public static void main(String[] args) {
		String str="asddsewqkl213123knmlasd2131121";
		StringBuffer sb=new StringBuffer();
		StringBuffer sb1=new StringBuffer();
		char ch[]=str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(Character.isDigit(ch[i])) {
				sb.append(ch[i]);
				System.out.print(ch[i]+" ");
			}else if(Character.isAlphabetic(ch[i])) {
				sb1.append(ch[i]);
			}
			
		}
		System.out.println(sb);
		System.out.println(sb1);
	}

}
