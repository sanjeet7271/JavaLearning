# HashSet, LinkedHashSet & TreeSet — Complete Interview Notes

## 1. What is Set?

`Set` is an interface in Java's Collections Framework.

The main characteristic of a `Set` is:

> **A Set does not allow duplicate elements.**

Example:

```java
Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);
numbers.add(30);

System.out.println(numbers);
```

The output contains `10` only once.

Conceptually:

```text
Input:
10, 20, 10, 30

Set:
10, 20, 30
```

The commonly used implementations are:

```text
Set
 |
 ├── HashSet
 |
 ├── LinkedHashSet
 |
 └── SortedSet
       |
       └── NavigableSet
             |
             └── TreeSet
```

---

# 2. HashSet

## What is HashSet?

`HashSet` is a Set implementation that:

* Does not allow duplicates
* Does not guarantee insertion order
* Allows one `null` element
* Uses hashing internally
* Provides average `O(1)` performance for `add()`, `remove()`, and `contains()`
* The initial default capacity of HashSet is 16, and the load factor is 0.75

Example:

```java
Set<String> names = new HashSet<>();

names.add("John");
names.add("Mike");
names.add("Alex");
names.add("John");

System.out.println(names);
```

`John` appears only once.

---

# 3. HashSet Example

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(30);
set.add(10);

System.out.println(set);
```

Result conceptually:

```text
[20, 10, 30]
```

The exact order should **not** be relied upon.

You might see a different order depending on Java version, values, and internal table state.

---

# 4. Does HashSet Maintain Insertion Order?

**No.**

For example:

```java
HashSet<Integer> set = new HashSet<>();

set.add(50);
set.add(10);
set.add(30);
set.add(20);

System.out.println(set);
```

You should not assume:

```text
50, 10, 30, 20
```

will be printed in that order.

### Interview answer

> HashSet does not guarantee insertion order because it is hash-based.

---

# 5. Does HashSet Allow Null?

Yes.

A HashSet can contain **one `null` element**.

```java
Set<String> set = new HashSet<>();

set.add(null);
set.add("Java");
set.add(null);

System.out.println(set);
```

Only one `null` is retained.

---

# 6. How Does HashSet Prevent Duplicates?

This is one of the **most important interview questions**.

HashSet internally relies on:

```text
hashCode()
   +
equals()
```

When you add an object:

```java
set.add(object);
```

Java calculates the object's hash code.

Conceptually:

```text
Object
  ↓
hashCode()
  ↓
Bucket
  ↓
equals()
  ↓
Duplicate or New Object?
```

If an equivalent object already exists, the new object isn't added.

---

# 7. hashCode() and equals()

Consider:

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

Although:

```java
s1 != s2
```

they are logically equal:

```java
s1.equals(s2) == true
```

Their hash codes are also equal.

Therefore:

```java
Set<String> set = new HashSet<>();

set.add(s1);
set.add(s2);
```

The Set contains only one `"Java"`.

---

# 8. Why are hashCode() and equals() Important?

For HashSet:

```text
hashCode()
    ↓
Find bucket
    ↓
equals()
    ↓
Check equality
```

### Important contract

If:

```java
a.equals(b)
```

is `true`, then:

```java
a.hashCode() == b.hashCode()
```

must also be true.

But the reverse isn't necessarily true.

Two objects can have the same hash code but still not be equal.

---

# 9. Hash Collision

A collision occurs when different objects produce the same hash bucket/hash code.

Conceptually:

```text
Object A → Bucket 5
Object B → Bucket 5
```

Java then uses equality checks to determine whether they're duplicates.

Modern Java implementations can use a tree structure for heavily populated buckets, improving worst-case behavior.

---

# 10. HashSet Internal Structure

A simplified view:

```text
HashSet
   |
   └── HashMap
         |
         ├── Bucket 0
         ├── Bucket 1
         ├── Bucket 2
         ├── Bucket 3
         └── ...
```

An important interview fact:

> **HashSet is internally backed by a HashMap.**

When you do:

```java
set.add("Java");
```

HashSet internally stores the element as a key in a backing HashMap.

Conceptually:

```text
HashSet element
      ↓
