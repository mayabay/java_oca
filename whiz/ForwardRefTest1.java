package whiz;
class ForwardRefTest1{

	static {
		//x = 10;
		y = 5;						// assignment ok
		//System.out.println( y );	// error: illegal forward reference

	};

	//final int x;
	final static int y;
	
	public static void main(String[] args){
		System.out.println( 013 );
		
		Double d1 = 0.0 / 0.0;	
		System.out.println( d1 );	// NaN
		
		//Integer i1 = 12 / 0;	// RTE java.lang.ArithmeticException: / by zero



	}
}
