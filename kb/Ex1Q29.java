package kb;
class Ex1Q29 {

	static boolean isHappy = false;

	//label_s:									// DNC identifier expected
	//label_s: static int n;					// DNC iden exp
	static int n;

	//label_s: n = 12;							// DNC iden exp 

	//label_1 :									// DNC iden exp
	static {
		label_n: n = 42;						// OK
		label_i: if ( n == 0 ){
			//break label_n;						// DNC 14: error: undefined label: label_n
			//break;								// DNC 15: error: break outside switch or loop
			break label_i;						// OK
			//System.out.println( ".x1." );		// DNC unreach
	
		}		 
	}

	static boolean m() {

		//label_loki:								// DNC 27: error: '.class' expected
		int loki = 42;

		label_lokiAdd: loki++;

		label_m: if ( n == 42 ){
			System.out.println( "n is 42" );
			//continue;							// DNC 24: error: continue outside of loop
			//continue label_m;					// DNC 25: error: not a loop label: label_m
			if ( isHappy ) break label_m;
			System.out.println( ".1." );
			//break label_lokiAdd;				// DNC 37: error: undefined label: label_lokiAdd
		}



		label_ret: return isHappy; 
	}


	{
		System.out.println( ".2." );

	}

	static void switcher(int n){
		
		label_sw:
		switch(n){
			//case n + 1:						// DNC 55: error: constant expression required
			case 1:
				break;
			case 42: 
				System.out.println( "was 42" );
				break;
			default: 
				System.out.println( "no match" );
				break;

		}


	}

	public static void main(String[] args){

		switcher(41);

		label_f:
		for (int i = 0; i < 4; i++){
			label_2: System.out.println( "#" + i );

			if ( i == 1 ){
				break label_f;
			}

		}

	}
}

