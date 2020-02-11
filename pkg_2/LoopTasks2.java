/*
 * LoopTasks
 * OCA While Schleifen 
 *
 *
 * */
package pkg_2;
import java.util.Scanner;

public class LoopTasks2 {


    public static void main(String[] args){
   
        //task33();
        //task38(args); // atm
		task39(args);

    }

    static void task33(){
        int x = 1;
        while ( x <= 10 ){
            System.out.print( x + ( x == 10 ? "": ", " ) );
            x++;
        }
    }

    static void task34(){
        Scanner sc = new Scanner(System.in);
        System.out.println( "pls, input a binary :" );
        String input = sc.next();

        char[] carr = input.toCharArray();
        for( char c : carr ){
            if ( c != '1' && c != '0' ){
               return;
            } 
        }

        int sum = 0;

        int basePos = 0;

        for( int i = (carr.length-1); i >= 0; i-- ){
            if( carr[i] == '1' ){
                sum += 1 * ((int)Math.pow( 2, basePos ));
            } 
            basePos++;
        }

        sc.close();
        System.out.println( "input = " + input + " --> " + sum );

    }

    static void task35(String[] args){
        if (args.length == 0){
            System.out.println( "arg pls!" );
            return;
        }

        int idx = 0;
        char[] carr = args[0].toCharArray();
        
        boolean hasChars = true;
        while(hasChars){
            if ( idx < carr.length ){
                System.out.print( carr[idx] );
            }else{
                hasChars = false;
            }
            idx++;
        }
        System.out.println( "\nchars = " + (idx-1) );

    }       


    static void task36(String[] args){
        if (args.length == 0){
            System.out.println( "arg pls!" );
            return;
        }

        char[] carr = args[0].toCharArray();
        for( int i = (carr.length-1); i >= 0; i-- ){
            System.out.print( carr[i] );

        }

    }


    static void task37(String[] args){
        if (args.length == 0){
            //System.out.println( "arg pls!" );
            //return;
        }

        boolean sixFound = false;

        while (!sixFound){
            int n = (int)(Math.random() * 6 + 1);
            System.out.println( "i have a " + n );
            if (n == 6){
                System.out.println( "\t :-) !!" );
                sixFound = true;
            }
        }

    }

    static int atm_500 = 40;
    static int atm_200 = 12;
    static int atm_100 = 82;
    static int atm_50 = 64;
    static int atm_20 = 17;
    static int atm_10 = 35;
    static int atm_5 = 200;

	static int[] noteSet = new int[7];

	static int calcUnits( int r, int noteType ){
		//System.out.println( "\t check for "+ noteType +", r = " + r );

		if (r <= 0){
			return 0;
		}

		int avail = 0; // notesOfTypeAvailable 
		switch ( noteType ){
			case 500: avail = atm_500; break;
			case 200: avail = atm_200; break;
			case 100: avail = atm_100; break;
			case 50: avail = atm_50; break;
			case 20: avail = atm_20; break;
			case 10: avail = atm_10; break;
			case 5: avail = atm_5; break;
			default : throw new IllegalArgumentException("Not a valid note type."); 
		}

		int units = 0;	// nr of notes

		if ( r >= noteType && avail > 0 ){	// works with note type and units available, r = ; r >=
			units = (int) ( r / noteType);
			if (avail > units){
				//r = r - ( units * noteType ); caller will do this
				r = units * noteType;
	
				// reduce atm note count by units and set noteSet
				switch ( noteType ){
					case 500: atm_500 -= units; noteSet[0] = units;  break;
					case 200: atm_200 -= units;  noteSet[1] = units; break;
					case 100: atm_100 -= units;  noteSet[2] = units; break;
					case 50: atm_50 -= units;  noteSet[3] = units; break;
					case 20: atm_20 -= units;  noteSet[4] = units; break;
					case 10: atm_10 -= units;  noteSet[5] = units; break;
					case 5: atm_5 -= units;  noteSet[6] = units; break;
				}

			}else{
				r = 0;
			}
		
		}else{
			r = 0;
		}
		
		return r;	// rest of amount to reduce
	}

