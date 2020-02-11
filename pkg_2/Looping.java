package pkg_2;
public class Looping {
	

	public static void main(String[] args){

		do5_12();

	}

	static void test(){
		String[] strings = new String[] { "Rachel", "Ross" };
		strings = new String[] { "Chandler","Monica" };
		String[] moreFriends = { "Joey", "Phoebe" };		
	}


	static void do1(String[] args){
		//for(;;);	// any stmt below is unreachabel
		;
		for(;;){
			if (args.length < 1) break;
		}

		;
		
		try{
			for (;;);
		}
		catch( Throwable t ){					// if catch is commented 
		 										// DNC 40: error: unreachable statement
			System.out.println( "caught!" );

		}
		
		finally{
			System.out.println( "finally" );

		}
		
		System.out.println( "out" );

	}

	static void do2(){
		
		if (false){
			;		// OK is never reached, allowed to debug code
		}

		/*
		while(true);
		;			// DNC 48: error: unreachable statement
		*/

		
		try{
			//for(;;);
			while(true);
			//;				// DNC 59: error: unreachable statement
		}
		catch(Throwable t){
		}
		
		//while(true);
		;
	}

	static void do5_2(){
		short a = 5;

		while (isValid(a)){
			System.out.println( a-- );

		}
	}

	static boolean isValid(int a ){
		return a-- > 0 ? true : false;
	}

	static void do5_14(){
		int a = 0;
		int i = 7;
		for (; i--> 0 ;)
			a++;
		System.out.println( "a = " + a );

	} 

	static void do5_12(){
		int i = 0;
		for(;;) i++;
		/*
		if (i == Integer.MAX_VALUE){			// DNC 94: error: unreachable statement ; if = unreachabe stmt
			System.out.println( "done, i = " + i );
		}
		*/

	}


}
