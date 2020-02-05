package pkg_2;
public class Lotto{
    

    static int l1 = 0, l2 = 0, l3 = 0, l4 = 0, l5 = 0, l6 = 0;

    static int called = 0;

    public static void main(String[] args){
        
        /*
        boolean allSet = false;

        while (!allSet){
            
            setNo();
            
            allSet = true;
            
            if ( l1 == 0 ){ allSet = false; } 
            if ( l2 == 0 ){ allSet = false; } 
            if ( l3 == 0 ){ allSet = false; } 
            if ( l4 == 0 ){ allSet = false; } 
            if ( l5 == 0 ){ allSet = false; } 
            if ( l6 == 0 ){ allSet = false; } 
        }
        */
        setNoCaller();

        System.out.println( "l1 = " + l1 );
        System.out.println( "l2 = " + l2 );
        System.out.println( "l3 = " + l3 );
        System.out.println( "l4 = " + l4 );
        System.out.println( "l5 = " + l5 );
        System.out.println( "l6 = " + l6 );
        
        System.out.println( "called = " + called );

    }

    static void setNoCaller(){
        setNo();
        boolean setNo = false;
            if ( l1 == 0 ){ setNo = true; } 
            if ( l2 == 0 ){ setNo = true; } 
            if ( l3 == 0 ){ setNo = true; } 
            if ( l4 == 0 ){ setNo = true; } 
            if ( l5 == 0 ){ setNo = true; } 
            if ( l6 == 0 ){ setNo = true; } 
        if (!setNo){
            return;
        }else{
            setNo();
        }
    }

    static void reset(){
        l1 = 0; l2 = 0; l3 = 0; l4 = 0; l5 = 0; l6 = 0;
    }    

    static boolean checkNo (int n){
        if (n == l1) { return false; }
        else if (n == l2) { return false; }
        else if (n == l3) { return false; }
        else if (n == l4) { return false; }
        else if (n == l5) { return false; }
        else if (n == l6) { return false; }
        else {
            return true;
        }
    }    

    static void setNo(){
        called++;
        reset();

        int working = getRand();     

        if ( ((working = getRand()) > 0) && checkNo(working) )  l1 = working;
        if ( ((working = getRand()) > 0) && checkNo(working) )  l2 = working;
        if ( ((working = getRand()) > 0) && checkNo(working) )  l3 = working;
        if ( ((working = getRand()) > 0) && checkNo(working) )  l4 = working;
        if ( ((working = getRand()) > 0) && checkNo(working) )  l5 = working;
        if ( ((working = getRand()) > 0) && checkNo(working) )  l6 = working;

    }


    static int getRand(){
        
        double r = Math.random();
        int n =  (int)((r * 49) + 1); 
        return n;    
    }
}
