package hanu_8;
class InstanceInitTest1{

	{
		System.out.println( "1" );
		//System.out.println( "\tn = " + n );
		printVal();	// n = 0
		n = 12;
		//int i = n;		// DNC 7: error: illegal forward reference
		//System.out.println( "n = " + n );	// DNC 8: error: illegal forward reference

		printVal(); // n = 42
	}

	public static void main(String[] args){
		InstanceInitTest1 init = new InstanceInitTest1();
		init.n = 43;

	}

	void printVal (){
		System.out.println( "printVal(): n = " + n );
	}
	

	{
		System.out.println( "2" );
		//System.out.println( "\tn = " + n );
	}

	private int n = 42;

	{

		System.out.println( "3" );
		System.out.println( "\tn = " + n );

	}




}
