package enthu;

public class Q82_1125 {

	public static void main(String[] args){
		
		Integer i1 	= 1;
		Integer i2 	= new Integer(1);
		int i3 		= 1;
		Byte b3		= 1;
		byte b4		= 1;
		//Long g1 	= 1;	//DNC incompatible types: int cannot be converted to Long
							// no widening and boxing
		Long g1 	= 1L;	// long is  autoboxed 					
		long g2 	= 1;

		System.out.println( i3 == i1 );		// i1 is unboxed 
		System.out.println( i3 == b3 );
		System.out.println( i3 == b4 );



	}
}
