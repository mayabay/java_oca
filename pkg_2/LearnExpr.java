package pkg_2;
public class LearnExpr {


	public static void main(String[] args){
		
		new LearnExpr().goPrecedence();	
	
		//new LearnExpr().goLeftToRight();	
	
		//new LearnExpr().learnNow();	
	
		//shiftBits();
	}


	void goLeftToRight(){
		
		int x = 3;

		int y = ++x * 5 / x-- + --x;	// evaluation is always left to right   JLS 15.7

		/*
		
		((++x) * 5 ) / (x--)
		(					) + (--x)



		*/

		// x -> 4
		// 4 * 5  = 20	, x = 4
		// 20 / 4 = 5	, x = 3
		// 5 + ( 3-1 )	, x = 2
		// 5 + 2 = 7 

		// https://coderanch.com/t/712850/certification/Operator-Precedence-Error-OCA-SE

		// Operator precedence does not determine order of evaluation. 
		// Operator precedence only determines which operand goes with which operator.

		System.out.println( "y = " + y  );


	}

	void learnNow(){
	
		// Operator Precedence in Java
		// https://introcs.cs.princeton.edu/java/11precedence/

		int x = 5;
		int y = 10;
		int z = ++x * y--;
		/*
			(++x) 	* 	(y--)
			(6)		*	(10)
		*/
		System.out.println( "z = " + z + ", y = " + y  );


	}

	void goPrecedence(){

		int e = 3;
		int d = 8;
		
		int f = d % e + 2 + ++e;

		//System.out.println( "f = " + f  );

		// ------------------------------------------

		int a = 1;
		int b = 2;
		int c = 3;
		
		
		int r1 = c * b 	+ a++ % a;

		// 		( 6 )	+ ( 1 % 1 )
		//		  6     + 	1

		int r2 = 7 % 2;		// 1
		
		System.out.println( "r1 = " + r1  );	// 7
		
		// ------------------------------------------


		a = 1; b = 2; c = 3;
		
		double r3 = c * b + a++ % a + c / 4;
		
		System.out.println("1 % 3 = "  +  1 % 3  );
	
		
		//				6 + 1	 	
	
		System.out.println("r3 = " + r3 );	// 7.0

        //System.out.println( 20 * 4 % 2  );    // 80 % 2 = remainder = 0


	}

	void goPrec2(){
	
	}


	static void shiftBits(){
		
		System.out.println(  (byte) (-18 >>> 1) );

		System.out.println( 18 << 1  );


	}
}
