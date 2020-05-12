package pkg_2;
class DeclareAndInit{

	public static void main(String[] args){
		do3();
	}

	static void do1(){
		//int i = j = k = 10;	// DNC 6: error: cannot find symbol 
		int i, j, k = 10, l = 42;
		i = j = k = l = 0;

		int val;

		final int n = 0;
		if ( n == 1 ){
			//val = 42;
		}else if ( n == 2 ){
			// bla
		}else if (n == 0){
			val = 42;
		}
		System.out.println( val );

	}

	static void do2(){
		int val = 3;
		//int val;

		final int c1 = 42;
		int c2 = 24;

		switch ( 42 ){
			case 1:;
			case 2:;
			case c1: val = 242;
		}	

		/*
		final boolean bool = true;
		if (bool)
			val = 42;
		*/

		System.out.println( val );

	}

	static void do3(){
		int val;
		int i = 0;

		if ( i == 0 ){
			val = 42;
		}else{
			val = 24;
		}
			
		System.out.println( val );
	


	}

}
