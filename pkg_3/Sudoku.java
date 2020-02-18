package pkg_3;

import java.util.Arrays;

public class Sudoku {

	private static 	int[][]	game = new int[9][9];  

	private static 	java.util.Random r;		
	
	// all rows
	private static int[] r0 = new int[9];
	private static int[] r1 = new int[9];
	private static int[] r2 = new int[9];
	private static int[] r3 = new int[9];
	private static int[] r4 = new int[9];
	private static int[] r5 = new int[9];
	private static int[] r6 = new int[9];
	private static int[] r7 = new int[9];
	private static int[] r8 = new int[9];
	
	// all columns
	private static int[] c0 = new int[9];
	private static int[] c1 = new int[9];
	private static int[] c2 = new int[9];
	private static int[] c3 = new int[9];
	private static int[] c4 = new int[9];
	private static int[] c5 = new int[9];
	private static int[] c6 = new int[9];
	private static int[] c7 = new int[9];
	private static int[] c8 = new int[9];
	
	// current block, we are filling up
	private static int[] workingBlock = new int[9];
	
	// times a value is calculated
	private static int getValCount = 0;
	
	// ------------------------ ------------------------
	
	
	
	public static void main(String[] args) {
		p();
		init();
		p();
		play();
	}

	static void resetWorkingBlock(){
		for ( int i = 0; i < workingBlock.length; i++ ) {
			workingBlock[i] = 0;
		}
	}
	
	static void init() {
		
		// b1
		setBlock( 0,0,2,2 );
		// b2
		setBlock( 0,3,2,5 );
		// b3
		setBlock( 0,6,2,8 );
		
		// b4
		setBlock( 3,0,5,2 );
		// b5 
		setBlock( 3,3,5,5 );
		// b6
		setBlock( 3,6,5,8 );
		
		// b7
		setBlock( 6,0,8,2 );
		// b8
		setBlock( 6,3,8,5 );
		// b9
		setBlock( 6,6,8,8 );
	}
	
	static void p() {
		
		for ( int i = 0; i < game.length; i++ ) { System.out.print( i + " " ); }
		System.out.println();
		for ( int i = 0; i < game.length; i++ ) { System.out.print( "- " ); }
		
		System.out.println();
		
		rows: for( int i = 0; i < game.length; i++ ) {
			
			cols: for( int j = 0; j < game[i].length; j++ ) {
				System.out.print( game[i][j] + " " );
			}
			
			System.out.println( " | " + i + "" );
		}
		
		System.out.println();
	}
	
	static void setBlock( int r1, int c1, int r2, int c2 ) {
		
		System.out.println( "setBlock() .. ------------------------" );
		
		resetWorkingBlock();
		
		for( int i = r1; i <= r2; i++ ) {
			for ( int j = c1; j <= c2; j++ ) {
				System.out.println("setting game i = " + i + ", j =  " + j );
				int v = getValue( i, j );	// get value for field
				game[i][j] = v;
			}
		}
	}
	
	static void play() {
		
	}
	
	// get a unique value fr this block, row and col
	static int getValue ( int r, int c ) {
		
		try{
			Thread.sleep(400);	
		}
		catch( InterruptedException iex ) {
			iex.printStackTrace();
		}
		
		
		getValCount = 0;
		
		boolean valueNotFound = true;
		
		int v = 0;
		
		FindValueLoop: while(valueNotFound) {
			
			v = getR(1,9);
			
			System.out.println("\t ... ( "+ v +" )");
			
			getValCount++;
			if (getValCount > 1024) {
				p();
				System.exit(0);
			}
			
			boolean validInBlock = false;
			boolean validInRow = false;
			boolean validInCol = false;
			
			if ( uniqueInBlock(v) ) { validInBlock = true; System.out.println("\t\t validInBlock"); }
			if ( uniqueInRow(v,r) ) { validInRow = true; System.out.println("\t\t validInRow"); }
			if ( uniqueInCol(v,c) ) { validInCol = true; System.out.println("\t\t validInCol"); }
			
			if ( validInBlock & validInRow & validInCol ) { 

				// remember valid v in working block
				setUsedVal(v, workingBlock );
				// remember in row array
				switch( r ){
					case 0:  setUsedVal( v, r0 ); break;
					case 1:  setUsedVal( v, r1 ); break;
					case 2:  setUsedVal( v, r2 ); break;
					case 3:  setUsedVal( v, r3 ); break;
					case 4:  setUsedVal( v, r4 ); break;
					case 5:  setUsedVal( v, r5 ); break;
					case 6:  setUsedVal( v, r6 ); break;
					case 7:  setUsedVal( v, r7 ); break;
					case 8:  setUsedVal( v, r8 ); break;
				}		
				// remember col
				switch( c ){
					case 0:  setUsedVal( v, c0 ); break;
					case 1:  setUsedVal( v, c1 ); break;
					case 2:  setUsedVal( v, c2 ); break;
					case 3:  setUsedVal( v, c3 ); break;
					case 4:  setUsedVal( v, c4 ); break;
					case 5:  setUsedVal( v, c5 ); break;
					case 6:  setUsedVal( v, c6 ); break;
					case 7:  setUsedVal( v, c7 ); break;
					case 8:  setUsedVal( v, c8 ); break;
				}				

				// ok exit while
				valueNotFound = false; 
			}
		}
		
		System.out.println( "getValue(r = "+ r +" c = "+ c +" ) v = " + v );
		System.out.println( "\t getValCount = " + getValCount);
		return v;
	}
	
	static boolean uniqueInRow( int n, int r ) {
		switch( r ){
			case 0: return uniqueInArr( n, r0 );
			case 1: return uniqueInArr( n, r1 );
			case 2: return uniqueInArr( n, r2 );
			case 3: return uniqueInArr( n, r3 );
			case 4: return uniqueInArr( n, r4 );
			case 5: return uniqueInArr( n, r5 );
			case 6: return uniqueInArr( n, r6 );
			case 7: return uniqueInArr( n, r7 );
			case 8: return uniqueInArr( n, r8 );
		}
		return false;
	}

	static boolean uniqueInCol( int n, int c ) {
		switch( c ){
			case 0: return uniqueInArr( n, c0 );
			case 1: return uniqueInArr( n, c1 );
			case 2: return uniqueInArr( n, c2 );
			case 3: return uniqueInArr( n, c3 );
			case 4: return uniqueInArr( n, c4 );
			case 5: return uniqueInArr( n, c5 );
			case 6: return uniqueInArr( n, c6 );
			case 7: return uniqueInArr( n, c7 );
			case 8: return uniqueInArr( n, c8 );
		}
		return false;
	}	
	
	static void setUsedVal( int n, int[] arr ) {
		for (int i = 0; i < arr.length; i++) {
			if ( arr[i] == 0 ) { arr[i] = n; break; }
		}		
	}	
	
	static boolean uniqueInArr( int n, int[] arr ) {
		for( int i = 0; i < arr.length; i++ ) {
			if ( arr[i] == n ) return false;
		}
		//System.out.println( Arrays.toString(arr) );
		return true;
	}

	static boolean uniqueInBlock( int n ) {
		for (int i = 0; i < 9; i++) {
			if (workingBlock[i] == n) {
				return false;
			}
		}
		//System.out.println( Arrays.toString(workingBlock) );
		return true;
	}
	
	static int getR( int min, int max ) {
		if (r == null) {
			r = new java.util.Random();
		}
		
		int v = 1;
		while (true) {  
			v = r.nextInt((max+1));
			if ( v >= min ) {
				break;
			}
		}
		return v;
	}	
	
}
