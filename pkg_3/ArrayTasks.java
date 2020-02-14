package pkg_3;

public class ArrayTasks {

	static int[] arr = { 1,7,9,4,2,8 } ; 
	static int[] arrMinMax = {12,14,-9,7,34,843,23,107,29,40,576};
	
	public static void main(String[] args) {
		doTask60();

	}
	
	static void pa( int[] wurf ){
		for ( int i = 0; i < wurf.length; i++ ) {
			System.out.println("[" + (i+1) + "] " + wurf[i]);
		}		
	}
	
	static void doTask47(){
		int[] wurf = new int[6];
		wurf[0] = 1;
		wurf[1] = 7;
		wurf[2] = 9;
		wurf[3] = 4;
		wurf[4] = 2;
		wurf[5] = 8;
		pa(wurf);
		
	}
	
	static java.util.Random r;
	
	static int getR( int min, int max ) {
		if (r == null) {
			r = new java.util.Random();
		}
		
		int v = 0;
		while (true) {  
			v = r.nextInt(max);
			if ( v >= min ) {
				break;
			}
		}
		return v;
	}

	static void doTask48(){
		pa( new int[] { 1,7,9,4,2,8 } );
	}	

	static void doTask49(){
		int sum = 0;
		for( int i = 0; i < arr.length; i++ ) {
			System.out.print( arr[i] + (i == arr.length-1 ? " " : " + ") );
			sum += arr[i];
		}
		System.out.print( " = " +  sum );
	}	

	static void doTask50() {
		// int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
		for( int i = 0; i < arrMinMax.length; i++ ) {
			if ( arrMinMax[i] < min  ) {
				min = arrMinMax[i]; 
			}
			if ( arrMinMax[i] > max  ) {
				max = arrMinMax[i]; 
			}			
				
		}	
		System.out.println("min = " + min + ", max = " + max);
	}
	
	static void doTask51() {
		int n = 23, found = 0;
		for( int i = 0; i < arrMinMax.length; i++ ) {
			if ( arrMinMax[i] == n ) {
				System.out.print( "found n = " + n + " at position = " + (i+1)   );
			}
		}
	}
	
	static void doTask52() {
		
		// --
		
		int[] ints = new int[100_000];
		
		for ( int i = 0; i < 100_000; i++ ) {
			ints[i] = getR( 1, 50 );
		}
		
		// --
		
		int[] found = new int[49];
		
		int lottoNr = 0;
		
		outer: for( int i = 0; i < found.length; i++  ) {
			lottoNr++;
			//System.out.println(".. looking for " + lottoNr);
			int count = 0;	// i found count times
			inner: for ( int j = 0; j < ints.length; j++ ) {
				if ( ints[j] == lottoNr ) { count++; }
			}
			found[i] = count;
		}
		
		// --
		for ( int i = 0; i < found.length; i++ ) {
			int l = i+1;
			System.out.println( "[ "+ l +" = "+ found[i] +" ]" );
		}
	}
	
	static void doTask53() {
		int[] arr53 = {1, 16, 23, 99, 153, 683, 987, 993, 998};
		int[] rev = new int[arr53.length]; int idxUp = 0;
		
		for( int i = arr53.length-1; i >= 0; i-- ) {
			rev[ idxUp ] = arr53[i]; idxUp++;
		}
		pa(rev);
	}
	
	static void doTask54() {
		
		int[] fibonacci = new int[30];

		int a = 0, b = 1, next = 0;
		
		for ( int i = 2; i < 30; i++ ) {

			next = a + b;
			a = b;
			b = next;
			
			fibonacci[i] = next;
		}
		
		pa(fibonacci);
	}
	
	static void doTask60() {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int[] a , b, r;
		a = new int[100]; b = new int[100]; r = new int[100];
		
		for ( int i = 0; i < 100; i++ ) {
			a[i] = getR( 1,9 );
			b[i] = getR( 1,9 );
			r[i] = a[i] * b[i];
		}
		
		int countFalse = 0;
		game: for ( int i = 0; i < 100; i++ ) {
			System.out.println(a[i] + " * " + b[i] + " = "  ); 
			int input = sc.nextInt();
			if ( input == 0 ) break game;
			if ( input != r[i] ) { countFalse++; }
		}
		 
		System.out.println("You entered " + countFalse + " false answer" + ( countFalse > 0 ? "64s." : "." ) );
	}
}
