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
     
 - Return Type of predicate is boolean
 - Predicate Joining: To combine more than one predicate for a single result, we have 3 joins AND, OR,  and NEGATE
 - Negate work with only one predicate

            package Predict_Interface;
            import java.util.function.Predicate;
            public class Predicate_Example3 {
            	public static void testCondition(Predicate<Integer> predicate, int[] num) {
            		for(int no:num) {
            			if(predicate.test(no)) {
            				System.out.println(no);
            			}
            		}
            	}
            	public static void main(String[] args) {
            		
            		int[] num= {1,2,10,30,20,40,50,25,15};
            		Predicate<Integer> predicate_1=i->{
            			return i>10;
            		};
            		Predicate<Integer> predicate_2=i->{
            			return i%2==0;
            		};
            		System.out.println("The Number Greater than 10 and even are: ");
            		testCondition(predicate_1.and(predicate_2),num);
            	}
            
            }

### Function
   - Predicate is a predefined Functional Interface(Having only 1 abstract method)
   - The Only abstract method of predicate is apply(T t)
   - R apply(T t)
   - Given some input, perform some operation on the input and then produce/return a result (no necessary a boolean value)
   - It takes one input and returns one output
   - In Function return type is not fixed; hence, we declare both the input type and the return type

            package Function_Iterface;
            import java.util.function.Function;
            public class Function_Example3 {
            	public static void main(String[] args) {
            		Function<String, String> function1=str-> str.toUpperCase();
            		Function<String,String> function2=str-> str.substring(0,9);
            		System.out.println("The Result Function1 :"+function1.apply("sanjeetkumarpandit"));
            		System.out.println("The Result Function2 :"+function1.apply("sanjeetkumarpandit"));
            		System.out.println("The Result Function1 andthen function2:"+function1.andThen(function2).apply("sanjeetkumarpandit"));
            	}
            }

