# Thread Local
## What is Thread Local
**Answer:** Java ThreadLocal class provides a simple way to make code thread safe. The Java ThreadLocal class enables you to create variables that can only be
read and written by the same thread. Thus, even if two threads are executing the same code, and the code has a reference to the same ThreadLocal variable,the two
threads cannot see each other's ThreadLocal variables

## Creating a ThreadLocal
You create a ThreadLocal instance just like you create any other Java object - via the new operator<br>
    private ThreadLocal thread_local=new ThreadLocal();<br>
## Set ThreadLocal Value <br>
Once a ThreadLocal has been created you can set the value to be stored in it using its set() method.<br>
    thread_local.set("A Local value set");<br>
  
## Get ThreadLocal Value <br>
You read the value stored in a ThreadLocal using its get() method. <br>
    String threadlocalValue=(String)thread_local.get(); <br>
    
## Remove ThreadLocal Value <br>
  thread_local.remove(); <br>
