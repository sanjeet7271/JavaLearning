package HashMapCollection;

import java.util.HashMap;
import java.util.Map;

class Test {
	String Name;
	String Address;
	int age;
	String Company;
	public Test(String Name,int age,String Address,String Company) {
		this.Name=Name;
		this.age=age;
		this.Address=Address;
		this.Company=Company;
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	@Override
	 public String toString() {
		 return "Test {"+" Name :"+Name+ " Age :"+age+ " Address :" +Address+" Company :" +Company+" }";
	 }
}
class HashMapUserDefine{
	public static void main(String[] args) {
	
		Map<Integer, Test> map=new HashMap<Integer, Test>();
		map.put(1001, new Test("sanjeet",24,"delhi","Nagarro"));
		map.put(1011, new Test("Rajan",25,"kolkata","Nagarro"));
		map.put(1002, new Test("Vishal",34,"patna","Nagarro"));
		map.put(1004, new Test("Raju",22,"bangalore","Nagarro"));
		
		System.out.println(map);
	}

}
