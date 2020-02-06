package pkg_2;
public class Loops {

    static int counter;

    public static void main(String[] args){
        //forLoop1();
        //whileLoop();
        //foreachLoop();
        nestedLoop();
    }


    static boolean doItAgain(){
        
        if (counter > 9){
            return false;
        }else{
            return true;
        }
    }

    static void whileLoop(){

        while( Loops.doItAgain() ){
            counter++;
        }
        
        System.out.println( "counter = " + counter );

    }

    static void forLoop1(){
        boolean go = true;    
        // inside init block
        // System.out.println("init!") ;    // ok
        //  do{ ; }while( go = false )      // DNC : error: illegal start of expression
        for (; go ; go = Loops.doItAgain() )
            counter++;
        
        System.out.println( "counter = " + counter );


    }



    static void forLoop(){
        
       // --
         
       //for(;;);  // endless loops; stmts after produce DNC unreachable
    
        for(;;){
            System.out.println( "bla" );
            break;
        }

        for( int i = 0; i < 5;  ){
            System.out.println( i );
            i++;
        }

        int i;
        for(i=1; i++ < 5;);
        System.out.println( "i = " + i );


    }
    

    static void foreachLoop(){
        int[] ints = { 1,2,3,4 };

        for(int i : ints){
            
           if ( i % 2 == 0 ){
                System.out.println( i + " is an even number" );


           } 
        }

        int[] intis = {1,2,1,2,1,2,1,2};
        label1: for ( int i : intis ){
                    if ( i == 2 ){
                        continue label1;
                    }   
                   System.out.println( i );
                } 
    }


    static void nestedLoop(){
        int[] ints = { 1,2,3,1,2,3,1,2,3 };
        int counter = 0;
        outer: for (int i = 0; i < ints.length; i++){
             System.out.println( "i = " + i);
 
             inner: for (int j = 0; j < ints.length; j++){
                if ( ints[j] == 3) continue outer;
                System.out.println("\t\t" + ints[j] );
                counter++;
                  
             }
     
        }
        System.out.println( "count = " + counter );

    }


    static int labels(){
        
        int x = 5;  // var declar cannot be labeled

        label: while( x < 10 ){
            label1: if (x > 8) break label;
            label2: x++;           
        }
    
        label: {
            if (true) break label;       
        }


        if (true){
            //break;  // DNC 129: error: break outside switch or loop
        }

        label: return 0;
    }


}
