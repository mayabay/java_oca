package hanu_7;
class WhileTest1 {
	
	public static void main(String[] args){
		do3();
	}

	static void a(){}

	static void do3(){

		//new String[] {"A", "B"};		// DNC not a statement 
		new Object();
		//new String[0];				// same
		new WhileTest1();


		boolean b = false;
		for(int i = 0 ; b = !b ; i = 42, a(),  new WhileTest1()){
			System.out.println( "A" );
			break;
		}
	}

	static void do2(){
		
		for ( int i = 4 ; i > 0; i-- ){
		}
		//System.out.println( "i = " + i );

		int i = 42;

	}

	static void do1(){
		int i = 4, j = 4;;
		do
			System.out.println( "i = " + i );	
		while ( --i > 0 );
		// i-- 4 3 2 1 0
		// --i 4 3 2 1


		for ( ; j > 0; --j ){
			System.out.println( "j = " + j );	
		}
		// j-- 4 3 2 1
		// --j 4 3 2 1

	}

}
