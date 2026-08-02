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
String s="Automation";
int count=0;
for(char c:s.toLowerCase().toCharArray())
    if("aeiou".indexOf(c)>=0) count++;
System.out.println(count);
```

## 4. Count Duplicate Characters

``` java
String s="programming";
Map<Character,Integer> map=new LinkedHashMap<>();
for(char c:s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
for(Map.Entry<Character,Integer> e:map.entrySet())
 if(e.getValue()>1) System.out.println(e.getKey()+"="+e.getValue());
```

## 5. Count Duplicate Words

``` java
String s="java java api api api";
Map<String,Integer> map=new LinkedHashMap<>();
for(String w:s.split("\\s+"))
 map.put(w,map.getOrDefault(w,0)+1);
for(Map.Entry<String,Integer> e:map.entrySet())
 if(e.getValue()>1) System.out.println(e);
```

## 6. Remove Duplicate Characters

``` java
String s="programming";
StringBuilder sb=new StringBuilder();
Set<Character> set=new LinkedHashSet<>();
for(char c:s.toCharArray()) if(set.add(c)) sb.append(c);
System.out.println(sb);
```

## 7. Remove Duplicate Words

``` java
String s="java java stream api api";
Set<String> set=new LinkedHashSet<>();
for(String w:s.split("\\s+")) set.add(w);
for(String w:set) System.out.print(w+" ");
```
