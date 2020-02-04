package wohnen;
//import mieten.Wohnung;
import mieten.Wohnung;
import kaufen.*;
//import kaufen.Wohnung;
import static java.lang.System.*;
public class Wohnen {

	public static void main(String[] args){	
	    
        out.println("ok");
        
        //Haus.kaufen();

        //Haus.einziehen();
           
        // wildcard imports from different packages, identical class names  
        //Wohnung.mieten(); // DNC 15: error: reference to Wohnung is ambiguous

        //Wohnung.einziehen();
   
        byte b1 = 0b00001010;    
        short s1 = 23;
        char c1 = 92;
        
        System.out.println( "c1 = " + c1  );

        int i1 = 42;
        long l1 = 42;

        float f1 = 3.2E3F; 
        

        double d1 = 3.2E3;    
       
        Byte bb1 = new Byte( (byte)1  ); 
        Byte bb2 = new Byte( (byte)1  );
       
        Byte bb3 = 1;
        Byte bb4 = 1;
        
        System.out.println( "boxed Bytes, same values -> " + ( bb3 == bb4  )  );

        System.out.println("wrapper pool only for autoboxed wrappers so new() -> " + ( bb1 == bb2)  );
        //System.out.println("wrapper obj pool? -> " + (  (new Byte( (byte)  1)) == new Byte( (byte)1 ) )  );
        
    }	

}
