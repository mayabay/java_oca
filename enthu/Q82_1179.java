package enthu;
public class Q82_1179{

	public static void main(String[] args){
		byte 	b = 1;
		short 	s = 1;
		char 	c = 1;
		int 	i = 1;
		long 	l = 1;

		//s = b;			// auto widening with VARS OK
		//b = s;			// DNC incompat
		//b = 127;			// auto narrow OK with LITERALS
		
		//s = c;			// DNC incompat
		//c = s;			// DNC incompat

		//i = l;			// DNC incompat
		//i = 1L;			// DNC incompat auto narrow OF LITERALS not from LONG
		//b = 1L;			// same

		final short S = 1;
		final char 	C = 1;
		final char  C2= 65535;
		final int	I = 1;	
		final long  L = 1L;

		//b = S;				// OK oh my god! auto narrow for VAR if CONSTANT
		//s = I;				// omg

		//s = C;				// omg
		//c = S;				// omg

		//s = C2;				// DNC incompat size does not fit

		//b = L;				// DNC incompat L is a CONSTANT but no auto narrow long -> int only int -> down ..

		float 	f = 3.1415f;
		double	d = 3.1415;

		//i = 1f;			// DNC incompat
		//i = 3.1415f;		// DNC incompat
		//i = (int)3.1415f;
		//System.out.println( i );	// 3

		//f = d;			// DNC incompat
		//d = f;			// OK 

		//f = 3.14_15;		// DNC incompat no auto narow for fp literals


		final double D = 3.1415;
		
		//f = D;			// DNC incompat
		

	}
}