HashMap key
      ↓
Dummy/PRESENT value
```

---

# 11. LinkedHashSet

`LinkedHashSet` is a subclass of `HashSet`.

It provides:

* No duplicates
* Insertion-order preservation
* Hash-based lookup
* One `null` element
* Average `O(1)` for add/remove/contains

Example:

```java
Set<String> set = new LinkedHashSet<>();

set.add("John");
set.add("Mike");
set.add("Alex");
set.add("John");

System.out.println(set);
```

Output:

```text
[John, Mike, Alex]
```

The insertion order is maintained.

---

# 12. Why Use LinkedHashSet?

Suppose you have:

```java
String[] names = {
    "John",
    "Mike",
    "John",
    "Alex",
    "Mike"
};
```

You want:

```text
John
Mike
Alex
```

while preserving the original order.

Use:

```java
Set<String> uniqueNames =
        new LinkedHashSet<>(Arrays.asList(names));
```

This is a very common interview coding problem.

---

# 13. How LinkedHashSet Maintains Order

Conceptually, LinkedHashSet uses:

```text
Hashing
+
Linked ordering
```

It maintains links between entries so iteration follows insertion order.

Conceptually:

```text
John → Mike → Alex
```

while also maintaining hash-based lookup.

---

# 14. Does LinkedHashSet Allow Null?

Yes.

Only one `null` is allowed.

```java
LinkedHashSet<String> set = new LinkedHashSet<>();

set.add(null);
set.add("Java");
set.add(null);
```

Result:

```text
[null, Java]
```

---

# 15. TreeSet

`TreeSet` is a sorted Set implementation.

It:

* Does not allow duplicates
* Maintains sorted order
* Does not guarantee insertion order
* Uses a tree-based structure
* Provides `O(log n)` operations
* Normally does not allow `null` with natural ordering

Example:

```java
TreeSet<Integer> set = new TreeSet<>();

set.add(50);
set.add(10);
set.add(30);
set.add(20);

System.out.println(set);
```

Output:

```text
[10, 20, 30, 50]
```

---

# 16. How TreeSet Sorts Elements

By default, TreeSet uses **natural ordering**.

For numbers:

```text
10 < 20 < 30 < 50
```

For Strings:

```java
TreeSet<String> set = new TreeSet<>();

set.add("Mike");
set.add("Alex");
set.add("John");

System.out.println(set);
```

Conceptually:

```text
Alex
John
Mike
```

---

# 17. TreeSet Internal Structure

TreeSet is backed by a `TreeMap`.

Conceptually:

```text
TreeSet
   |
   └── TreeMap
         |
         └── Red-Black Tree
```

A Red-Black Tree is a **self-balancing binary search tree**.

This helps TreeSet maintain:

```text
O(log n)
```

for major operations.

---

# 18. TreeSet Performance

| Operation  |      HashSet |   LinkedHashSet |      TreeSet |
| ---------- | -----------: | --------------: | -----------: |
| add()      | O(1) average |    O(1) average |     O(log n) |
| remove()   | O(1) average |    O(1) average |     O(log n) |
| contains() | O(1) average |    O(1) average |     O(log n) |
| Iteration  |         O(n) |            O(n) |         O(n) |
| Ordering   | No guarantee | Insertion order | Sorted order |

The `O(1)` values for hash-based sets are **average/expected**, not an absolute guarantee.

---

# 19. HashSet vs LinkedHashSet vs TreeSet

| Feature                 | HashSet             | LinkedHashSet                     | TreeSet                                 |
| ----------------------- | ------------------- | --------------------------------- | --------------------------------------- |
| Duplicate elements      | No                  | No                                | No                                      |
| Ordering                | No guaranteed order | Insertion order                   | Sorted order                            |
| Null                    | One null            | One null                          | Generally no null with natural ordering |
| Internal implementation | HashMap             | HashMap + linked ordering         | TreeMap                                 |
| Data structure          | Hash table          | Hash table + linked structure     | Red-Black Tree                          |
| Average add             | O(1)                | O(1)                              | O(log n)                                |
| Average search          | O(1)                | O(1)                              | O(log n)                                |
| Sorting                 | No                  | No                                | Yes                                     |
| Best use                | Fast unique lookup  | Unique + preserve insertion order | Unique + sorted data                    |

---

# 20. Most Important Difference

Remember this:

```text
HashSet
   ↓
