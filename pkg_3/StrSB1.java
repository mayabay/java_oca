package pkg_3;
public class StrSB1{
	
	public static void main(String[] args){
		doStr();
	}

	static void p(CharSequence c){
		for ( int i = 0; i < c.length(); i++ ){
			System.out.print( "[ " + i  + ( i>9 ? " ] ": " ] ")  );
		}
		System.out.println(  );

		for ( int i = 0; i < c.length(); i++ ){
			System.out.print( "[ "+ c.charAt(i) +"" + ( i>9 ? "  ] ": " ] " ) );
		}
		System.out.println(  );
	}	

	static void doStr(){
	
		StringBuilder sb1 = new StringBuilder("Monica Geller"); 

		String str1 = new String( "Rachel Green" );
	
		// ---
		 
		p(str1);

		System.out.println( str1.substring(0, str1.length()) );	// Rachel Green
		
		System.out.println(" 1, 1 -> " +  str1.substring(1, 1) );	// nothing

		System.out.println(" 1, 2 -> " + str1.substring(1, 2) );	// a

		System.out.println(" 1, 6 -> " + str1.substring(1, 6) );	// achel

		System.out.println( str1 + null );	// Rachel Greennull


		// ---
		System.out.println( "-------------------------------------------------------------------" );

		p(sb1.toString());		// sb1 has 13 chars

		sb1.replace( 7,sb1.length(),"Green" );	// replaces Geller with Green
		System.out.println( sb1 );				// sb1 has 12 chars
		
		p(sb1.toString());

		sb1.append("Green").append("Green");
		
		p(sb1.toString());
		
		sb1.delete(12,sb1.length());
	
		p(sb1.toString());

	    //sb1.append(null);		// DNC 59: error: reference to append is ambiguous

		//sb1.delete(7, 12);		// OK -> last index is 11

		sb1.delete(7,123);			// ok -> end can extend last index
		p(sb1.toString());

		sb1.delete(7,123);			// start can be 7 (one after 6), cannot be 8
		//sb1.delete(8,123);		// last index is 6 // SIOOB



	}
}
