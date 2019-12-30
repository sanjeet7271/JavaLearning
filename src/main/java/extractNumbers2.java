
public class extractNumbers2 {
	public static void main(String[] args) {
		String str="Hello-123crossraod-412,delhi110093";
		String str1=str.replaceAll("[^\\d]", " ");
		System.out.println(str1.trim());
		String str2=str1.replaceAll(" +", " ");
		System.out.println(str2);
		
	}

}
