package hanu_4;
import java.util.Arrays;
class Exercises {

	public static void main(String[] args){
		do44_5();
	}

	static void do44_1(){
		boolean[] bools = new boolean[3];
		for( boolean b : bools ){  
			System.out.println( b );

		}
	}

	static void do44_2(){
		int[] first = new int[3];
		int[] second = {};
		int[] third = null;
		System.out.println( third.length );

	}

	static void do44_3(){
		char[] chars = { 'A', 'n', 'd', 'i' };

		chars[0] = chars[1];
		chars[1] = chars[2];
		chars[2] = chars[3];
		System.out.println(  Arrays.toString( chars ));

	}

	static void do44_4(){
		String[][] strArr2D = { {"A"},{"B","C"},{"D","E","F"},{"G","H","I","J"} };
		printArray( 0, strArr2D );
	}

	static void do44_5(){
		String [][]names = new String[2][3];
		names[0][0] = "A";
		names[0][1] = "B";
		names[0][2] = "C";
		names[1][0] = "D";
		names[1][1] = "E";
		names[1][2] = "F";
		for( int i = 0; i < names.length; i++ ){
			for( int j = 0; j < names[i].length ; j++ ){
				System.out.println( names[i][j] );
			}
		}

		String[] arr1 = new String[3];
		String[] arr2 = new String[3];

		arr1[0] = names[0][0];
		arr1[1] = names[0][1];
		arr1[2] = names[0][2];
		arr2[0] = names[0][0];
		arr2[1] = names[0][1];
		arr2[2] = names[0][2];

	}

	static void do44_12(){
		int[][][] nums = new int[1][4][2];
		for(int i = 0; i<nums.length; i++){
			for(int j = 0; j<nums[i].length; j++){
				for(int k = 0; k<nums[i][j].length; k++){
					nums[i][j][k] = i + j + k;
					System.out.println("num["+i+"]["+j+"]["+k+"] = "+nums[i][j][k]);
				}		
			}
		}
	}

	static void printArray( int lev,  Object array ){
/*
		if ( array.getClass().isArray() ){

			//Iterable it = array.getClass().cast( new java.util.ArrayList() );
				// DNC error: incompatible types: CAP#1 cannot be converted to Iterablei
				// CAP#1 extends Object from capture of ? extends Object
			//Iterable it = (Iterable)array;	// RTE CCE : [[Ljava.lang.String; cannot be cast to java.lang.Iterable
			for ( Object o : it ){
				printArray( lev++, o);
			}
		}else{
			System.out.print( array );
		}
*/
	}

}

	
