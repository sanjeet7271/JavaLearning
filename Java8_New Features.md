### Java 8 Features

   - Predicates
   - Functions
   - Consumer
   - Supplier
   - BiConsumer
   - Streams
   - Parallel Stream

### Predicate
   - Predicate is a predefined Functional Interface(Having only 1 abstract method)
   - The Only abstract method of predicate is test(T t)
   - public boolean test(T t)
   - Whenever we want to check some boolean condition, you can go for predicates

               package Predict_Interface;
               import java.util.function.Predicate;
               public class Predicate_Example1 {
               	
               	public static void main(String[] args) {
               		Predicate<Integer> predicate=i->(i>10);
               		System.out.println(predicate.test(100));
               		System.out.println(predicate.test(7));
               		//System.out.println(predicate.test(true)); compiler error
               		Predicate<String> strPre=s->s.length()>=5;
               		System.out.println("Ccheck String Length is "+strPre.test("Sanjeet"));
               	}
               
               }
     
