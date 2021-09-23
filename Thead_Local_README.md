# Thread Local
## What is Thread Local
**Answer:** Java ThreadLocal class provides a simple way to make code thread safe. The Java ThreadLocal class enables you to create variables that can only be
read and written by the same thread. Thus, even if two threads are executing the same code, and the code has a reference to the same ThreadLocal variable,the two
threads cannot see each other's ThreadLocal variables

## Creating a ThreadLocal
You create a ThreadLocal instance just like you create any other Java object - via the new operator
    private ThreadLocal thread_local=new ThreadLocal();
## Set ThreadLocal Value
Once a ThreadLocal has been created you can set the value to be stored in it using its set() method.
    thread_local.set("A Local value set");
  
## Get ThreadLocal Value
You read the value stored in a ThreadLocal using its get() method.
    String threadlocalValue=(String)thread_local.get();
    
## Remove ThreadLocal Value
  thread_local.remove();
