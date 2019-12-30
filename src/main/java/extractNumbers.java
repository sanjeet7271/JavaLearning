
public class extractNumbers {
	public static void main(String[] args) {
		String str="Hello-123 cross raod-412, delhi 110093";
		String str1=str.replaceAll("[^\\d]", " ");
		System.out.println(str1.trim());
		String str2=str1.replaceAll(" +", " ");
		System.out.println(str2);
		
	}

}
