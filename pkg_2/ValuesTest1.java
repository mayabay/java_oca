package pkg_2;
class ValuesTest1 {

	public static void main(String[] args){
		do1();
	}

	static void do1(){

		byte b1 = 8;
		char c1 = 16;
		short s1 = 16;
		int i1 = 32;
		long l1 = 64;

		// b1 = c1;
		// c1 = b1;
		int i2 = 1_000_000_000;
		//c1 = (char)i2; 
		c1 += i2; 

		System.out.println( c1 );
		




	}

}
