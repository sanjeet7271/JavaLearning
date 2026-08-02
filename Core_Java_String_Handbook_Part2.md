# Core Java String Handbook - Part 2

## 8. First Repeated Character

``` java
Set<Character> set=new HashSet<>();
for(char c:"programming".toCharArray())
 if(!set.add(c)){System.out.println(c);break;}
```

## 9. First Non-Repeated Character

``` java
String s="swiss";
Map<Character,Integer> map=new LinkedHashMap<>();
for(char c:s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
for(Map.Entry<Character,Integer> e:map.entrySet())
 if(e.getValue()==1){System.out.println(e.getKey());break;}
```

## 10. Sort Characters

``` java
char[] a="automation".toCharArray();
Arrays.sort(a);
System.out.println(new String(a));
```

## 11. Sort Words by Length

``` java
String[] w="Java Stream Automation".split("\\s+");
Arrays.sort(w,Comparator.comparingInt(String::length));
System.out.println(Arrays.toString(w));
```

## 12. Longest Word

``` java
String max="";
for(String w:"Java Stream Automation".split("\\s+"))
 if(w.length()>max.length()) max=w;
System.out.println(max);
```

## 13. Shortest Word

``` java
String[] arr="Java Stream Automation".split("\\s+");
String min=arr[0];
for(String w:arr) if(w.length()<min.length()) min=w;
System.out.println(min);
```

## 14. Maximum Occurring Character

``` java
String s="success";
Map<Character,Integer> m=new HashMap<>();
for(char c:s.toCharArray()) m.put(c,m.getOrDefault(c,0)+1);
char ans=' ';int max=0;
for(Map.Entry<Character,Integer> e:m.entrySet())
 if(e.getValue()>max){max=e.getValue();ans=e.getKey();}
System.out.println(ans);
```
