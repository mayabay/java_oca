package whiz;
import java.util.*;
class FreeTest {

	public static void main(String[] args){
		do3();
	}

	static void do1(){

		Double number = Double.valueOf("3.14D");
		System.out.println( number );

		Integer i1 = Integer.valueOf("3.14");
		System.out.println( i1 );	// RTE LOC 8 java.lang.NumberFormatException: For input string: "3.14"
	
	}

	static void do2(){
		int i = 10;
		System.out.println(  i > 10 ? ">" : i < 10 ? "<" : "="  );
	}

	static void do3(){
		
		List<String> list = new ArrayList<String>(); 
		list.add("coke"); list.add("pepsi"); list.add("miranda");
		System.out.println( "total list = "  + list );
		
		// build String [] to transfer e in list to

		String[] ws1 = new String[ list.size() -1 ];

		System.out.println( "ws1 = " + ws1 + ", " + Arrays.toString(ws1) );

		String[] ws2 = list.toArray( ws1 );
		//String[] ws2 = list.toArray( new String[ list.size() ] ); 
		System.out.println( "--" );
		System.out.println( "ws1 == ws2 " + (ws1 == ws2)  );
		System.out.println( "ws1 = " + ws1 + ", " + Arrays.toString(ws1)  );
		System.out.println( "ws2 = " + ws2 + ", " + Arrays.toString(ws1)  );


		// reassign ws1

		ws1 = new String[ 1 ];
		ws1[0] = "Test Data";
		ws2 = list.toArray(ws1);


		System.out.println( "--" );
		System.out.println( "ws1 == ws2 " + (ws1 == ws2)  );
		System.out.println( "ws1 = " + ws1 + ", " + Arrays.toString(ws1)  );
		System.out.println( "ws2 = " + ws2 + ", " + Arrays.toString(ws1)  );
	}



}
