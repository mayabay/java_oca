package pkg_2;
class LearnNumericPromo{


	public static void main(String[] args){
		//autowide();
        Integer i = 999999;
        //int i = 999999;
        char c = 'c';
        //c *= i;
        c += i;

        System.out.println( c );

	}


	/*
	 * https://floating-point-gui.de/languages/java/
	 * https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.2.3
	 *
	 * https://dzone.com/articles/never-use-float-and-double-for-monetary-calculatio
	 *
	 *
	 * */
	static void numericPromo(){
	
		byte 	b1 	= 8;
		short 	s1	= 16;
		char 	c1 	= 16;
		int 	i1 	= 32;

		long 	l1 	= 64L;
		float	f1 	= 32.1F;
		double	d1	= 64.1D;	

			
			// double 64
			//d1 = f1 = l1 = i1 = c1 = s1 = b1;	// DNC java:39: error: incompatible types: possible lossy conversion from short to char
			d1 = f1; 

		// float 32 bit	
		//f1 = d1;	// DNC 24: error: incompatible types: possible lossy conversion from double to float
	




						// long 64 bit
						//l1 = f1; // DNC incompat lossy conv
						f1 = l1;
						l1 = i1;
					// int 32 bit
					//i1 = l1;	// DNC incompat lossy
					i1 = s1;
				// char 16 bit unsigned
				//c1 = i1;	// DNC incompat lossy
				  c1 = (char)i1;
				//c1 = s1;	// DNC incompat lossy
				  c1 = (char)s1;
				//s1 = c1;	// DNC incompat lossy
				  s1 = (short)c1;
			// short 16 bit
			//s1 = c1;	// DNC incompat
		// byte 8 bit
		
		//b1 = s1;	// DNC 53: error: incompatible types: possible lossy conversion from short to byte
		
		// implicit narrowing
		byte 	b2 	= 	42;					// DNC 	byte	b3	= 	129; 	// DNC incompat lossy
		short 	s2 	=	-32000;				// DNC 	s2	 = 65535;			// DNC incompat lossy
		char 	c3	=	64442;
		int 	i2  = 	1_234_567_890;
		//int 	l2 = 	64L;				// DNC incompat lossy
		long 	l2 = 	64;					
		//byte 	b3 = 	64L;				// DNC incompat lossy
		byte	b4 = 	64;
		//float	f3 = 	64.0D;				// DNC incmpat lossy
		//float	f3 = 	64.0;				// DNC incompat lossy	
	} 
	

	static void autowide(){
		double d1 = 4.56f;
		System.out.println( d1 );

	}

	static void switchIt(){
		

		byte 	b1 	= 8;
		short 	s1	= 16;
		char 	c1 	= 16;
		int 	i1 	= 32;

		long 	l1 	= 64L;
		float	f1 	= 32.1F;
		double	d1	= 64.1D;	
	
		switch(b1){}

		//byte b2 = 167;	// DNC incompat lossy
				byte 	b2 	= 127;
		final 	char 	c2 = 127;
		final 	int		i2 = 127;
		final  	int  	i3 = 126;
		final 	long	l2 = 64L;
		final	float 	f2 = 32.0F;
		final 	double	d2 = 64.0D;

		switch(b1){
			case c2:
			//case i2:	// DNC duplicate case label	
			case i3:
			//case l2:	// DNC incompat lossy
			//case f2:	// same
			//case d2:	// same
		}

	}

}
