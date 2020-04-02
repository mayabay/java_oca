package pkg_3;
public class BS6_Q21 {

	final int finish( final int i ){
		return i;
	}

	public static void main(String[] args){
		System.out.println( new BS6_Q21().finish( 41 ) );


		short s1 = 4;
		//Short s2 = new Short(4);	// DNC no suitable ctor for int
		Short s3 = new Short( (short)4 );

		//int i1 += 4L;				// DNC 16: error: ';' expected

		int i2 = 0;
		i2 += 4L;					// ok auto narrowing in compound assignment

		i2 = i2 + 4L;				// DNC 21: error: incompatible types: possible lossy conversion from long to int

	}

	

}
