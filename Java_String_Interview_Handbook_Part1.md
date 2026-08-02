# Java String Interview Handbook - Part 1

# 1. Count Characters

Problem: Count frequency of each character.

``` java
String s="Sanjeet Kumar";
s.chars().mapToObj(c->(char)c).filter(c->c!=' ')
.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
.forEach((k,v)->System.out.println(k+"="+v));
```

**Time:** O(n) **Space:** O(n)

# 2. Count Words

``` java
String s="Hi there hi";
Arrays.stream(s.split("\\s+"))
.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
.forEach((k,v)->System.out.println(k+":"+v));
```

**Time:** O(n)

# 3. Count Vowels

``` java
String s="Automation";
long count=s.toLowerCase().chars()
.filter(c->"aeiou".indexOf(c)>=0).count();
System.out.println(count);
```

# 4. Count Duplicate Characters

``` java
String s="programming";
s.chars().mapToObj(c->(char)c)
.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
.entrySet().stream().filter(e->e.getValue()>1)
.forEach(System.out::println);
```

# 5. Count Duplicate Words

``` java
String s="java java stream api api api";
Arrays.stream(s.split("\\s+"))
.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
.entrySet().stream().filter(e->e.getValue()>1)
.forEach(System.out::println);
```

# 6. Remove Duplicate Characters

``` java
String s="programming";
String r=s.chars().mapToObj(c->String.valueOf((char)c))
.distinct().collect(Collectors.joining());
System.out.println(r);
```

# 7. Remove Duplicate Words

``` java
String s="java java stream api api";
String r=Arrays.stream(s.split("\\s+"))
.distinct().collect(Collectors.joining(" "));
System.out.println(r);
```
