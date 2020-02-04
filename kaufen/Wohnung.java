package kaufen;
import static java.lang.System.*;
//import static java.io.Printstream.println; // DNC 3: error: static import only from classes and interfaces
class Wohnung {

    
    static void einziehen(){
        
        out.println( "Ich ziehe auch hier ein."  );
        
        // println("bla");  // belongs to java.io.PrintWriter, -> instance provided in java.lang.System.out 
        kaufen();
    }       

    static void kaufen(){
        
        System.out.println( "Man kann mich auch kaufen" );
    }

}
