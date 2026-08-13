# Method Overloading and Method Overriding

## 1. What is Method Overloading?

**Method overloading** means having multiple methods in the **same class** with the **same method name but different parameter lists**.

The difference can be in:

* Number of parameters
* Type of parameters
* Order of parameters

Example:

```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }
}
```

Here `add()` is overloaded.

---

# 2. Types of Method Overloading

## Different number of parameters

```java
public void print(String name) {
}

public void print(String name, int age) {
}
```

---

## Different parameter types

```java
public void print(int number) {
}

public void print(String text) {
}
```

---

## Different order of parameters

```java
public void print(int id, String name) {
}

public void print(String name, int id) {
}
```

These are valid overloads because the parameter order is different.

---

# 3. Can We Overload by Changing Only Return Type?

**No.**

This is invalid:

```java
public int add(int a, int b) {
    return a + b;
}

public double add(int a, int b) {
    return a + b;
}
```

The compiler cannot distinguish methods based only on return type.

### Interview answer

> Method overloading cannot be achieved by changing only the return type. The parameter list must be different.

---

# 4. Can We Overload a Static Method?

**Yes.**

```java
public class Test {

    static void print(int a) {
        System.out.println(a);
    }

    static void print(String a) {
        System.out.println(a);
    }
}
```

Both methods are overloaded.

---

# 5. Can We Overload a Final Method?

**Yes.**

`final` prevents overriding, not overloading.

```java
public final void display() {
}

public final void display(String name) {
}
```

These are valid overloaded methods.

---

# 6. Can We Overload a Private Method?

**Yes.**

```java
private void test() {
}

private void test(int x) {
}
```

These are overloaded methods.

---

# 7. Can Constructors Be Overloaded?

**Yes.**

Constructors are commonly overloaded.

```java
public class Employee {

    public Employee() {
    }

    public Employee(int id) {
    }

    public Employee(int id, String name) {
    }
}
```

This is called **constructor overloading**.

---

# 8. What is Method Overriding?

Method overriding occurs when a **child class provides its own implementation of a method inherited from the parent class**.

Example:

```java
class Animal {

    public void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

Now:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Dog barks
```

This is runtime polymorphism.

---

# 9. Why Do We Use `@Override`?

You should use:

```java
@Override
public void sound() {
}
```

because the compiler verifies that you are actually overriding a parent method.

For example, if you accidentally write:

```java
@Override
public void sounds() {
}
```

the compiler reports an error because `sounds()` doesn't override the parent's `sound()`.

---

# 10. Overloading vs Overriding

| Feature              | Overloading                          | Overriding            |
| -------------------- | ------------------------------------ | --------------------- |
| Class                | Usually same class                   | Parent-child classes  |
| Method name          | Same                                 | Same                  |
| Parameters           | Must be different                    | Must be same          |
| Return type          | Can differ, but not sufficient alone | Same or covariant     |
| Binding              | Compile time                         | Runtime               |
| Polymorphism         | Compile-time polymorphism            | Runtime polymorphism  |
| Inheritance required | No                                   | Yes                   |
| `static`             | Can overload                         | Cannot truly override |
| `final`              | Can overload                         | Cannot override       |
| `private`            | Can overload                         | Cannot override       |

---

# 11. Compile-Time Polymorphism

Method overloading is called **compile-time polymorphism**.

Example:

```java
class Calculator {

    void add(int a, int b) {
        System.out.println("int");
    }

    void add(double a, double b) {
        System.out.println("double");
    }
}
```

When you write:

```java
Calculator c = new Calculator();

c.add(10, 20);
```

the compiler determines which method to call.

---

# 12. Runtime Polymorphism

Method overriding is called **runtime polymorphism**.

Example:

```java
class Animal {

    void sound() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog");
    }
}
```

Then:

```java
Animal a = new Dog();

a.sound();
```

Output:

```text
Dog
```

The actual object determines which overridden method executes.

---

# 13. Very Important Interview Question

### What is the difference between reference type and object type?

Consider:

```java
Animal animal = new Dog();
```

Here:

```text
Reference type = Animal
Object type    = Dog
```

For overridden methods, Java uses the **actual object type** at runtime.

Therefore:

```java
animal.sound();
```

calls:

```text
Dog.sound()
```

---

# 14. Can We Override a Static Method?

This is a very common tricky question.

**No, static methods are not overridden.**

They are **hidden**.

Example:

```java
class Parent {

    static void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void display() {
        System.out.println("Child");
    }
}
```

Now:

```java
Parent obj = new Child();

obj.display();
```

Output:

```text
Parent
```

Because static method invocation is resolved based on the **reference type**, not runtime object.

---

# 15. Static Method Hiding

The correct terminology is:

> Static methods are hidden, not overridden.

Example:

```java
Parent.display();
Child.display();
```

Output:

```text
Parent
Child
```

---

# 16. Can We Override a Final Method?

**No.**

Example:

```java
class Parent {

    final void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    // Compilation error
    void display() {
        System.out.println("Child");
    }
}
```

A `final` method cannot be overridden.

---

# 17. Can We Override a Private Method?

**No.**

