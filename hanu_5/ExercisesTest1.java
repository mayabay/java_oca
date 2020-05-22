package hanu_5;
class ExercisesTest1 {
	
	public static void main(String[] args){
		do3();
	}

	static void do1(){
		String str = "7" + 5 + 10;
		str = 7 + 5 + "10";
		str = "7" + (5 + 10);
		System.out.println( str );

		int m = 50;
		int n = ++m;
		int o = m--;
		int p = --o+m--;
		int x = m<n?n<o?o<p?p:o:n:m;	
				
		System.out.println( x );
	}

	static void do2(){

		byte b = 1;
		//b = b << 1;		// DNC incompat
		int c = b << 1;
		//byte d += b;		// DNC not a statement
		byte e = 0;
		e += b;


	}

	static void do3(){
		String s = "a";
		String[] sa = { "a", s, s.substring(0, 1), new String("a"), ""+'a' };
		for(int i=0; i<sa.length; i++){
			System.out.println(i);
			System.out.println(s == sa[i]);
			System.out.println(s.equals(sa[i]));
		}
		
		System.out.println( "---" );

		System.out.println( "" + 'a' );

	}




}
