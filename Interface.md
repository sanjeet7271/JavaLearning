### Interface theory
 - Pure abstraction  - Interfaces help in achieving pure abstraction in Java. Interfaces are purely abstract in Java. Interfaces can only have abstract methods.
 - All interfaces are abstract by default. So, it’s not mandatory to write an abstract keyword with an interface.
 - Multiple inheritance - Interface allows us to achieve multiple inheritance as well.
 - An interface always extends another interface.
 - An interface can extend more than one interface.
 - Variables in the interface are public, static, and final by default. Interface variables are also known as constants. Methods in the interface are public and abstract by default.
 - Class always implements an interface.
 - Interface does not have constructors.
 - Interface doesn’t extend classes.
 - If any new method is added to the interface, then all concrete classes that implement that interface must provide an implementation of the newly added method, because all methods in the interface are abstract by default.
 - Interface methods cannot have declared abstract methods, as a synchronized concrete class that implements the interface can make methods synchronized.


### Interface in Java:
 - Interfaces declare a contract of methods (implicitly public abstract) and constants (public static final).
 - Default methods: default methods provide a method body in the interface so you can add behavior without breaking existing implementations. Useful for evolving APIs.
 - Static methods: static methods inside interfaces are utility-like methods callable as InterfaceName.method(...). <br>
                                 Example:
                                      public interface Greeter {
                                         default String greet(String name) { return "Hi " + name; }
                                         static String info() { return "Greeter v1"; }
                                      }
                                 <br>
- Access Modifier Default: In an access modifier, we don't declare the default keyword. The default keyword is only used in an interface to provide an implementation. Default Keyword is also used in switch case, where no case matches, then we print a message to the user.

