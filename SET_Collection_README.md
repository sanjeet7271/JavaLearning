# Java Set Collection Learning
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
