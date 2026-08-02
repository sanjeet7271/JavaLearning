# Core Java String Handbook - Part 1

## 1. Count Characters

``` java
String s="Sanjeet Kumar";
Map<Character,Integer> map=new LinkedHashMap<>();
for(char c:s.toCharArray()){
    if(c!=' ') map.put(c,map.getOrDefault(c,0)+1);
}
System.out.println(map);
```

Time: O(n), Space: O(n)

## 2. Count Words

``` java
String s="Hi there how are you";
String[] words=s.trim().split("\\s+");
System.out.println(words.length);
```

## 3. Count Vowels

``` java
public class CountVowels {

    public static void main(String[] args) {

        String str = "Automation";
        int count = 0;

        for (char ch : str.toLowerCase().toCharArray()) {

            if ("aeiou".indexOf(ch) >= 0) {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }
}
```

## 4. Count Duplicate Characters

``` java
import java.util.LinkedHashMap;
import java.util.Map;

public class CountDuplicateCharacters {

    public static void main(String[] args) {

        String str = "programming";

        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count the frequency of each character
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Print only duplicate characters
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}
```

## 5. Count Duplicate Words

``` java
import java.util.LinkedHashMap;
import java.util.Map;

public class CountDuplicateWords {

    public static void main(String[] args) {

        String str = "java java api api api";

        Map<String, Integer> map = new LinkedHashMap<>();

        // Count the frequency of each word
        for (String word : str.split("\\s+")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Print only duplicate words
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}
```

## 6. Remove Duplicate Characters

``` java
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {

    public static void main(String[] args) {

        String str = "programming";

        StringBuilder result = new StringBuilder();

        Set<Character> set = new LinkedHashSet<>();

        // Remove duplicate characters while maintaining insertion order
        for (char ch : str.toCharArray()) {

            if (set.add(ch)) {
                result.append(ch);
            }
        }

        System.out.println(result);
    }
}
```

## 7. Remove Duplicate Words

``` java
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords {

    public static void main(String[] args) {

        String s = "java java stream api api";

        Set<String> set = new LinkedHashSet<>();

        // Split the string into words and add them to the LinkedHashSet
        // LinkedHashSet removes duplicates while maintaining insertion order
        for (String word : s.split("\\s+")) {
            set.add(word);
        }

        // Print unique words in the original order
        for (String word : set) {
            System.out.print(word + " ");
        }
    }
}
```
