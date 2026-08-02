# Core Java String Handbook - Part 3

## 15. Minimum Occurring Character

``` java
import java.util.LinkedHashMap;
import java.util.Map;

public class MinimumOccurringCharacter {

    public static void main(String[] args) {

        String s = "banana";

        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char minFrequencyChar = ' ';
        int minCount = Integer.MAX_VALUE;

        // Find the character with the minimum frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < minCount) {
                minCount = entry.getValue();
                minFrequencyChar = entry.getKey();
            }
        }

        // Print the minimum occurring character
        System.out.println(minFrequencyChar);
    }
}
```

## 16. Uppercase

``` java
System.out.println("java".toUpperCase());
```

## 17. Lowercase

``` java
System.out.println("JAVA".toLowerCase());
```

## 18. Reverse Each Word

``` java
public class ReverseEachWord {

    public static void main(String[] args) {

        String sentence = "Java Stream";

        // Reverse each word individually
        for (String word : sentence.split("\\s+")) {
            System.out.print(new StringBuilder(word).reverse() + " ");
        }
    }
}
```

## 19. Reverse Complete Sentence

``` java
String s="Automation";
System.out.println(new StringBuilder(s).reverse());
```

## 20. Join Strings

``` java
public class JoinStrings {

    public static void main(String[] args) {

        String[] words = { "Java", "Stream", "API" };

        StringBuilder result = new StringBuilder();

        // Join all strings with a space
        for (int i = 0; i < words.length; i++) {

            if (i > 0) {
                result.append(" ");
            }

            result.append(words[i]);
        }

        System.out.println(result);
    }
}
```

## 21. Group Anagrams

``` java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] words = {
                "eat", "tea", "tan",
                "ate", "nat", "bat"
        };

        Map<String, List<String>> map = new HashMap<>();

        // Group words having the same sorted characters
        for (String word : words) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>())
               .add(word);
        }

        // Print grouped anagrams
        System.out.println(map.values());
    }
}
```
