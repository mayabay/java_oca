package kb;
class Ex2_Q20 {


	private static final Integer I1 = 42;
	private static final int i2 = 4;


	public static void main(String[] args){
		
		Integer x1 = 12;
	
		final String str1 = "ho"; 

		switch( "ho" ){

			case str1: System.out.println( "ok" );
 
		}

		switch(x1){
			case 5: System.out.println( "a" );
			case i2: System.out.println( "b" );
			//case I1: System.out.println( "c" );		// DNC error: constant expression required
			

		}

	}
}
