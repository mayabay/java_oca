/*
 * LearnPearmu
 * https://en.wikipedia.org/wiki/Heap%27s_algorithm
 *
 *
 * */package pkg_2;
public class LearnPermu {

    static int swaps;
    static int permutations;

    public static void main(String[] args){
   
        // Collection c containing 4 elements
        // n = 4
        
        //int[] arr = { 1,2,3,4 };                        // 24
        char[] arr = { 'J','a','v','a' };                 // 24 
        //char[] arr = { 'R','G','B' };                   // 6
        //char[] arr = { 'A','n','d','r','e','a','s' };   // 5040

        System.out.println( "--------------------" );


        heapsWay(arr);
        System.out.println( "swaps = " + swaps );

    }

    static void heapsWay( char[] arr ){
    
        int n = arr.length;
        
        generate( (n), arr );

    }

    static void generate( int k, char[] arr ){
    
        if (k == 1){
            printA(arr);
        }
        else{
            
            generate( (k-1), arr );

            for (int i = 0; i < k - 1; i++ ){
                if ( k % 2 == 0 ){
                    // even
                    swap(arr,i,(k-1));
                }
                else{
                    // odd
                    swap(arr,0,(k-1));
                }
                
                generate( (k-1), arr );

            }

        }


    }

    static void printA(char[] arr){
        permutations++;
        System.out.print( permutations +  ".  \n\t" );

        for(int i = 0; i < arr.length; i++){
            System.out.print( " ["+ arr[i] +"] " );
        }
        System.out.println(  );

    }


    static void swap (char[] arr, int k, int l){
        char tmp = arr[k];
        arr[k] = arr[l];
        arr[l] = tmp;
        swaps++;
    }










}
