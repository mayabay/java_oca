package pkg_2;
public class LoopTasks{


    public static void main(String[] args){
        //task31();
        //task31b();
        task34();
    }

    static void task26(){
        for ( int i = 0; i <= 9; i++ ){
            int n = i;
            System.out.print( (n + 1) + ( i < 9 ? ", " : "" ) );

        }
    }

    static void task27(){
        int sqrSum = 0;

        for (int i = 1; i <= 40; i++ ){
            // 
            int sqr =  i * i;
            sqrSum += sqr;
            System.out.print( sqr + ", " );

        }
        System.out.println( "sqrSum = " + sqrSum );

    }

    static void task28(){
       
        System.out.println( "x      x(2)    x(3)" );


        for( int i = 1; i <= 7; i++ ){
            System.out.println( i + "\t" + ((i*i)) + "\t" + (i*i*i)  );

        }

    } 

    static void task29(){

        for ( int i = 0; i <= 9; i++ ){
            int n = i;
            System.out.print( (n + 1) + ( i < 9 ? ", " : "" ) );

        }
    }

    static int getRand(){
        return (int) ((Math.random() * 6) +1 );
    }

    static void task30(){
        boolean sixIsFound = false;
        int n = 0;
        for( ; !sixIsFound ; ){
            n = getRand();
            if ( n == 6 ){
                System.out.println( "yeah!!" ); 
                break;
            }else{
                System.out.println( "oh no, its a " + n  );
            }  
        }
    }


    static void task31(){
        for( int i = 1; i <= 10; i++ ){
            System.out.print( " x " );

            for ( int j = 0; j < 10; j++ ){
                System.out.print( "x " );

            }
        
            System.out.println( "" );
        }
    }


    static void task31b(){
        for( int i = 1; i <= 10; i++ ){
            for( int j = 1; j <= 10; j++ ){
                //boolean writeNL = false;
                System.out.print( " x " );

                if ( j % 5 == 0 ){
                    if ( j != 5 ){
                        System.out.print( "\n" );

                    }
                }

            }
        }
    }

    static void task32(){
        
        int n = 8;
        for ( int i = 1; i <= n ; i++ ){
            System.out.print( i + ": "  );
            int i2 = i;
            for ( int j = i2; j >= 0; j-- ){
                System.out.print( j + " " );
            }

            System.out.println( "" );

        }
    }

    static void task33(){
        int cols = 0;
        for( int c = 32; c <= 255; c++ ){
            
            Character charObj = (char)c;

            String val = "" + c;
            if (c < 10) val = "00" + c;
            if (c >=10 & c <= 99) val = "0" + c;

            System.out.print("    " + val + " = " + charObj + "    "  );
            cols++;
            if ( cols == 6 ) {
                cols = 0;
                System.out.println( "" );

            }
        } 
    }


    

    static void task34(){

        int n = 4;
        
        int[][] set;

        int[] arr = { 1,2,3,4 };

        System.out.println( " ------------------------------------------ " );

        printSeq(arr);

        // https://en.wikipedia.org/wiki/Permutation

        System.out.println( " ------------------------------------------ " );
        
        // step 1
        int idxMax = arr.length -1;

        int k = (idxMax - 1) - 1;       // k    a[2]
        int l = (idxMax - 1);           // l    a[3]

        int[] rarr = new int[ arr.length ]; 
        rarr = getNextSeq( arr, k, l );
        printSeq( rarr );       

        rarr = getNextSeq( rarr, k, l );
        printSeq( rarr ); 

        rarr = getNextSeq( rarr, k, l );
        printSeq( rarr );       










    }

    static void printSeq( int[] arr ){
        for( int i = 0; i < arr.length; i++ ){
            System.out.print( " [ "+ arr[i] +" ] "  );
        }
        System.out.println( "" );

    }

    static int[] getNextSeq(int[] arr, int k, int l ) {
        
        int [] rarr = new int[arr.length];
        
        for( int i = 0; i < arr.length; i++ ){
            rarr[i] = arr[i];
        }

        rarr[k] = arr[l];
        rarr[l] = arr[k];

        return rarr;
    }   



}

