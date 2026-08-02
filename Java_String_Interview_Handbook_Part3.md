# Java String Interview Handbook - Part 3

# 15. Find Minimum Occurring Character

``` java
String s="banana";
char ch=s.chars().mapToObj(c->(char)c)
.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
System.out.println(ch);
```

# 16. Convert Sentence to Uppercase

``` java
System.out.println("java streams".toUpperCase());
```

# 17. Convert Sentence to Lowercase

``` java
System.out.println("JAVA STREAMS".toLowerCase());
```

# 18. Reverse Each Word using Streams

``` java
String s="Java Stream";
String r=Arrays.stream(s.split("\\s+"))
.map(w->new StringBuilder(w).reverse().toString())
.collect(Collectors.joining(" "));
System.out.println(r);
```

# 19. Reverse Complete Sentence

``` java
String s="Automation";
String r=new StringBuilder(s).reverse().toString();
System.out.println(r);
```

# 20. Join Strings using Collectors.joining()

``` java
List<String> list=Arrays.asList("Java","Stream","API");
String r=list.stream().collect(Collectors.joining(" "));
System.out.println(r);
```

# 21. Group Anagrams using Streams

``` java
List<String> words=Arrays.asList("eat","tea","tan","ate","nat","bat");
Map<String,List<String>> map=words.stream()
.collect(Collectors.groupingBy(w->{
 char[] a=w.toCharArray();
 Arrays.sort(a);
 return new String(a);
}));
map.values().forEach(System.out::println);
```