    static int[] calcSetOfNotes( int amount ){
		
		// reset noteSet
		for( int i = 0; i < noteSet.length; i++ ){
			noteSet[i] = 0;
		}

        int r = amount;

		// run thru the note boxes
		r -= calcUnits( r, 500 );
		r -= calcUnits( r, 200 );
		r -= calcUnits( r, 100 );
		r -= calcUnits( r, 50 );
		r -= calcUnits( r, 20 );
		r -= calcUnits( r, 10 );
		r -= calcUnits( r, 5 );
        
		if ( r == 0 ) {
            //return new int[] { n_500, n_200,  }
			return noteSet;
        }
        else{
            return new int[] { -1,0,0,0,0,0,0 };
        }

    }

    static void task38( String[] args ){
        if (args.length == 0){
            System.out.println( "arg pls!" );
            return;
        }
        
        int[] set = calcSetOfNotes( Integer.parseInt( args[0] ) );
		if ( set[0] == -1 ){
			System.out.println( "Cannot output this amount of notes." );

		}else{
			System.out.println( "Your notes: " );
			printNotes(set);
		}
    }
   
	static void printNotes( int[] noteSet ){
		int sum = 0;
			for ( int i = 0; i < noteSet.length; i++ ){
				switch( i ){
					case 0: System.out.print( "500 : " ); sum += 500 * noteSet[i]; break;
					case 1: System.out.print( "200 : " ); sum += 200 * noteSet[i]; break;
					case 2: System.out.print( "100 : " ); sum += 100 * noteSet[i];  break;
					case 3: System.out.print( "50  : " ); sum += 50 * noteSet[i]; break;
					case 4: System.out.print( "20  : " ); sum += 20 * noteSet[i]; break;
					case 5: System.out.print( "10  : " ); sum += 10 * noteSet[i]; break;
					case 6: System.out.print( "5   : " ); sum += 5 * noteSet[i]; break;

				}
				System.out.print(noteSet[i]);
				System.out.println(  );

			}
			System.out.println( "atm outputs " + sum );

		}


		static void task39(String[] args){

			if (args.length != 2){
				System.out.println( "arg pls!" );
				return;
			}
			
			// greates common divisor (gcd)
			
			int n = Integer.parseInt( args[0] );			// n = numerator
			int d = Integer.parseInt( args[1] );			// d = denominator

			if (n == d){
				System.out.println( "Both numbers are the same." );
				return;
			}

			boolean gcdFound = false;
			
			int divisor = 1, commonDivisor = 1, gcd = 1, biggest;

			if (d > n){ 
				biggest = d;
			}else{
				biggest = n;
			}

			int checks = 1;

			gcd: while( ! gcdFound ){

				int dividesNumerator = 0;
				if ( n % divisor == 0 ){
					dividesNumerator = divisor;
					System.out.println( "\t\t n has divisor " + divisor + " " );

				}

				int dividesDenominator = 0;
				if ( d % divisor == 0 ){
					dividesDenominator = divisor;
					System.out.println( "\t\t d has divisor " + divisor + " " );
				}


				//if (divisor >= n || divisor >= d ){
				if (divisor >= biggest){
					gcdFound = true;
				}

				if ( dividesNumerator > 0 && dividesDenominator > 0 ){
					commonDivisor = divisor;
					gcd = commonDivisor;

				}

				System.out.println( "\t[check = " + checks + "] divisor = " + divisor + ", commonDivisor = " + commonDivisor );
				
				divisor++;
			

				checks++;
				//if (checks > 100) { gcdFound = true; }
			}
			
			System.out.println( "checks = "+ (checks - 1) +", numerator: "+n+" / denominator: " + d + ", gcd = " + gcd );

		
		 
	}








}	
