package pkg_3;
import java.util.*; 
public class LearnArrays {

    // arr declaration, object ref points to null
    static String[] strings;

    // arr of zero size
    String[] inString = new String[0];


    static void pa( int[] iarr){
        if ( iarr == null ){
            System.out.println( "array does not exist!" );
            return;
        }
        for( int i = 0; i < iarr.length; i++ ){
            System.out.print( "[ " + iarr[i] + " ]" );
        }
        System.out.println( "-" );

    }

    public static void main(String[] args){
        do3(); 
    }

    static void do3(){
        int n = 3, arr11[][] = { {1,2},{3,4,5} };
        //pa( arr11 );      // DNC 28: error: incompatible types: int[][] cannot be converted to int[]
        //pa( arr11[0] );       // 1,2
        pa( arr11[1] );         // 3,4,5

        int[] a4D[][][] = new int[2][][][];
        a4D[0][0][0] = new int[] { 1,2,3 };
        pa( a4D[0][0][0] );   // DNC 35: error: incompatible types: int[][][] cannot be converted to int[]


        int[] arr = {1,2,3,4};
        //System.out.println( Arrays.toString( arr ) );

       
    }


    static void do2(){
        int [] arr[] = new int[4][2];

        arr[3][1] = 42;
        arr[0][0] = 1;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print( arr[i][j]  + " ");

            }
            System.out.println(  );

        }


        int threeD[][][] = new int[2][][];

        int[][] a2D = new int[][] {{1},{2}};

        threeD[1] = a2D;

        int[] a3D1[][] = new int[2][][];
        
        
        int[] a3D2[][] = { {},{} };

        int[] a3D3[][];
        a3D3 = new int[][][]{ { { 1,2,3 } },{} };
        pa( a3D3[0][0] );

    }


    static void do1(){

        int arr1 [];
        int[] arr2 = new int[3];
        int arr3[] = { 1,2,3,4 };
        char[] carr = new char[2];

        System.out.println( arr2[2] );      // default value = 0
        System.out.println( carr[0] );      // defaults to 'u0000'


        LearnArrays la = new LearnArrays();
        //System.out.println( la.inString[0] );   // AIOOBE, their is no element at idx 0

        Integer[] intArr = { 1, new Integer(1), null };
        Boolean[] boolArr = new Boolean[4];     
        System.out.println( boolArr[0] );       // null


        int [] twoDarr [] = { {1,2},{3,4} };

        int [] twoDarr2 [] = new int[][] { {1,2},{3,4} };

        int [] threeDarr [][] = new int[][][] { {{1},{1,2,3,4,5}},{{6,7},{8,9}} };

        int [] threeDarr2 [][] = { {{1},{1,2,3,4,5}},{{6,7},{8,9}} };

        int [][] threeD3 [] = {};

        // barr1 1D arr decl with init+values
        // barr2 1D arr decl with init
        // barr3 1D arr decl
        byte[] barr1 = {1,2,3}, barr2 = new byte[3], barr3[][];   

        // sarr1 short var decl
        // sarr2 2D short arr decl
        // saar3 2D short arr decl with insta anon
        // saar4 2D short arr decl with insta + values
        short sarr1, saar2[][], saar3[] = new short[] {1,2,3}, saar4 [][] = { {1,2},{3,4} };

        int string [][][][][][][][][][][];      // 11D int arr

    }

}
