# Java HashSet Collection Learning
## Basic Characteristics
    - HashSet stores the elements by using a mechanism called hashing.
    - HashSet contains unique elements only.
    - HashSet allows null value.
    - HashSet class is non synchronized.
    - HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
    - The initial default capacity of HashSet is 16, and the load factor is 0.75
    
## Declaration of HashSet:
    public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable
    where where E is the type of elements stored in a HashSet
## Constructors of HashSet class
    i) HashSet(): the default initial capacity is 16 and the default load factor is 0.75
    ii) HashSet(int initialCapacity) : user can define their own size, but the default loadFactor remains 0.75
    iii) HashSet(int initialCapacity, float loadFactor)
    iv) HashSet(Collection)
    
## Internal working of Set/HashSet in Java
    we create a HashSet, it internally creates a HashMap and if we insert an element into this HashSet using add() method, 
    it actually call put() method on internally created HashMap object with element you have specified as it’s key and constant Object called “PRESENT” as it’s value.
    So we can say that a Set achieves uniqueness internally through HashMap
    
    
    
# Java LinkedHashSet Collection Learning
## Basic Characteristics
    -  LinkedHashSet class contains unique elements only like HashSet.
    -  LinkedHashSet class is non synchronized.
    -  LinkedHashSet class maintains insertion order
 
## Declaration: 
        public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable
        
