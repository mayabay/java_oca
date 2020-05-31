package enthu;
class BreakContTest1 {

	public static void main(String[] args){
		do1();
	}

	static void do1(){
		
		if(1>0){
			
			System.out.println( "A" );
			//break;	//DNC 13: error: break outside switch or loop
		}

		go1: {
			int n = 42;	 
			switch (n){
				case 42: System.out.println( "1" ); 
						 //break go1;	// OK goes to B
						 //break go;	// DNC 21: error: undefined label: go
						break go3;

			}

			System.out.println( "unreachable" );

		}

		go: System.out.println( "B" );

	}






}
