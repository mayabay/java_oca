package pkg_4;

public class LearnPassByValue{

	String s = "Hello World";

	Integer x = 5;

	public static void main(String[] args){
		
		LearnPassByValue passByValue = new LearnPassByValue();

		// call	
		passByValue.changeIt( passByValue.s );
		
		System.out.println( passByValue.s );	// Hello World

		// call
		Integer value = passByValue.wiggler( passByValue.x );
		
		System.out.print( passByValue.x + value );	// 620


	}

	// enthu 1174
	void changeIt (String s){
		s = "Good Bye";
	}


	/*
1. Wrapper objects are always immutable. Therefore, when dataWrapper is passed into wiggler() method, 
it is never changed even when x++; is executed. However, x, which was pointing to the same object as dataWrapper, 
is assigned a new Integer object (different from dataWrapper) containing 6.  

2. If both the operands of the + operator are numeric, it adds the two operands. 
Here, the two operands are Integer 5 and Integer 15, so it unboxes them, adds them, and prints 20.
	 * */
	// enthu 1027
	int wiggler( Integer i ){
		
		Integer y = i + 10;
		
		i++;		// changes object behind 
		
		System.out.print( i );
		
		return y;

	}


}
