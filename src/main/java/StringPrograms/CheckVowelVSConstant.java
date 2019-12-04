package StringPrograms;

public class CheckVowelVSConstant {
	public static void main(String[] args) {
		boolean isVowel=false;
		char ch='D';
		switch(ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U': 
			isVowel=true;
		}
		if(isVowel==true) {
			System.out.println(ch+" is vowel");
		}else {
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')) {
				System.out.println(ch+" is consant");
			}else {
				System.out.println("Input is not alphabet");
			}
		}
	}

}
