package pkg_3;
public class StringAPITest1 {
	
	public static void main(String[] args){
		do1();
	}

	static void do1(){
 
		char[] chars = { 'a','b','c','c','b','a' };
		byte[] bytes = { 1, 2, 3, 4 };

		String str1 = new String( chars );

		String str2 = new String( bytes );

		System.out.println( str1.replace("bc", "de") );

		System.out.println( str1.indexOf('b') );	// 1

		System.out.println( str1.lastIndexOf('b') );	// 4

		System.out.println( str1.substring(1,2) );		// b

		System.out.println( "ABC".equalsIgnoreCase("abc") );	// true


	}



}
