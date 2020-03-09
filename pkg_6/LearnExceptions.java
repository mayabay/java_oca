package pkg_6;

import java.io.*;

class MissedException extends RuntimeException{
    public MissedException( String info ) {
        super( info );
    }
}

abstract class Game {
    void play(){}
}

class Soccer extends Game {
    

    void play(){
        //shoot();            // DNC 11: error: unreported exception Exception; must be caught or declared to be thrown
   
        try{
            shoot();
        }
        catch ( MissedException me ){
            System.out.println( "caught me" );
        }
        catch ( RuntimeException rte ){
            System.out.println( "caught rte" );
        }
        catch( Exception e  ){
            System.out.println( "shoot did not meet target!" );
            System.out.println( e.getMessage() );
        }
    }


    void play2(){
        try{
             shoot2();
        }
        catch( Exception e ){
            System.out.println( "caught e" );
        }
        finally{
            System.out.println( "play2() finally" );
        }
    }

    void play3(){
        try{
            // a tf is ok if only a unchecked e is thrown
            shoot();        // throws rte
            // for a checked e tf is not enough
            //fall();           // throws e 
        }
        finally{
            System.out.println( "play3() finally" );
        }
    }

    void fall() throws Exception {
        throw new Exception("I´ve fallen down!"); 
    }

    /*
     *  throws MissedException 
     * */
    void shoot(){
        String t = "t1";
        try{
            t = "t2";
            throw new RuntimeException("player missed the goal!");
            //t = "t3"; // DNC 66: error: unreachable statement
        }
        finally{
            System.out.println( t );
        }
    }


    /*
     * throws IOException 
     * */
    void shoot2() throws IOException  {
        try{
            for(;;){throw new Exception();}
            //; // statement is unreachable
        }
        catch( Exception e ){
            System.out.println( "caught shoot2() e" );
        }

        ;

    }
}

public class LearnExceptions {

    public static void main(String[] args){
        //m1();
        new Soccer().play3();
    }

    static void m1(){
        m2();
    }

    static void m2() {
        m3();
    }

    static void m3(){
        String text;                        
        //System.out.println( text );     // DNC 18: error: variable text might not have been initialized

        // System.out.println( 5 / 0 );  // RTE Exception in thread "main" java.lang.ArithmeticException: / by zero

    }



}
