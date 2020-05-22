package hanu_7;
class LabelTest1 {

	public static void main(String[] args){
		do2();
	}

	static void m(){
		System.out.println( "m()" );
	}

	static void do1(){
		NAME_1: {}
		NAME_2: do{} while (false);

		//NAME_DECL: int n = 42; 12: error: '.class' expected
		int n = 42, o = 43;
		NAME_EXPR: n++;

		NAME_MCALL: m();

		NAME_WHILE: while(true)break;

		NAME_IF: if ( n == 42 ){
			//continue NAME_MCALL;	// DNC 25: error: undefined label: NAME_MCALL
			//continue NAME_WHILE;	// DNC same
			//continue NAME_IF;		// DNC 27: error: not a loop label: NAME_IF
			//continue;				// DNC 29: error: continue outside of loop
			
			NAME_INNER_IF: if ( o == 43 ){
				break NAME_IF;
			}

			break NAME_IF;			// OK
			
		}


		NAME_RETURN: return;		
	}

	static void do2(){
		
		Object args = new Object();

		System.out.println( "A" );

		BLOCK_1: {
			if ( args != null ) break BLOCK_1;	
			System.out.println( "B" );
		}

		System.out.println( "C" );
	}


}
