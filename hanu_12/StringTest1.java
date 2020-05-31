package hanu_12;
class StringTest1 {

	public static void main(String[] args){
		do1();
	}

	static void do1(){
		String name = "Peter Parker";
		System.out.println( name );

		//System.out.printl(  );	// DNC cannot find symbol
		
		String s1 = "andy";
		String s3 = s1.trim();
		System.out.println( "nothing trimmed : same? " + (s1 == s3) );


		String s2 = s1.replace( 'x','X' );
		System.out.println("replace unknown char same? : " + (s1 == s2) );

		s2 = s1.replace( "x","X" );
		System.out.println("replace unknown char seq same? : " + (s1 == s2) );

		StringBuilder sb1 = new StringBuilder("andy");
		StringBuilder sb2 = sb1.replace( 0, sb1.length(),"" );


		//System.out.println("length = 0 ? :" + sb2.isEmpty() );	// DNC cannot find symbol isEmpty()
		System.out.println("length = 0 ? :" + s2.isEmpty() );

		sb1.append(" many sandy");	// result is lower than 20
		System.out.println("capacity() :" + sb1.capacity() );	// 20 -> 16 init + andy = 4


	}
}
