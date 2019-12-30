package Polymorphism;

class Car{
	String carName;
	int carId;
	public Car(String carName,int carId) {
		this.carName=carName;
		this.carId=carId;
	}
}
class Driver extends Car{
	String dName;
	public Driver(String dname, String cName,int cid ) {
		super(cName,cid);
		this.dName=dname;
	}
	
}
public class association {

	public static void main(String[] args) {
		Driver c=new Driver("sanjeet", "Audi", 123);
		System.out.println(c.carName+ " " +c.dName+ " " +c.carId );
		

	}

}
