# Core Java String Handbook - Part 3

## 15. Minimum Occurring Character

``` java
String s="banana";
Map<Character,Integer> m=new LinkedHashMap<>();
for(char c:s.toCharArray()) m.put(c,m.getOrDefault(c,0)+1);
char ans=' ';int min=Integer.MAX_VALUE;
for(Map.Entry<Character,Integer> e:m.entrySet())
 if(e.getValue()<min){min=e.getValue();ans=e.getKey();}
System.out.println(ans);
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
for(String w:"Java Stream".split("\\s+"))
 System.out.print(new StringBuilder(w).reverse()+" ");
```

## 19. Reverse Complete Sentence

``` java
String s="Automation";
System.out.println(new StringBuilder(s).reverse());
```

## 20. Join Strings

``` java
String[] a={"Java","Stream","API"};
StringBuilder sb=new StringBuilder();
for(int i=0;i<a.length;i++){if(i>0)sb.append(" ");sb.append(a[i]);}
System.out.println(sb);
```

## 21. Group Anagrams

``` java
String[] words={"eat","tea","tan","ate","nat","bat"};
Map<String,List<String>> map=new HashMap<>();
for(String w:words){
 char[] c=w.toCharArray();Arrays.sort(c);
 String k=new String(c);
 map.computeIfAbsent(k,x->new ArrayList<>()).add(w);
}
System.out.println(map.values());
```
