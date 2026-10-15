### Pass by value and pass by reference

## 1. Pass by Value
Meaning: A copy of the variable's value is passed to the method. Changes inside the method do not affect the original variable.
Imagine you have ₹100. You give someone a photocopy of your bank balance. If they change the photocopy to ₹500, your actual balance remains ₹100.
### Java example

    public class Main {
        static void changeValue(int num) {
            num = 500;
        }
    
        public static void main(String[] args) {
            int a = 100;
    
            changeValue(a);
    
            System.out.println(a);
        }
    }

Output:

```
100
```

## 2. Pass by Reference

Meaning: In languages that support true pass by reference, a method can access the original variable itself. Changes to that variable can affect the caller's variable.

Imagine you give someone access to your actual bank account rather than a photocopy. If they change the balance, the original balance changes too.

A simple example in C++:

```
#include <iostream>
using namespace std;

void changeValue(int &num) {
    num = 500;
}

int main() {
    int a = 100;

    changeValue(a);

    cout << a;
    return 0;
}
```

Output:

```
500
```

Here, `int &num` is a reference to the original variable `a`. Therefore, changing `num` also changes `a`.

## 3. Important difference

| Feature                      | Pass by Value       | Pass by Reference                             |
| ---------------------------- | ------------------- | --------------------------------------------- |
| What is passed?              | A copy of the value | Access to the original variable               |
| Changes affect the original? | No                  | Yes, when the referenced variable is modified |
| Example                      | Java primitives     | C++ references                                |
| Risk of modifying original   | Lower               | Higher                                        |



In Java, Comparable and Comparator are used to sort objects. The main difference is where you define the sorting logic.

Think of a list of employees. You may want to sort them by salary, name, or age.

## 1. Comparable — Natural sorting

Comparable means the class itself defines how its objects should be sorted.

For example, suppose you have employees and you want to sort them by salary by default.

```
import java.util.*;

class Employee implements Comparable<Employee> {
    int salary;

    Employee(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        return this.salary - e.salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(50000));
        list.add(new Employee(30000));
        list.add(new Employee(40000));

        Collections.sort(list);

        for (Employee e : list) {
            System.out.println(e.salary);
        }
    }
}
```

Output:

```
30000
40000
50000
```

How does it work?

- `implements Comparable<Employee>` means Employee defines its natural sorting order.
- `compareTo()` contains the sorting logic.
- `Collections.sort(list)` uses that logic automatically.

Think of Comparable as the default sorting rule.

## 2. Comparator — Custom sorting

Comparator means you define a separate sorting rule without changing the original class's natural sorting logic.

Suppose you already have employees sorted by salary by default, but now you want to sort them by name or age.

```
import java.util.*;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("Rahul", 50000));
        list.add(new Employee("Amit", 30000));
        list.add(new Employee("Priya", 40000));

        list.sort(Comparator.comparing(e -> e.name));

        for (Employee e : list) {
            System.out.println(e.name + " " + e.salary);
        }
    }
}
```

Output:

```
Amit 30000
Priya 40000
Rahul 50000
```

How does it work?

- `Comparator.comparing(e -> e.name)` defines a separate sorting rule based on employee name.
- `list.sort()` applies that rule.
- You can create different comparators for name, salary, age, and more.

Think of Comparator as choosing a sorting rule whenever you need one.

## 3. Comparable vs Comparator

| Feature                     | Comparable                           | Comparator                                    |
| --------------------------- | ------------------------------------ | --------------------------------------------- |
| Purpose                     | Natural/default sorting              | Custom sorting                                |
| Package                     | `java.lang`                          | `java.util`                                   |
| Method                      | `compareTo()`                        | `compare()`                                   |
| Where is logic defined?     | Inside the class                     | Outside the class or in a separate comparator |
| Changes the original class? | Yes, the class implements Comparable | No                                            |
| Multiple sorting rules?     | Usually one natural order            | Multiple rules are possible                   |

## 4. Easy way to remember

Comparable = Default rule

The Employee class decides how employees should be sorted by default, such as by salary.

Comparator = Custom rule

You choose how to sort employees when needed, such as by name, salary, or age.

## 5. Important SDET interview points

- `compareTo()` belongs to the `Comparable` interface.
- `compare()` belongs to the `Comparator` interface.
- A negative result means the first item comes before the second; zero means they compare equally; a positive result means the first comes after the second.
- Prefer `Integer.compare(this.salary, e.salary)` over `this.salary - e.salary` to avoid integer overflow.
- In Java 8, `Comparator.comparing()`, `thenComparing()`, and `reversed()` make custom sorting easier.

For example, sort employees by salary in descending order:

```
list.sort(
    Comparator.comparingInt((Employee e) -> e.salary)
              .reversed()
);
```
