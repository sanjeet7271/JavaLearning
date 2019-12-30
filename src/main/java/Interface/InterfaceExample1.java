package Interface;
/*
1.	Pure abstraction  - Interfaces helps in achieving pure abstraction in java. Interface are purely abstract in java. Interfaces can only have abstract methods.
2.	All Interface are abstract by default. So, it’s not mandatory to write abstract keyword with interface.
3.	Multiple inheritance - Interface allows us to achieve multiple inheritance as well.
4.	Interface always extends another interface. 
5.	Interface can extend more than one interface.

6.	variables in interface are public, static and final by default. Interface variables are also known as constants.
	methods in interface are public and abstract by default.

7.	Class always implements interface.
8.	Interface does not have constructors.
9.	Interface doesn’t extend classes.
10.	If any new method is added in Interface then all concrete classes which implements that interface must provide implementation of newly added method, because all methods in interface are abstract by default.
11.	Interface methods cannot have declare abstract methods as synchronized concrete class which implements interface can make methods synchronized.
 */
public interface InterfaceExample1 {
	int a=10; //means public static final int a=10
	public static final int i=10;
	void m1();// means public abstract m1()
}
