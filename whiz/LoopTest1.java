package whiz;
class LoopTest1{

	static int x = 10;

	public static void main(String[] args){
		do2();
	}

	static void do2(){
		//final int x; x = 0; // DNC constant expression required
		final int x = 0;
		final int y = 2;
		switch(x){
			case x: { System.out.println( "A" );}
			case 1: System.out.println( "B" );
			default: System.out.println( "default" ); break;
			case y: System.out.println( "C" );		 
		}
	}

	static void do1(){

		for(x = 1; x < 3; x++ ){
			System.out.print( x );
		}

		System.out.println( x );


		final int n;
		n = 42;
	}
}
