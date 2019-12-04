package ArraySorting;

import java.util.Arrays;
import java.util.Comparator;

class Student{
	int rollno;
	String name,address;
	public Student(int rollno, String name, String address) {
		this.rollno=rollno;
		this.name=name;
		this.address=address;
	}
	public String toString() {
		return this.rollno+" "+this.name+" "+this.address;
	}
	
}
class sortbyroll implements Comparator<Student>{
	public int compare(Student a, Student b) {
		return a.rollno-b.rollno;
	}
}
public class sortingAccToDefineCreteria {
	public static void main(String[] args) {
		Student[] arr= {new Student(111,"aaa","london"),
						new Student(123,"bbb","Delhi"),
						new Student(121,"ccc","Bangalore")
		};
		System.out.println("unsorted");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		Arrays.sort(arr,new sortbyroll());
		System.out.println("\n Sorted by rollno :");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" ");
		}
	}

}
