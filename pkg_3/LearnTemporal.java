package pkg_3;
import java.time.*;
import java.time.format.*;
import java.util.function.*;
public class LearnTemporal {

    public static void main(String[] args){
        do1();

        Predicate<String> pred = (String s) -> true;

        Predicate<String> pred = (Object o) -> true;    // DNC incompatible types: 
                                                        // incompatible parameter types in lambda expressio 
                                                    

    }

    static void do1(){
        
        LocalDate xmas = LocalDate.of(2016, 12, 25);
        xmas.plusDays(-1);
        System.out.println( xmas.getDayOfMonth() ); // 25 time classes are immutable

        xmas = xmas.plusDays(-1);                   // assign the new object to a ref variable
        System.out.println( xmas.getDayOfMonth() ); // 24 

    }
    
}
