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