Private methods are not inherited by subclasses in the normal sense required for overriding.

Example:

```java
class Parent {

    private void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    private void display() {
        System.out.println("Child");
    }
}
```

The child's method is a separate method, not an override.

---

# 18. Can We Override a Constructor?

**No.**

Constructors are not inherited.

Therefore, they cannot be overridden.

But constructors **can be overloaded**.

```java
class Employee {

    Employee() {
    }

    Employee(int id) {
    }
}
```

---

# 19. Can We Override a Method with a More Restrictive Access Modifier?

No.

Suppose parent has:

```java
class Parent {

    public void display() {
    }
}
```

Child cannot do:

```java
class Child extends Parent {

    protected void display() {
    }
}
```

This causes a compilation error.

The child cannot reduce visibility.

---

# 20. Access Modifier Rules for Overriding

A child method can have the same or **broader** access.

Valid:

```text
private → not applicable for overriding

protected → protected
protected → public

default → default
default → protected
default → public

public → public
```

But you cannot reduce:

```text
public → protected
public → default
protected → default
```

---

# 21. Can an Overridden Method Throw More Exceptions?

This is another important interview question.

Suppose:

```java
class Parent {

    void test() throws IOException {
    }
}
```

The child cannot throw a broader checked exception:

```java
class Child extends Parent {

    @Override
    void test() throws Exception {
    }
}
```

This is invalid because `Exception` is broader than `IOException`.

---

# 22. What Exceptions Can the Child Throw?

The overriding method can:

* Throw the same checked exception
* Throw a subclass of the parent's checked exception
* Throw no checked exception
* Throw unchecked exceptions

Example:

```java
class Parent {

    void test() throws IOException {
    }
}

class Child extends Parent {

    @Override
    void test() throws FileNotFoundException {
    }
}
```

Valid because:

```text
FileNotFoundException
        ↓
IOException
```

---

# 23. Can Return Type Be Different During Overriding?

Normally, the return type must be the same or **covariant**.

Example:

```java
class Animal {
}

class Dog extends Animal {
}

class Parent {

    Animal getAnimal() {
        return new Animal();
    }
}

class Child extends Parent {

    @Override
    Dog getAnimal() {
        return new Dog();
    }
}
```

This is valid.

`Dog` is a subtype of `Animal`.

This is called a **covariant return type**.

---

# 24. Covariant Return Type

Remember:

```text
Parent:
Animal getAnimal()

Child:
Dog getAnimal()
```

Valid because:

```text
Dog IS-A Animal
```

But this is invalid:

```text
Parent:
Dog getAnimal()

Child:
Animal getAnimal()
```

because `Animal` is broader than `Dog`.

---

# 25. Overloading + Inheritance

Overloading can also happen between parent and child classes.

Example:

```java
class Parent {

    void display(int x) {
        System.out.println("Parent int");
    }
}

class Child extends Parent {

    void display(String x) {
        System.out.println("Child String");
    }
}
```

Now:

```java
Child obj = new Child();

obj.display(10);
obj.display("Java");
```

Both methods are available.

---

# 26. Overloading and Overriding Together

A class can have both.

```java
class Parent {

    void display(int x) {
        System.out.println("Parent int");
    }

    void test() {
        System.out.println("Parent test");
    }
}

class Child extends Parent {

    @Override
    void test() {
        System.out.println("Child test");
    }

    void display(String x) {
        System.out.println("Child String");
    }
}
```

Here:

```text
display(int)    → inherited
display(String) → overloaded
test()          → overridden
```

---

# 27. Tricky Question: What Happens Here?

```java
class Parent {

    void display(int x) {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    void display(double x) {
        System.out.println("Child");
    }
}
```

Then:

```java
Parent p = new Child();

p.display(10);
```

Which method runs?

### Answer:

```text
Parent.display(int)
```

Because `display(double)` is not an override; it's an overload.

---

# 28. Tricky Question: Method Resolution

Consider:

```java
class Parent {

    void display(Object obj) {
        System.out.println("Parent Object");
    }
}

class Child extends Parent {

    void display(String str) {
        System.out.println("Child String");
    }
}
```

Now:

```java
Child c = new Child();

c.display("Java");
```

Output:

```text
Child String
```

Because the compiler selects the most specific applicable overloaded method.

---

# 29. Important Overloading Rule

When overloaded methods are available, Java generally chooses based on:

```text
1. Exact match
2. Widening conversion
3. Boxing/unboxing
4. Varargs
```

For example:

```java
void test(int x) {
    System.out.println("int");
}

void test(long x) {
    System.out.println("long");
}
```

Calling:

```java
test(10);
```

selects:

```text
int
```

because it's an exact match.

---

# 30. Overloading with `null`

This is a popular interview question.

```java
void test(String s) {
    System.out.println("String");
}

void test(Object o) {
    System.out.println("Object");
}
```

Calling:

```java
test(null);
```

Output:

```text
String
```

Why?

Because `String` is more specific than `Object`.

---

# 31. Ambiguous `null`

Consider:

```java
void test(String s) {
}

void test(Integer i) {
}
```

Then:

```java
test(null);
```

This causes a compilation error.

