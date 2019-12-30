package Polymorphism;

class Address{
	int street;
	String city;
	String state;
	String country;
	public Address(int street,String city,String state,String country) {
		this.street=street;
		this.city=city;
		this.state=state;
		this.country=country;
	}
}
class Student{
	int roll;
	String name;
	Address address;
	public Student(int roll, String name,Address address) {
		this.roll=roll;
		this.name=name;
		this.address=address;
	}
	
}
public class Aggression {

	public static void main(String[] args) {
		Address addr=new Address(123, "Gurgaon", "haryana", "India");
		Student stu=new Student(12, "sanjeet", addr);
		System.out.println(stu.name);
		System.out.println(stu.address.city);

	}

}
