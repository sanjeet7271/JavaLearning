# String Interview Questions

# 1. Count Consecutive Characters (Run-Length Encoding)

## Problem Statement

Given a string, count **consecutive** occurrences of each character
while preserving order.

### Input

``` text
AAaaaaBBBcccCCCbbb
```

### Output

``` text
A2a4B3c3C3b3
```

## Java Solution

``` java
public class CountEachCharInSameSequence {

    public static void main(String[] args) {

        String str = "AAaaaaBBBcccCCCbbb";
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        result.append(str.charAt(str.length() - 1)).append(count);
        System.out.println(result);
    }
}
```

## Dry Run

  Sequence     Count Output
  ---------- ------- --------------
  AA               2 A2
  aaaa             4 A2a4
  BBB              3 A2a4B3
  ccc              3 A2a4B3c3
  CCC              3 A2a4B3c3C3
  bbb              3 A2a4B3c3C3b3

## Time Complexity

-   O(n)

## Space Complexity

-   O(n)

## Interview Notes

-   Classic Run-Length Encoding (RLE).
-   Initialize `count` to `1`.
-   Append the last group after the loop.
-   Uppercase and lowercase are treated as different characters.

------------------------------------------------------------------------

# 2. Count Character Frequency Using Java 8 Streams

## Problem Statement

Count the frequency of each character while preserving insertion order
and ignoring spaces.

### Input

``` text
Sanjeet Kumar Pandit
```

### Output

``` text
S1a3n2j1e2t2K1u1m1r1P1d1i1
```

## Java Solution

``` java
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacterFromString {

    public static void main(String[] args) {

        String str = "Sanjeet Kumar Pandit";

        // Method 1
        str.chars()
           .mapToObj(ch -> (char) ch)
           .filter(ch -> ch != ' ')
           .collect(Collectors.groupingBy(
                   Function.identity(),
                   LinkedHashMap::new,
                   Collectors.counting()))
           .forEach((k, v) -> System.out.print(k + "" + v));

        System.out.println();

        // Method 2
        str.chars()
           .mapToObj(ch -> (char) ch)
           .filter(ch -> ch != ' ')
           .collect(Collectors.groupingBy(
                   ch -> ch,
                   LinkedHashMap::new,
                   Collectors.counting()))
           .forEach((k, v) -> System.out.print(k + "" + v));

        System.out.println();

        // Method 3
        Arrays.stream(str.split(""))
              .filter(ch -> !ch.isBlank())
              .collect(Collectors.groupingBy(
                      Function.identity(),
                      LinkedHashMap::new,
                      Collectors.counting()))
              .forEach((k, v) -> System.out.print(k + "" + v));
    }
}
```

## Explanation

-   `chars()` creates an `IntStream`.
-   `mapToObj(ch -> (char) ch)` converts Unicode values to `Character`.
-   `filter()` removes spaces.
-   `LinkedHashMap` preserves insertion order.
-   `Collectors.counting()` returns the frequency as `Long`.

## Time Complexity

-   O(n)

## Space Complexity

-   O(n)

## Interview Notes

-   Prefer `LinkedHashMap` when output order matters.
-   `Function.identity()` uses the element itself as the key.
-   This is a popular Java 8 Streams interview question.

------------------------------------------------------------------------

# 3. Count Word Frequency Using Java 8 Streams

## Problem Statement

Count the frequency of each word in a sentence while maintaining the
insertion order.

### Input

``` text
Hi there How are you doing
```

### Output

``` text
Hi:1 there:1 How:1 are:1 you:1 doing:1
```

## Java Solution

``` java
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordsFromString {

    public static void main(String[] args) {

        String str = "Hi there How are you doing";

        Arrays.stream(str.split(" "))
              .filter(word -> !word.isBlank())
              .collect(Collectors.groupingBy(
                      Function.identity(),
                      LinkedHashMap::new,
                      Collectors.counting()))
              .forEach((k, v) -> System.out.print(k + ":" + v + " "));
    }
}
```

## Explanation

-   `split(" ")` splits the sentence into words.
-   `Arrays.stream()` converts the array into a Stream.
-   `filter(word -> !word.isBlank())` removes empty words.
-   `Function.identity()` groups by the word itself.
-   `LinkedHashMap` preserves the insertion order.
-   `Collectors.counting()` counts the occurrences of each word.

## Dry Run

  Word      Count
  ------- -------
  Hi            1
  there         1
  How           1
  are           1
  you           1
  doing         1

## Time Complexity

-   **O(n)**

## Space Complexity

-   **O(n)**

## Interview Notes

