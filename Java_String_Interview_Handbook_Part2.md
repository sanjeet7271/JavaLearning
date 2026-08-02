# Java String Interview Handbook - Part 2

# 8. Find First Repeated Character

``` java
String s="programming";
Set<Character> set=new HashSet<>();
for(char c:s.toCharArray()){
    if(!set.add(c)){ System.out.println(c); break; }
}
```

**Time:** O(n) **Space:** O(n)

# 9. Find First Non-Repeated Character

``` java
String s="swiss";
Map<Character,Integer> map=new LinkedHashMap<>();
for(char c:s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
for(var e:map.entrySet()) if(e.getValue()==1){System.out.println(e.getKey());break;}
```

# 10. Sort Characters Alphabetically

``` java
String s="automation";
String r=s.chars().sorted()
.mapToObj(c->String.valueOf((char)c))
.collect(Collectors.joining());
System.out.println(r);
```

# 11. Sort Words by Length

``` java
String s="Java Stream Automation Selenium";
Arrays.stream(s.split("\\s+"))
.sorted(Comparator.comparingInt(String::length))
.forEach(System.out::println);
```

# 12. Find Longest Word

``` java
String s="Java Stream Automation Selenium";
String w=Arrays.stream(s.split("\\s+"))
.max(Comparator.comparingInt(String::length)).orElse("");
System.out.println(w);
```

# 13. Find Shortest Word

``` java
String s="Java Stream Automation Selenium";
String w=Arrays.stream(s.split("\\s+"))
.min(Comparator.comparingInt(String::length)).orElse("");
System.out.println(w);
```

# 14. Find Maximum Occurring Character

``` java
String s="success";
char ch=s.chars().mapToObj(c->(char)c)
.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
System.out.println(ch);
```
