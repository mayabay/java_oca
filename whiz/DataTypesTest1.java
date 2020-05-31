package whiz;
class DataTypesTest1 {

	public static void main(String[] args){
		do1();
	}
	static void do1(){
		int [] arr = { 3,053,1 };
		for ( int i : arr ){
			System.out.println( i );

		}

		int[] arr2 = new int[0b101];
		System.out.println( "arr2 length = " + arr2.length );

		Double d = new Double(3);

	}
}