-   Prefer `Arrays.stream(str.split(" "))` over
    `Arrays.asList(...).stream()`.
-   Use `LinkedHashMap` when the output order should match the input.
-   `Collectors.counting()` returns a `Long`.
-   If the input may contain multiple spaces, consider using
    `split("\\\\s+")` instead of `split(" ")`.
-   This is a common Java 8 Streams interview question for SDET and Java
    roles.

# Count Character Frequency Without Java 8 Streams

## Problem Statement

Write a Java program to count the frequency of each character in a string **without using Java 8 Streams**, while maintaining the insertion order.

### Input

```text
Hello World
```

### Output

```text
H:1
e:1
l:3
o:2
W:1
r:1
d:1
```

> Note: Spaces are ignored while printing.

---

# Java Code

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharWithoutJava8 {

    public static void main(String[] args) {

        String str = "Hello World";

        // Maintains insertion order
        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),
                    map.getOrDefault(str.charAt(i), 0) + 1);
        }

        // Print complete map
        System.out.println(map);

        // Print each character except spaces
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getKey() != ' ') {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
```

---

# Code Explanation

## Step 1: Import Required Classes

```java
import java.util.LinkedHashMap;
import java.util.Map;
```

- `Map` stores key-value pairs.
- `LinkedHashMap` preserves the insertion order of characters.

---

## Step 2: Create Input String

```java
String str = "Hello World";
```

This is the input string whose character frequencies need to be counted.

---

## Step 3: Create LinkedHashMap

```java
Map<Character, Integer> map = new LinkedHashMap<>();
```

- **Key** → Character
- **Value** → Frequency

Example after processing:

```
H -> 1
e -> 1
l -> 3
o -> 2
(space) -> 1
W -> 1
r -> 1
d -> 1
```

---

## Step 4: Count Character Frequency

```java
for (int i = 0; i < str.length(); i++) {
    map.put(str.charAt(i),
            map.getOrDefault(str.charAt(i), 0) + 1);
}
```

### How it works

For every character:

1. Read the current character using `charAt(i)`.
2. Check whether it already exists in the map.
3. If not present, `getOrDefault()` returns `0`.
4. Add `1` to the count.
5. Store the updated count back in the map.

### Iteration Example

| Character | Previous Count | New Count |
|-----------|---------------:|----------:|
| H | 0 | 1 |
| e | 0 | 1 |
| l | 0 | 1 |
| l | 1 | 2 |
| o | 0 | 1 |
| (space) | 0 | 1 |
| W | 0 | 1 |
| o | 1 | 2 |
| r | 0 | 1 |
| l | 2 | 3 |
| d | 0 | 1 |

Final Map:

```text
{H=1, e=1, l=3, o=2,  =1, W=1, r=1, d=1}
```

---

## Step 5: Print Complete Map

```java
System.out.println(map);
```

Output:

```text
{H=1, e=1, l=3, o=2,  =1, W=1, r=1, d=1}
```

---

## Step 6: Print Without Spaces

```java
for (Map.Entry<Character, Integer> entry : map.entrySet()) {

    if (entry.getKey() != ' ') {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
}
```

The `entrySet()` method returns all key-value pairs in the map.

Each entry contains:
- `getKey()` → Character
- `getValue()` → Frequency

The condition:

```java
entry.getKey() != ' '
```

ignores the space character.

Output:

```text
H:1
e:1
l:3
o:2
W:1
r:1
d:1
```

---

# Why LinkedHashMap Instead of HashMap?

| HashMap | LinkedHashMap |
|---------|---------------|
| Does not maintain insertion order | Maintains insertion order |
| Faster in some cases | Slightly slower |
| Output order may change | Output order matches input |

For interview questions where the original character order must be preserved, `LinkedHashMap` is the preferred choice.

---

# Time Complexity

### Time

```
O(n)
```

Each character is processed exactly once.

### Space

```
O(n)
```

In the worst case, every character is unique.

---

# Interview Questions

### Why use `getOrDefault()`?

It avoids writing an explicit `containsKey()` check and makes the code shorter and cleaner.

---

### Why not use `HashMap`?

`HashMap` does not preserve insertion order, while `LinkedHashMap` does.

---

### How can you ignore spaces?

```java
if (entry.getKey() != ' ')
```

---

### Can this be solved without `Map`?

Yes. You can use:
- Nested loops
- ASCII array of size 256
- `int[]` frequency array

However, using a `Map` is the most flexible and readable solution.

---

# Final Output

```text
{H=1, e=1, l=3, o=2,  =1, W=1, r=1, d=1}

H:1
e:1
l:3
o:2
W:1
r:1
d:1
```