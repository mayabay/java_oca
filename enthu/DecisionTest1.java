package enthu;
class DecisionTest1 {

	static {
		System.out.println( "loading .." );
	};

	{
		System.out.println( "inst coming .." );

	};

	public static void main(String[] args){
		DecisionTest1 d1 = new DecisionTest1();
		do4();
	}

	static void do4(){
		int i1 = 1;
		Byte b1 = 1;
		System.out.println( i1 == b1 );						// true

		Object obj = new Object();
		String hello = "hello";

		System.out.println( obj instanceof Iterable );		// false
		//System.out.println( "hello" instanceof Iterable );	
					// DNC error: incompatible types: String cannot be converted to Iterable
		//System.out.println( hello instanceof Iterable );
					// same

		





	}

	static void do3(){
		final Character c = 'y';			
		int n = 0;

		switch( new Character('a')) {
			case 98: n += 1;
			default: n -= 2;
			case 99: n += 3; 
			case 100: n += 4;
			//case c: System.out.println( "y" );	// DNC	27: error: constant expression required
		  
		}

		System.out.println("n = " + n );

	}

	static void do2(){
		final Integer i = 12;
		//switch  ( new Integer( 41+2) ){			// no unboxing here
		switch(41+2){
			case (char)42: System.out.println( "42" );
			case (int)43L: System.out.println( "43" );
			//case i:  System.out.println( "12" ); // wrapper not allowed here
			default: 
		}



	}


	static void do1(){
		if (returnTrue()){
			System.out.println( "reachabel?" );
	
		}

		for( int i = 9, x = 42; i >= 0; System.out.println("# " + --i) ){
			System.out.print(x);
			continue;
			//returnTrue(); // DNC unreachable
		}

		//System.out.println( "i = " + i + ", x = " + x );
				// DNC error: cannot find symbol
	
		char c = 97;

		do{
			int n = 120;	
			System.out.print( c++ );
		}
		while ( c < 120 );		// n is not visible here


		boolean b = false;
		if ( b = true ){
			System.out.println( "works" );
		}

	}

	static boolean returnTrue(){ return false; } 

}
