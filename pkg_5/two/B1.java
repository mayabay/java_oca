package pkg_5.two;
import pkg_5.one.A1;
public class B1 extends A1 {
	
	private int prot = 6; 

	public static void main(String[] args){

		//A1 a1 = new B1();
		//System.out.println( a1.prot );	// DNC error: prot has protected access in A1

		B1 b1 = new B1();
		System.out.println( b1.prot );

		Double d = 0;
		Short s = 10;
		Byte b = 10;
		//Float f = 10;
		System.out.println( s );


	}
}
