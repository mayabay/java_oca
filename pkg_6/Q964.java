package pkg_6;
public class Q964 {

	public static void main(String[] args){

		try{
			m1();
			System.out.println( "A" );

		}
		catch ( Exception e ){

			System.out.println( "B" );

		}
		finally{
			
			System.out.println( "C" );
		}

		System.out.println( "D" );

		
		

	}

	static void m1() throws Exception { throw new Exception("m1()"); }
}