Why?

Because both `String` and `Integer` are unrelated reference types, so Java cannot choose one as more specific.

---

# 32. Overloading with Autoboxing

Example:

```java
void test(int x) {
    System.out.println("int");
}

void test(Integer x) {
    System.out.println("Integer");
}
```

Calling:

```java
test(10);
```

selects:

```text
int
```

because primitive exact match is preferred over boxing.

---

# 33. Overloading with Varargs

Example:

```java
void test(int x) {
    System.out.println("int");
}

void test(int... x) {
    System.out.println("varargs");
}
```

Calling:

```java
test(10);
```

Output:

```text
int
```

Exact match is preferred over varargs.

---

# 34. Can Main Method Be Overloaded?

Yes.

You can write:

```java
public static void main(String[] args) {
    System.out.println("Main");
}

public static void main(int x) {
    System.out.println("Integer main");
}
```

But the JVM specifically looks for:

```java
public static void main(String[] args)
```

as the application entry point.

---

# 35. Can Main Method Be Overridden?

`main()` is static.

Therefore, it is not overridden; it can be **hidden**.

---

# 36. Important Interview Question

### What is early binding and late binding?

### Early binding

Usually associated with:

* Method overloading
* Static methods
* Private methods
* Final methods

The method is determined at compile time.

### Late/dynamic binding

Associated with:

* Method overriding

The method implementation is determined at runtime based on the actual object.

---

# 37. Simple Example of Dynamic Binding

```java
class Animal {

    void sound() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog");
    }
}

Animal animal = new Dog();

animal.sound();
```

Output:

```text
Dog
```

Because the actual object is `Dog`.

---

# 38. Why is Overriding Important in Automation?

Overriding is heavily used in automation frameworks.

For example:

```java
class BasePage {

    public void waitForPage() {
        System.out.println("Generic wait");
    }
}
```

Child page:

```java
class LoginPage extends BasePage {

    @Override
    public void waitForPage() {
        System.out.println("Login page specific wait");
    }
}
```

This allows framework components to provide specialized behavior while maintaining a common interface.

---

# 39. Real SDET Example

Suppose:

```java
class BaseTest {

    public void setup() {
        System.out.println("Common setup");
    }
}
```

A specific test can override:

```java
class APITest extends BaseTest {

    @Override
    public void setup() {
        System.out.println("API setup");
    }
}
```

Another:

```java
class UITest extends BaseTest {

    @Override
    public void setup() {
        System.out.println("UI setup");
    }
}
```

Now:

```java
BaseTest test = new UITest();

test.setup();
```

Output:

```text
UI setup
```

---

# 40. Overloading in Automation

Overloading is commonly used for utility methods.

For example:

```java
public void click(By locator) {
}

public void click(WebElement element) {
}

public void click(String locator) {
}
```

The caller can use whichever parameter type is convenient.

Another example:

```java
public void sendKeys(By locator, String value) {
}

public void sendKeys(WebElement element, String value) {
}
```

This is method overloading.

---

# 41. Top Interview Questions

### Q1. What is method overloading?

> Multiple methods with the same name but different parameter lists, generally resolved at compile time.

### Q2. What is method overriding?

> A child class provides a new implementation of an inherited parent method with the same signature, enabling runtime polymorphism.

### Q3. Can return type alone overload a method?

> No.

### Q4. Can static methods be overloaded?

> Yes.

### Q5. Can static methods be overridden?

> No. They are hidden.

### Q6. Can final methods be overridden?

> No.

### Q7. Can final methods be overloaded?

> Yes.

### Q8. Can private methods be overridden?

> No.

### Q9. Can private methods be overloaded?

> Yes.

### Q10. Can constructors be overloaded?

> Yes.

### Q11. Can constructors be overridden?

> No.

### Q12. Can an overriding method have a more restrictive access modifier?

> No.

### Q13. Can an overriding method throw a broader checked exception?

> No.

### Q14. Can an overriding method return a subtype?

> Yes, through covariant return types.

### Q15. What is compile-time polymorphism?

> Method overloading.

### Q16. What is runtime polymorphism?

> Method overriding.

### Q17. What is method hiding?

> When a child class defines a static method with the same signature as a parent's static method.

### Q18. What determines an overloaded method?

> The compile-time types of the arguments.

### Q19. What determines an overridden method?

> The actual runtime object.

### Q20. Can overloaded methods have different access modifiers?

> Yes.

---

# 42. Quick Revision

```text
OVERLOADING
------------
Same method name
Different parameters
Usually same class
Compile-time
No inheritance required
Return type alone → NOT enough
Can be static
Can be final
Can be private
Constructors can be overloaded


OVERRIDING
----------
Parent + Child
Same method signature
Runtime
Inheritance required
Supports runtime polymorphism
Static → cannot override
Final → cannot override
Private → cannot override
Constructor → cannot override
Return type → same/covariant
Access → same or broader
Checked exception → same/narrower
```

## One-line interview answer

> **Overloading is compile-time polymorphism where methods have the same name but different parameter lists, while overriding is runtime polymorphism where a child class provides a new implementation of an inherited parent method with the same signature.**