Unique
   ↓
No ordering guarantee


LinkedHashSet
   ↓
Unique
   ↓
Insertion order


TreeSet
   ↓
Unique
   ↓
Sorted order
```

---

# 21. HashSet Example with Objects

Consider:

```java
class Employee {

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

Now:

```java
Set<Employee> employees = new HashSet<>();

employees.add(new Employee(1, "John"));
employees.add(new Employee(1, "John"));

System.out.println(employees.size());
```

You might expect:

```text
1
```

but without overriding `equals()` and `hashCode()`, the result will typically be:

```text
2
```

Why?

Because `Object`'s default equality is based on object identity.

---

# 22. Correct equals() and hashCode()

```java
class Employee {

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Employee))
            return false;

        Employee emp = (Employee) obj;

        return id == emp.id &&
               Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
```

Now:

```java
Set<Employee> employees = new HashSet<>();

employees.add(new Employee(1, "John"));
employees.add(new Employee(1, "John"));

System.out.println(employees.size());
```

Output:

```text
1
```

---

# 23. Very Important Interview Question

### Q: What happens if you override equals() but not hashCode()?

Answer:

> It can break the contract required by hash-based collections. Two logically equal objects may end up in different hash buckets, allowing duplicates to exist in a HashSet.

### Rule:

If you override:

```java
equals()
```

you should also override:

```java
hashCode()
```

---

# 24. Can HashSet Store Different Objects with Same HashCode?

Yes.

This is called a **hash collision**.

Example conceptually:

```text
Object A → hashCode = 100
Object B → hashCode = 100
```

If:

```java
A.equals(B)
```

is false, both objects can exist in the HashSet.

Therefore:

> Same hash code does NOT mean objects are equal.

---

# 25. What Happens if hashCode() Always Returns Same Value?

For example:

```java
@Override
public int hashCode() {
    return 1;
}
```

The Set can still work correctly if `equals()` is implemented correctly.

However, performance can degrade significantly because many objects end up in the same bucket.

### Interview answer

> Correctness can still be maintained through equals(), but poor hash distribution can cause performance degradation.

---

# 26. Can HashSet Contain Mutable Objects?

Yes, but it is dangerous.

Example:

```java
Set<Employee> employees = new HashSet<>();

Employee emp = new Employee(1, "John");

employees.add(emp);

// Modify a field used in hashCode()
emp.setId(100);
```

Now the object's hash code may change after it has been inserted.

This can cause:

```java
employees.contains(emp)
```

to return `false` unexpectedly.

### Best practice

Don't modify fields used in `equals()`/`hashCode()` while the object is being used as a HashSet element.

---

# 27. TreeSet and Comparable

TreeSet needs a way to determine ordering.

You can use `Comparable`.

Example:

```java
class Employee implements Comparable<Employee> {

    private int id;
    private String name;

    @Override
    public int compareTo(Employee emp) {

        return this.id - emp.id;
    }
}
```

Then:

```java
TreeSet<Employee> employees = new TreeSet<>();

employees.add(new Employee(3, "Mike"));
employees.add(new Employee(1, "John"));
employees.add(new Employee(2, "Alex"));
```

Output will be sorted by ID.

---

# 28. TreeSet with Comparator

You can also provide a Comparator.

```java
TreeSet<Employee> employees =
        new TreeSet<>(
            Comparator.comparing(Employee::getName)
        );
```

Now employees are sorted by name.

---

# 29. Important TreeSet Interview Question

### Q: Does TreeSet use equals() to identify duplicates?

This is a **tricky question**.

TreeSet primarily uses:

```text
compareTo()
```

or:

```text
Comparator.compare()
```

to determine ordering and whether two elements are considered equivalent.

If:

```java
compareTo() == 0
```

TreeSet treats the elements as duplicates for set purposes.

Therefore:

> For TreeSet, ordering comparison consistency with equals is very important.

---

# 30. TreeSet Example

```java
TreeSet<Integer> numbers = new TreeSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);
numbers.add(5);

System.out.println(numbers);
```

Output:

```text
[5, 10, 20]
```

---

# 31. TreeSet Special Methods

TreeSet provides useful navigation methods because it implements `NavigableSet`.

Example:

```java
TreeSet<Integer> numbers = new TreeSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);
numbers.add(50);
```

### `first()`

```java
numbers.first();
```

Result:

```text
10
```

### `last()`

```java
numbers.last();
```

Result:

```text
50
```

### `higher()`

```java
numbers.higher(30);
```

Result:

```text
40
```

### `lower()`

```java
numbers.lower(30);
```

Result:

```text
20
```

### `ceiling()`

```java
numbers.ceiling(35);
```

Result:

```text
40
```

### `floor()`

```java
numbers.floor(35);
```

Result:

```text
30
```

---

# 32. TreeSet Interview Question: Higher vs Ceiling

Given:

```java
TreeSet<Integer> set =
        new TreeSet<>(Arrays.asList(10, 20, 30, 40));
```

### `higher(20)`

Returns:

```text
30
```

It means:

> Strictly greater than the given value.

### `ceiling(20)`

Returns:

```text
20
```

It means:

> Greater than or equal to the given value.

Similarly:

```text
lower(20)   → 10
floor(20)   → 20
```

---

# 33. TreeSet `pollFirst()` and `pollLast()`

```java
set.pollFirst();
```

Returns and removes the smallest element.

```java
set.pollLast();
```

Returns and removes the largest element.

Useful when implementing priority-like behavior with sorted sets.

---

# 34. Descending Order in TreeSet

```java
TreeSet<Integer> set =
        new TreeSet<>(Comparator.reverseOrder());
```

Then:

```java
set.add(10);
set.add(30);
set.add(20);
```

Output:

```text
[30, 20, 10]
```

---

# 35. Remove Duplicates from an Array

### Using HashSet

```java
int[] arr = {10, 20, 10, 30, 20};

Set<Integer> set = new HashSet<>();

for (int num : arr) {
    set.add(num);
}

System.out.println(set);
```

Order is not guaranteed.

---

# 36. Remove Duplicates While Preserving Order

Use `LinkedHashSet`:

```java
int[] arr = {10, 20, 10, 30, 20};

Set<Integer> set = new LinkedHashSet<>();

for (int num : arr) {
    set.add(num);
}

System.out.println(set);
```

Output:

```text
[10, 20, 30]
```

---

# 37. Remove Duplicates and Sort

Use `TreeSet`:

```java
int[] arr = {30, 10, 20, 10, 30};

Set<Integer> set = new TreeSet<>();

for (int num : arr) {
    set.add(num);
}

System.out.println(set);
```

Output:

```text
[10, 20, 30]
```

---

# 38. Finding Duplicate Elements

You can use two sets:

```java
int[] arr = {10, 20, 30, 20, 40, 10};

Set<Integer> unique = new HashSet<>();
Set<Integer> duplicate = new HashSet<>();

for (int num : arr) {

    if (!unique.add(num)) {
        duplicate.add(num);
    }
}

System.out.println(duplicate);
```

Output:

```text
[10, 20]
```

Important trick:

```java
unique.add(num)
```

returns:

* `true` → element was added
* `false` → element already existed

---

# 39. Common Interview Questions

## Q1. Difference between HashSet and LinkedHashSet?

**Answer:**

> HashSet does not guarantee iteration order, while LinkedHashSet maintains insertion order. Both generally provide O(1) average-time basic operations and allow one null element.

---

## Q2. Difference between LinkedHashSet and TreeSet?

**Answer:**

> LinkedHashSet maintains insertion order and generally provides O(1) average lookup, while TreeSet maintains sorted order and provides O(log n) operations.

---

## Q3. Which is faster: HashSet or TreeSet?

Usually:

```text
HashSet → O(1) average
TreeSet → O(log n)
```

Therefore HashSet is generally faster for basic lookup/add/remove when sorting is not required.

---

## Q4. Which Set should you use if insertion order matters?

```text
LinkedHashSet
```

---

## Q5. Which Set should you use if sorted order matters?

```text
TreeSet
```

---

## Q6. Which Set provides fastest average lookup?

```text
HashSet
```

assuming good hash distribution.

---

## Q7. Which Set uses hashing?

```text
HashSet
LinkedHashSet
```

---

## Q8. Which Set uses a tree?

```text
TreeSet
```

Specifically, it is backed by a `TreeMap`, which uses a Red-Black Tree.

---

## Q9. Which Set preserves insertion order?

```text
LinkedHashSet
```

---

## Q10. Which Set maintains sorted order?

```text
TreeSet
```

---

## Q11. Can HashSet contain null?

Yes, one `null`.

---

## Q12. Can LinkedHashSet contain null?

Yes, one `null`.

---

## Q13. Can TreeSet contain null?

With natural ordering, `null` is generally not permitted because it cannot be compared with non-null elements.

Example:

```java
TreeSet<Integer> set = new TreeSet<>();

set.add(null);
```

This results in `NullPointerException` in standard modern Java behavior.

---

# 40. Tricky Question: Can TreeSet Have Duplicates?

No.

But TreeSet determines duplicates based on comparison.

For example:

```java
TreeSet<Integer> set = new TreeSet<>();

set.add(10);
set.add(10);
```

Only one `10`.

For custom objects:

```java
compareTo() == 0
```

can cause TreeSet to treat two objects as duplicates.

---

# 41. Tricky Question: HashSet vs TreeSet with Custom Objects

### HashSet

Uses:

```text
hashCode()
+
equals()
```

### TreeSet

Uses:

```text
compareTo()
OR
Comparator.compare()
```

This is one of the most important differences to remember.

---

# 42. What if compareTo() and equals() are inconsistent?

Example:

```java
compareTo() == 0
```

but:

```java
equals() == false
```

TreeSet may treat the objects as duplicates.

This can result in surprising behavior.

### Best practice

The natural ordering should ideally be consistent with `equals()`.

---

# 43. HashSet vs ArrayList

| Feature    | HashSet         | ArrayList                  |
| ---------- | --------------- | -------------------------- |
| Duplicates | Not allowed     | Allowed                    |
| Index      | No              | Yes                        |
| Ordering   | No guarantee    | Insertion order            |
| Lookup     | O(1) average    | O(n)                       |
| Null       | One null        | Multiple nulls             |
| Best use   | Unique elements | Ordered/indexed collection |

---

# 44. Set vs List

### List

```java
List<String> list = new ArrayList<>();
```

Allows:

```text
A
A
B
C
```

### Set

```java
Set<String> set = new HashSet<>();
```

Stores:

```text
A
B
C
```

---

# 45. Real SDET Automation Use Cases

### Use HashSet when:

You need fast membership checking.

Example:

```java
Set<String> expectedFields = new HashSet<>();
```

Then:

```java
expectedFields.contains("username");
```

Useful for:

* API response validation
* Duplicate detection
* Comparing unique values
* Validating database results

---

### Use LinkedHashSet when:

You need:

> Unique values + original order.

Example:

```java
Set<String> actualHeaders =
        new LinkedHashSet<>();
```

Useful for:

* API response fields
* UI menu values
* Test data
* Removing duplicates while preserving sequence

---

### Use TreeSet when:

You need:

> Unique values + sorted order.

Example:

```java
Set<Integer> responseCodes =
        new TreeSet<>();
```

Useful for:

* Sorting API response values
* Comparing ordered data
* Finding minimum/maximum
* Range queries
* `higher()`, `lower()`, `floor()`, `ceiling()`

---

# 46. Scenario-Based SDET Question

### Question

You receive API response values:

```text
200
404
200
500
404
201
```

You need unique values while preserving response order.

Which collection?

### Answer

```java
LinkedHashSet<Integer>
```

Result:

```text
200
404
500
201
```

---

# 47. Scenario-Based Question

You receive:

```text
50
10
30
20
10
50
```

You need unique values in ascending order.

Use:

```java
TreeSet<Integer>
```

Result:

```text
10
20
30
50
```

---

# 48. Scenario-Based Question

You have one million IDs and frequently need to check whether an ID exists.

You don't care about ordering.

Which collection?

### Answer

```text
HashSet
```

because average lookup is `O(1)`.

---

# 49. Scenario-Based Question

You need:

```text
Unique test IDs
+
Original execution order
```

Use:

```text
LinkedHashSet
```

---

# 50. Scenario-Based Question

You need:

```text
Unique test IDs
+
Sorted order
+
Find next higher ID
```

Use:

```text
TreeSet
```

because it provides methods such as:

```java
higher()
lower()
ceiling()
floor()
```

---

# 51. Java 8 Stream Example

Remove duplicates:

```java
List<Integer> numbers =
        Arrays.asList(10, 20, 10, 30, 20);

Set<Integer> result =
        numbers.stream()
               .collect(Collectors.toSet());
```

For insertion order:

```java
Set<Integer> result =
        numbers.stream()
               .collect(Collectors.toCollection(
                   LinkedHashSet::new
               ));
```

For sorted order:

```java
Set<Integer> result =
        numbers.stream()
               .collect(Collectors.toCollection(
                   TreeSet::new
               ));
```

---

# 52. Quick Comparison to Memorize

```text
                 SET
                  |
        ┌─────────┼─────────┐
        ↓         ↓         ↓
    HashSet   LinkedHashSet TreeSet
        |         |           |
        ↓         ↓           ↓
    Unique      Unique      Unique
        |         |           |
    No order   Insertion     Sorted
                order         order
        |         |           |
       O(1)      O(1)        O(log n)
```

---

# 53. Top 15 Questions You Should Prepare

For an experienced SDET interview, definitely prepare these:

1. What is a Set?
2. Difference between HashSet, LinkedHashSet and TreeSet?
3. How does HashSet identify duplicates?
4. Why are `equals()` and `hashCode()` important?
5. What happens if equals() is overridden but hashCode() isn't?
6. How does HashSet handle hash collisions?
7. Does HashSet maintain insertion order?
8. Why does LinkedHashSet maintain insertion order?
9. How does TreeSet maintain sorted order?
10. What is the internal data structure of TreeSet?
11. How does TreeSet determine duplicates?
12. Difference between Comparable and Comparator with TreeSet?
13. What happens if compareTo() returns 0?
14. What are `higher()`, `lower()`, `ceiling()` and `floor()`?
15. Which Set would you choose for a real automation scenario and why?

---

# 54. Final Interview Cheat Sheet

| Requirement                              | Choose                               |
| ---------------------------------------- | ------------------------------------ |
| Unique values                            | `HashSet`                            |
| Unique + fast lookup                     | `HashSet`                            |
| Unique + insertion order                 | `LinkedHashSet`                      |
| Unique + sorted order                    | `TreeSet`                            |
| Unique + reverse sorted                  | `TreeSet(Comparator.reverseOrder())` |
| Need `higher()` / `lower()`              | `TreeSet`                            |
| Need `floor()` / `ceiling()`             | `TreeSet`                            |
| Custom object uniqueness                 | `HashSet` + `equals/hashCode`        |
| Custom object sorting                    | `TreeSet` + `Comparable/Comparator`  |
| Remove duplicates preserving input order | `LinkedHashSet`                      |
| Remove duplicates and sort               | `TreeSet`                            |

## The 3 lines to memorize

> **HashSet = Unique + No guaranteed order + Hashing**

> **LinkedHashSet = Unique + Insertion order + Hashing**

> **TreeSet = Unique + Sorted order + Tree**
