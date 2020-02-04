package pkg_2;
public class LogicalOp{

    public static void main(String[] args){
        
        boolean a = true, b = false;

        System.out.println("a & b = " + (a & b) );
        

        boolean c = !a && b;        // does not check b

        c = !a & b;                 // checks always both sides, even if left hand is false

        int x;
        if ( (x=1) < 0 & ++x <=4 ){             // & -> checks both sides ( so no short circuit) and side effect
            System.out.println( "x = " + x );

        }

        System.out.println( "x = " + x );
    
        // --------------------------------------------------
        
        System.out.println( a | b );        // true

        System.out.println( a || b );        // true

        x = 0;

        if (  (x = 1) > 0 | ++x <= 4  ){
            
            System.out.println( "x = " + x );
        }  
         
        System.out.println( "x = " + x );


        // --------------------------------------------------
        // exclusive or ^ does not have a short circuit
        boolean b1 = true, b2 = true;
        if ( b1 ^ b2 ){
            System.out.println( "was true" );

        }

        


    }

}
