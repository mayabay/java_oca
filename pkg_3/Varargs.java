package pkg_3;

public class Varargs {

	public static void main(String[] args) {
		int[] arr = { 9,8,7 };
		// useVarargs( arr );	// OK
		// useVarargs( 9,8,7 );	// OK
		// useVarargs( );	// OK
		
		//useVarargs(  );     // DNC 11: error: reference to useVarargs is ambiguous

        //useVarargs( null, null );     // OK
		
        //useVarargs( 1, null, null );  // OK

        useVarargs( 1, 2, 3 );  // DNC 17: error: reference to useVarargs is ambiguous

        useVarargs("str", 2,3,4);
	}

	static void _useVarargs( int ... ints ){
		System.out.println("1");
		for ( int i : ints ) {
			System.out.println(i);
		}
		
	}

	static void useVarargs(String str,  int ... ints ){
		System.out.println("4, str =  " + str);
		for ( int i : ints ) {
			System.out.println(i);
		}
		
	}

	static void useVarargs(int n,  int ... ints ){
		System.out.println("3, i =  " + n);
		for ( int i : ints ) {
			System.out.println(i);
		}
		
	}

	static void _useVarargs( Object ... objs ){
		System.out.println("2");
		for ( Object obj : objs ) {
			System.out.println( obj );
		}
		
	}	
	
	
	
}
