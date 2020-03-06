package pkg_6;

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
        catch( Exception e  ){
            System.out.println( "shoot did not meet target!" );
            System.out.println( e.getMessage() );
        }
    }

    void shoot() throws MissedException {
        throw new MissedException("player missed the goal!");
    }
}

public class LearnExceptions {

    public static void main(String[] args){
        //m1();
        new Soccer().play();
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
