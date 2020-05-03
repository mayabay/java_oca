package pkg_2;
public class CompareTest1 {


	static {
		throw new NullPointerException("i am a null");
	}

	public static void main(String[] args){
		
		Integer i1 	= 	1;

		Long l1		=	1L;

		long l2			=	1L;

		//System.out.println( i1 == l1 );		// DNC incompat
	
		System.out.println( i1 == l2 );

		System.out.println( i1.equals(l1) );





	}
}
