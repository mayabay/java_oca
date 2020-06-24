package whiz;
class ShadowTest1{
	
	static {
		x = 20;
		int x = 21;
	}	

	static int x = 10;

	
	public static void main(String[] args){
		System.out.println( "x = " + x );

	}

}
