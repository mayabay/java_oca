package enthu;
class DataTypesTest1 {

	public static void main(String[] args){
		do2();	

	}

	static void do2(){
		boolean eq = 0.0 == -0.0;
		System.out.println( eq );

		double d = 1.0 / 0; 
		System.out.println( d );	// Infinity
		

	}

	static void do1(){
		Boolean b1 = new Boolean("trUE");
		System.out.println( b1.valueOf( true ) );
		final short s = -42;
		//char c = s;	// DNC incompat char is unsigned
		System.out.println( (char)97 );
		System.out.println( 97 );

		byte b = 1;
		final int i = b;
		//char c = i;	// DNC 18: error: incompatible types: possible lossy conversion from int to char
						// works if b is final too

	}

}
