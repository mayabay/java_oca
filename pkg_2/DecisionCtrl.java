package pkg_2;
import java.util.Scanner;

public class DecisionCtrl {


    public static void main(String[] args){
        //testIf();
        test20(args);
    }

    static void testIf(){
    
        if (false)
            System.out.println( "inside" );

            System.out.println( "out again?" );
        
        boolean isHungry = true, isBirthday = true;

        if ( isHungry & isBirthday ){
            System.out.println( "eating cake in Darmstadt" );

        }
        
    }

    static void test16(){
        int x = 15, y = 12; boolean zugang = false;
        int smallest = 0;
        if ( x > y )
            smallest = y;
        else
            smallest = x;
        if (zugang)
            System.out.println( "open" );
        else
            System.out.println( "closed" );


    }

    static void test17( String[] args ){
        if (args.length == 0){
              System.out.println( "need a float number here" );
              System.exit(0);
        }

        double adouble = 0; // DNC 58: error: variable adouble might not have been initialized
                    // w/o assigment
        try{
            Double.parseDouble(args[0]);
        }
        catch( NumberFormatException nfe ){
            System.out.println( "not a double!" );
            adouble = 6.00D;    // :-)
        }
        
        int score = (int)adouble;
        switch(score){
            case 1 : System.out.println( "sehr gut" ); break;
            case 2 : System.out.println( "gut" ); break;
            case 3 : System.out.println( "befriedigend" ); break;
            case 4 : System.out.println( "ausreichend" ); break;
            case 5 : System.out.println( "mangelhaft" ); break;
            case 6 : System.out.println( "ungenuegend" ); break;

        }
    }

    /*
     *  19 leap year calculator
     * */
    static void test19(String[] args){
        if (args.length == 0){
              System.out.println( "need a integer number here" );
              System.exit(0);
        }
        
        int n = 0;
        try{
            n = Integer.parseInt( args[0] );
        }
        catch( NumberFormatException nfe ){
            System.out.println( "not an integer!" );
            n = 0;    // :-)
        }

        // every 4 years
        int r = 0;
        
        boolean isLeapYear = false;

        if (n == 0) {
            isLeapYear = true;
        }

        if ( (n % 4) == 0 ){                // rule 1
            isLeapYear = true;
            if ( (n % 100 ) == 0 ) {        // rule 2
                isLeapYear = false;
                if ( (n % 400) == 0 ){      // rule 3
                    isLeapYear = true;
                }
            }


        }

        if (isLeapYear)
            System.out.println( n + " is a leap year." );
        else
            System.out.println( n + " is not leap year." );

    }

    static void test20(String[] args){
        int hilf, a = 3, b = 1, c = 2;
        if ( a > b ){
            hilf = b; 
            b = a;
            a = hilf;
        }
        if ( b > c ){
            hilf = b;
            b = c;
            c = hilf;
        }
        
        System.out.println( "a = " + a + ", b = " + b + ", c = " + c );
    }

}


