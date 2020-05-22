package hanu_8;
class OverloadTest1 {

	public static void main(String[] args){
		int i = 42;
		short s = 43;
		//doStuff( i, s );			// DNC 7: error: reference to doStuff is ambiguous
	
		byte by = 10;
		//eatChar(b);					// DNC java:10: error: cannot find symbol
		
		char ch = 97;
		//eatByte( ch );		// DNC incompat
		
		//numEater( by );		// 2
		
		objEater( 'a' );		// A

		//objEater( "a,b,c" );	// B


		
	}

	static void doStuff( Integer i, short s ){
		System.out.println( "1" );

	}

	static void doStuff( int i, Short s ){
		System.out.println( "2" );

	}

	static void eatChar( char ch ){
	}


	static void eatByte( byte by ){
	}



	static void numEater(  Byte by  ){ System.out.println( "1" ); }
	
	static void numEater(  short sh  ){ System.out.println( "2" ); }

	static void numEater(  byte ... by  ){ System.out.println( "3" ); }


	static void objEater( Object obj ){ System.out.println("A"); }

	static void objEater( Character obj ){ System.out.println("CH"); }

	static void objEater( String obj ){ System.out.println("B"); }
	
	static void objEater( CharSequence obj ){ System.out.println("C"); }

}
