package hanu_8;
class FinalVarTest1 {

	static {
		printN();
		n = 42;
		//System.out.println( n ); // DNC 6: error: illegal forward reference
		printN();
	}

	private static final int n;


	static void printN(){
		System.out.println( n );
	}

	
	public static void main(String[] args){
		printN();
	}

}
