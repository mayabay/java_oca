/* *
 *
 * @author Andreas 
 */
package enthu;
class UnreachTest1{

	static int /** ok */ n;

	public static void main(String[] args){
		do1();
	}

	static void do1(){
		//for (final int i = 12; i > 12; n++ )n++;		// DNC 11: error: unreachable statement
		System.out.println( "n = " + n );

		if (n == 0)
		{
			n++;
			int n = 42;
			System.out.println( "n = " + n );	// n = 42;
		}

		System.out.println( "n = " + n );	// n = 1

	}

}
