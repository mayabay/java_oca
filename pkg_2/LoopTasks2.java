/*
 * LoopTasks
 * OCA While Schleifen 
 *
 *
 * */
package pkg_2;
import java.util.Scanner;

public class LoopTasks2 {


    public static void main(String[] args){
   
        //task33();
        task38(args);

    }

    static void task33(){
        int x = 1;
        while ( x <= 10 ){
            System.out.print( x + ( x == 10 ? "": ", " ) );
            x++;
        }
    }

    static void task34(){
        Scanner sc = new Scanner(System.in);
        System.out.println( "pls, input a binary :" );
        String input = sc.next();

        char[] carr = input.toCharArray();
        for( char c : carr ){
            if ( c != '1' && c != '0' ){
               return;
            } 
        }

        int sum = 0;

        int basePos = 0;

        for( int i = (carr.length-1); i >= 0; i-- ){
            if( carr[i] == '1' ){
                sum += 1 * ((int)Math.pow( 2, basePos ));
            } 
            basePos++;
        }

        sc.close();
        System.out.println( "input = " + input + " --> " + sum );

    }

    static void task35(String[] args){
        if (args.length == 0){
            System.out.println( "arg pls!" );
            return;
        }

        int idx = 0;
        char[] carr = args[0].toCharArray();
        
        boolean hasChars = true;
        while(hasChars){
            if ( idx < carr.length ){
                System.out.print( carr[idx] );
            }else{
                hasChars = false;
            }
            idx++;
        }
        System.out.println( "\nchars = " + (idx-1) );

    }       


    static void task36(String[] args){
        if (args.length == 0){
            System.out.println( "arg pls!" );
            return;
        }

        char[] carr = args[0].toCharArray();
        for( int i = (carr.length-1); i >= 0; i-- ){
            System.out.print( carr[i] );

        }

    }


    static void task37(String[] args){
        if (args.length == 0){
            //System.out.println( "arg pls!" );
            //return;
        }

        boolean sixFound = false;

        while (!sixFound){
            int n = (int)(Math.random() * 6 + 1);
            System.out.println( "i have a " + n );
            if (n == 6){
                System.out.println( "\t :-) !!" );
                sixFound = true;
            }
        }

    }

    static int atm_500 = 2;
    static int atm_200 = 12;
    static int atm_100 = 82;
    static int atm_50 = 6;
    static int atm_20 = 17;
    static int atm_10 = 3;
    static int atm_5 = 2;

    static int[] calcSetOfNotes( int amount ){
        
        int r = 0;

        int n_500 = 0;    
        int n_200 = 0;
        int n_100 = 0;
        int n_50 = 0;
        int n_20 = 0;
        int n_10 = 0;
        int n_5 = 0;

        if(  amount > 500  & atm_500  > 0  ){
            n_500 = (int) amount / 500;
            if ( atm_500 > n_500 ){
                r = amount - ( 500 * n_500 )     
            }
            else{ n_500 = 0; }
        }

        if(  r > 200  & atm_200  > 0  ){
            n_200 = (int) amount / 200;
            if ( atm_200 > n_200 ){
                r -= ( 200 * n_200 )     
            }
            else{ n_200 = 0; }
        }


        if ( r == 0 ) {
            //return new int[] { n_500, n_200,  }
        }
        else{
            return new int[] { -1,0,0,0,0,0,0 }
        }

    }

    static void task38( String[] args ){
        if (args.length == 0){
            System.out.println( "arg pls!" );
            return;
        }
        
        int[] set = calcSetOfNotes( Integer.parseInt( args[0] ) );

    }
    

}
