package enthu;
class TestClass2{



	public static void main(String[] args){
		do3();
	}

	static void do1(){
		StringBuffer buf = new StringBuffer("Andreas");

		buf.setLength(4);

		System.out.println( buf );	// Andr

		buf.setLength(7);

		System.out.println( buf );	// Andr

	}

	static void do2(){
		int a = 'a';
		System.out.println( a );

	}

	static void do3(){
		int c = 0;
		labelA: for( int i = 0; i < 2 ; i++ ){
			labelB: for( int j = 0; j < 2; j++ ) {
				labelC: for( int k = 0; k < 3; k++ ){
					c++;
					System.out.println( "# " + i + " " + j + " " + k + " | c = " + c );

					if ( k > j ) break labelC;
				}
				//System.out.println(  );
			}

			//System.out.println(  );
		}

	}

}
