package pkg_4;
import java.util.function.*;
import java.util.*; 
interface Runnable {
    public void run();
}
class MyClass {}
public class LearnLambdas {

    //Predicate p = (MyClass x) -> 7 > 23; // DNC 7: error: incompatible types: incompatible parameter types in lambda expression
    Predicate<MyClass> p = (MyClass x) -> 7 > 23;

    Runnable run = 0 -> { System.out.println( "Run" ); };
  

    public static void main(String[] args){
    
    }
}
