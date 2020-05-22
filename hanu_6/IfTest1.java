package hanu_6;
class IfTest1 {
	
	public static void main(String[] args){

		int i = 43;
		
		if (i == 42);
		else {
			System.out.println( "A" );
			System.out.println( "B" );

		};
		{
			// code block
			int b = 43;
		}

		// ---
		int value = 3;
		if(value == 0)
			if(value == 1) 
				System.out.println("b");
			else 
				System.out.println("c");

		// ---
		int answer = 42;

		if ( (answer = 43) > 42 )
			System.out.println( "xx" );


		// ---
		int x = 0;
		
		if(x++ > 0){ //line 2
			x--; //line 3
		} 
		
		if (++x == 2){ //line 6
			x++; //line 7
		}
		System.out.println(x);

		// --
		int a = 2, b = 2; 
		//int d = a == b ? 42 : 10. ;		// DNC incompat 
		


	}
}
