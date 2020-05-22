package pkg_5;
class WrapperTest1 {

	public static void main(String[] args){

		Short s1 = new Short( (short)10 );

		Float f1 = new Float("3.14");

		System.out.println( f1 );

		Float f2 = new Float("3.14");

		//System.out.println( f1 == f2 );	// false

		//System.out.println( Float.valueOf("3.14") == Float.valueOf("3.14") );		// false
		
		Float f3 = Float.valueOf("3.14");
		Float f4 = Float.valueOf("3.14");

		//System.out.println( f3 == f4 );		// false

		System.out.println( Integer.valueOf("42") == Integer.valueOf("42") );


		Long lo1 = 100L;
		Long lo2 = 100L;

		//System.out.println( lo1 == lo2 );	// true

		Boolean bo1 = true;

		Boolean bo2 = true;

		//System.out.println( bo1 == bo2 ); // true

		

	}

}
