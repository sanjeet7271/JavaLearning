# Overloading
## Method overloading can be done by

  1. Changing number of arguments, or  (In Program 1 below)
  2. Keeping same number of arguments but changing data data type of arguments.

## 10 Features of Method overloading
    1.) Call to overloaded method is bonded at compile time
    2.) Method overloading concept is also known as compile time polymorphism in java
    3.) Java does not allow overloading by changing the return type, though overloaded methods can change the return type
    4.) final methods can be overloaded in java
    
 
## Overriding
    1.) Access Modifier of the overriding method (method of subclass) cannot be more restrictive than the overridden method of parent class. For e.g. if the Access Modifier of
        parent class method is public then the overriding method (child class method ) cannot have private, protected and default Access modifier,because all of these three access
        modifiers are more restrictive than public.
    2.) private, static and final methods cannot be overridden as they are local to the class. However static methods can be re-declared in the sub class,
        in this case the sub-class method would act differently and will have nothing to do with the same static method of parent class.

## Overriding Examples :
    1.) Normal Parent child calls
                    class parent {
                      void showTheParent() {
                        System.out.println("Parent's show()");
                      }

                      void displayTheParent() {
                        System.out.println("parent's display()");
                      }
                    }

                    class child extends parent {
                      void showTheChild() {
                        System.out.println("Child's show()");
                      }

                      void displayTheChild() {
                        System.out.println("child's display()");
                      }
                    }

                    public class problem3 {
                      public static void main(String[] args) {
                        System.out.println("**************Only Parent method will be called****************");
                        parent p = new parent();
                        p.showTheChild(); //Error, we can not access child items, Because this is parent reference
                        p.showTheParent();
                        p.displayTheChild(); //Error, we can not access child items, Because this is parent reference
                        p.displayTheParent();

                        System.out.println(
                            "**************child will access his own methods and parent method as child exteds parent****************");

                        child c = new child();
                        c.showTheChild();
                        c.showTheParent();
                        c.displayTheChild();
                        c.displayTheParent();

                        System.out.println(
                            "**************parent can access his own methods not child methods****************");

                        parent p1 = new child();
                        p1.showTheChild(); //Error, Because the reference is parent reference
                        p1.showTheParent();
                        p1.displayTheChild(); //Error, Because the reference is parent reference
                        p1.displayTheParent();
                      }
                  }
      
     2.) Overridig Example with single method in parent and child
                   class parent {
                        void show() {
                          System.out.println("Parent's show()");
                        }
                      }

                      class child extends parent {
                        @Override
                        void show() {
                          System.out.println("Child's show()");
                        }
                      }

                      class problem1 {
                        public static void main(String[] args) {
                          // If a Parent type reference refers
                          // to a Parent object, then Parent's
                          // show is called
                          parent p = new parent();
                          // If a Parent type reference refers
                          // to a Child object Child's show()
                          //  RUN TIME POLYMORPHISM.
                          parent c = new child();
                          p.show();
                          c.show();
                        }
                      }
                      
       3.) Overridig Example with two method in parent and child  
      
                 class parent1 {
                  void show() {
                    System.out.println("Parent's show()");
                  }
                  void display() {
                    System.out.println("parent's display()");
                  }
                }
                class child1 extends parent1 {
                  void show() {
                    System.out.println("Child's show()");
                  }
                  void hidden() {
                    System.out.println("child's hidden()");
                  }
                }
                public class problem2 {
                  public static void main(String[] args) {
                    System.out.println("**************Only Parent method will be called****************");
                    //Parent will access only parent method call, don't have rights to call child's method
                    parent1 p=new parent1();
                    p.show();
                    p.display();
                    System.out.println("**************Parent and Child method will be called****************");
                    //Child can call his own methods and all parent method also, but overriden method call will be from child class.
                    child1 c=new child1();
                    c.show();
                    c.display();
                    c.hidden();
                    System.out.println("**************Parent and Child method will be called****************");
                    parent1 p1=new child1();
                    p1.show(); // will call from child's class because method is overriden
                    p1.display(); // as object id parent's reference so parent method will call

                  }

                }
