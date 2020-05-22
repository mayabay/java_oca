package hanu_5;
class OperatorsTest1 {

	public static void main(String[] args){
		//doEquality();
		//doBitShift();
		//doExpr();
		//doUnary();
		doNumericPromo();


	}

	/*
	 * U M A R E L S A
	 * */

	static void do1(){
		int a = -10;
		int c = +a;		// c is -10		unary plus will not change the sign 

		System.out.println(  + (-10)  );	// -10
		System.out.println(  - (-10)  );	// 10

		boolean iAmHungry = false;
		boolean fridgeHasFood = false;
		boolean eatUp = iAmHungry & fridgeHasFood;

		final byte b1 = 4;
		byte b2 = b1;
		byte b3 = (byte)~b2;
		System.out.println(  Integer.toBinaryString( (int)b3 ) );

	}

	static void doEquality(){

		// == !=

		int a = 10, a2 = 42;
		Integer b = 20;
		char ch = 'a';
		double p = 3.14;
		Double pw = p;
		Double d2 = 42.;
		Long l1 = 1L;
		byte by = 8;

		//System.out.println( a == b );		// false	b is unboxed
		
		//System.out.println( ch == 97 );	// true								char == int	
				
		//System.out.println( b == a );		// false							Integer == int
		
		//System.out.println( p == b );		// false 							double == Integer
		
		//System.out.println( pw == b );	// DNC incompat						Double == Integer
		
		//System.out.println( p == new String("moin") );	// DNC incompat		double == String
	
		//System.out.println( d2 == pw );	// false							Double == Double
	
		//System.out.println( l1 == by );	// false

	} 

	static void doBitShift(){
		byte b1 = -4;
		byte b2 = (int) (-4 >> 2);
		System.out.println( b2 );
		System.out.println( Integer.toBinaryString( (int)b2 ) );

		System.out.println( "---" );
		for( int i = -4; i <=0; i++ ){
			System.out.print( " i =  " + i + ", " );
			System.out.print( Integer.toBinaryString( i ) );
			System.out.println(  );

		}
		
		System.out.println( "---" );
		System.out.println( "-128 = " + Integer.toBinaryString( -128 ));


	}

	static void doExpr(){
		int a = 10, b = 20;
		
		a = a + b;
		int c = a = a + b;			// c = a = 50
		System.out.println( c );

	} 

	static void doUnary(){
		int i = 1, pre = 0, post = 0;

		//pre = i++;
		pre = ++i;
		System.out.println( "pre = " + pre + ", i = " + i );
		 
	}

	static void doNumericPromo(){
		byte b = 1;
		short s = (short)-b;

		byte x = 0, y = 2;
		//byte z = x + y;		// DNC incompat
		
		float f = 3.14f;
		
		byte b3 = 1_000_001 - 1_000_000;

		byte b4 = 4;
		byte b5 = ++b4;
		//b5 = -b4;				// DNC incompat
		b5 *= 2;				// b5 is a primitive


		Byte b6 = 1;
		b6 = b6++;
		//b6 *= 2;		// DNC :127: error: incompatible types: int cannot be converted to Byte
								// b6 is a wrappper
		byte b7 = 1;
		b7 *= 2;


	}



}
