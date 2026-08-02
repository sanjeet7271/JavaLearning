# Core Java String Handbook - Part 2

## 8. First Repeated Character

``` java
import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateCharacter {

    public static void main(String[] args) {

        Set<Character> set = new HashSet<>();

        // Find the first duplicate character
        for (char c : "programming".toCharArray()) {
            if (!set.add(c)) {
                System.out.println(c);
                break;
            }
        }
    }
}
```

## 9. First Non-Repeated Character

``` java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {

        String s = "swiss";

        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeated character
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
```

## 10. Sort Characters

``` java
import java.util.Arrays;

public class SortCharacters {

    public static void main(String[] args) {

        // Convert the string to a character array
        char[] chars = "automation".toCharArray();

        // Sort the characters in ascending order
        Arrays.sort(chars);

        // Convert the sorted character array back to a String
        System.out.println(new String(chars));
    }
}
```

## 11. Sort Words by Length

``` java
import java.util.Arrays;
import java.util.Comparator;

public class SortWordsByLength {

    public static void main(String[] args) {

        // Split the string into words
        String[] words = "Java Stream Automation".split("\\s+");

        // Sort the words based on their length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Print the sorted array
        System.out.println(Arrays.toString(words));
    }
}
```

## 12. Longest Word

``` java
public class LongestWord {

    public static void main(String[] args) {

        String sentence = "Java Stream Automation";

        String longestWord = "";

        // Find the longest word in the sentence
        for (String word : sentence.split("\\s+")) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // Print the longest word
        System.out.println(longestWord);
    }
}
```

## 13. Shortest Word

``` java
public class ShortestWord {

    public static void main(String[] args) {

        // Split the sentence into words
        String[] words = "Java Stream Automation".split("\\s+");

        // Assume the first word is the shortest
        String shortestWord = words[0];

        // Find the shortest word
        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }

        // Print the shortest word
        System.out.println(shortestWord);
    }
}
```

## 14. Maximum Occurring Character

``` java
import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyCharacter {

    public static void main(String[] args) {

        String s = "success";

        Map<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char maxFrequencyChar = ' ';
        int maxCount = 0;

        // Find the character with the highest frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxFrequencyChar = entry.getKey();
            }
        }

        // Print the character with the maximum frequency
        System.out.println(maxFrequencyChar);
    }
}
```
