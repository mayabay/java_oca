package pkg_3;

public class VierGewinnt {
	
	static java.util.Scanner sc = new java.util.Scanner(System.in);
	
	static 			String		log 	= "";				// log
	static final 	int 		ROWS 	= 6;				// rows 6
	static final 	int 		COLS 	= 7;				// columns 7
	static final 	int 		P1 		= 1;				// name player 1
	static final 	int 		P2 		= 2;				// name player 2
	static 			int			debug	= 1;				// log 
	static 			int			fields  = ROWS * COLS;		// fields in the game
	static 			java.util.Random r;						
	static 			double		initFieldsPerPlayer = 0.0D;	// 0.25D -> 25% of all fields will be initiated randomly for a player
	
	static int[][] game = new int[ROWS][];					// game field
	
	public static void main(String[] args) {
		
		init( game );
		p( game );
		
		play();
		
		if ( sc != null ) {
			sc.close();	
		}
		
	}

	static void init( int[][] game ) {
		
		// initialize the fields
		for (int i = 0; i < ROWS; i++) {
			game[i] = new int[COLS];
		}
		
		System.out.println("Game has " + ROWS + " rows and " + COLS + " cols with total " + fields + " fields.");
		
		// set random fields for player
		if (initFieldsPerPlayer > 0 & initFieldsPerPlayer < 1.0D) {
			int randomFields = (int) (fields * initFieldsPerPlayer) ;
			for ( int i = 0; i < randomFields; i++ ) {
				// 1
				game[ getR(0,ROWS) ][getR(0,ROWS)] = 1;
				// 2
				game[ getR(0,ROWS) ][getR(0,ROWS)] = 2;
			}
		}
	}
	
	static void p( int[][] arr ){
		
		for ( int i = 0; i < COLS; i++ ) {
			int n = i < 10 ? i : i - 10;
			System.out.print( n + " " );
		}
		
		System.out.println();
		for ( int i = 0; i < COLS; i++ ) { System.out.print( (i < 10 ?  "- " : "- " ) ); }
		System.out.println();
		
		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[i].length; j++ ) {
				System.out.print(  arr[i][j]  +  ( j < 10 ? " ":" " )  );
			}
			System.out.print(" | " + i);
			System.out.println("");
		}
		
	}
	
	// store players decision
	static void setInput( int col, int player ) {
		rows: for( int i = game.length-1; i >= 0; i-- ) {
				cols: for ( int j = 0; j < game[i].length; j++ ) {
					if ( j == col ) {
						// found col
						if ( game[i][j] == 0 ) { game[i][j] = player; break rows; }
					}
				}
			}
	}

	// find all player spots
	static boolean checkWin( int player ) {
		
		rows: for( int r = 0; r < game.length; r++ ) {
			// check this row
			cols: for( int c = 0; c < game[r].length; c++ ) {
				if ( game[r][c] == player ) {
					// check winning conditions for this player
					//boolean hasWon = false;
					// 1 horizontal
					if ( checkWinHor( player, r, c ) ) { log += "| player " + player + " has won!"; log += "| [[row = " + r + ", col = " + c + "]]"; return true; }
					// 2 vertical
					if ( checkWinVer( player, r, c ) ) { log += "| player " + player + " has won!"; log += "| [[row = " + r + ", col = " + c + "]]"; return true; }
					// 3 diagonal
					if ( checkWinDia( player, r, c ) ) { log += "| player " + player + " has won!"; log += "| [[row = " + r + ", col = " + c + "]]"; return true; }
				}
			}
		}
		// no winning condition found
		return false;
	}
	
	// horizontal winning condition
	static boolean checkWinHor( int player, int row, int col ){ 
		if (debug == 1)
		System.out.println("[hor] checking player "+ player +": row =  " + row + " and col = " + col);
		
		boolean flag = false; 
		
		// to east
		boolean eastFlagSet = true;
		if (col + 3 < COLS  ) {
			for( int i = 1; i <= 3; i++ ) { 
				if (debug == 1)
				System.out.println("\t\t east:: row = " + row + ", col + i = " + (col + i));
				if ( game[row][col+i] != player ) { eastFlagSet = false; } 
			}
		}else{
			eastFlagSet = false;
		}
		
		// to west
		boolean westFlagSet = true;
		if (col - 3 >= 0  ) {
			for( int i = 1; i <= 3; i++ ) { 
				if (debug == 1)
				System.out.println("\t\t west:: row = " + row + ", col - i = " + (col - i));
				if ( game[row][col-i] != player ) { westFlagSet = false; } 
			}
		}else{
			westFlagSet = false;
		}	
		
		if ( eastFlagSet & !westFlagSet ) { flag = true; log += "| [[eastFlagSet]]"; }
		if ( westFlagSet & !eastFlagSet ) { flag = true; log += "| [[westFlagSet]]"; }
		if (debug == 1)
		System.out.println( "eastFlagSet = " + eastFlagSet + ", westFlagSet = " + westFlagSet  );
		return flag;
	}
	
	// vertical winning condition
	static boolean checkWinVer( int player, int row, int col ){ 
		if (debug == 1)
		System.out.println("[ver] checking player "+ player +": row =  " + row + " and col = " + col);
		
		boolean flag = false;
		
		// to north
		boolean northFlagSet = true;
		if (row - 3 >= 0  ) {
			for( int i = 1; i <= 3; i++ ) { 
				if (debug == 1)
				System.out.println("\t\t north:: row -1 = " + (row - i) + ", col = " + col );
				if ( game[row-i][col] != player ) { northFlagSet = false; } 
			}
		}else{
			northFlagSet = false;
		}
		
		// to south
		boolean southFlagSet = true;
		if (row + 3 < ROWS  ) {
			for( int i = 1; i <= 3; i++ ) { 
				if (debug == 1)
				System.out.println("\t\t south:: row + 1 = " + (row + i) + ", col = " + col);
				if ( game[row + i][col] != player ) { southFlagSet = false; } 
			}
		}else{
			southFlagSet = false;
		}	
		
		if ( northFlagSet & !southFlagSet ) { flag = true; log += "| [[northFlagSet]]"; }
		if ( southFlagSet & !northFlagSet ) { flag = true; log += "| [[southFlagSet]]"; }
		if (debug == 1)
		System.out.println( "northFlagSet = " + northFlagSet + ", southFlagSet = " + southFlagSet  );
		return flag;		
	}
	
	// diagonal winning condition
	static boolean checkWinDia( int player, int row, int col ){ 
		if (debug == 1)
		System.out.println("[diag] checking player "+ player +": row =  " + row + " and col = " + col);
		
		boolean flag = false;
		
		// - NE -------------------------------------------- 
		boolean NE_FlagSet = true;
		if ( row - 3 >= 0 & col + 3 < COLS ) {
			for ( int i = 0; i <= 3; i++) {
				if (debug == 1)
				System.out.println("\t\t NW:: row - i = " + (row - i) + ", col - i = " + (col + i));
				if ( game[row-i][col+i] != player ) { NE_FlagSet = false; }
			}
		}else { NE_FlagSet = false; }  
		
		// - SE --------------------------------------------
		boolean SE_FlagSet = true;
		if ( row + 3 < ROWS & col + 3 < COLS ) {
			for ( int i = 0; i <= 3; i++) {
				if (debug == 1)
				System.out.println("\t\t SE:: row + i = " + (row + i) + ", col + i = " + (col + i));
				if ( game[row+i][col+i] != player ) { SE_FlagSet = false; }
			}
		}else { SE_FlagSet = false; }  		
		
		// - SW --------------------------------------------
		boolean SW_FlagSet = true;
		if ( row + 3 < ROWS & col - 3 >= 0 ) {
			for ( int i = 0; i <= 3; i++) {
				if (debug == 1)
				System.out.println("\t\t SW:: row + i = " + (row + i) + ", col - i = " + (col - i));
				if ( game[row+i][col-i] != player ) { SW_FlagSet = false; }				
			}
		}
		else { SW_FlagSet = false; }
		
		// - NW --------------------------------------------
		boolean NW_FlagSet = true;
		if ( row - 3 >= 0 & col - 3 >= 0 ) {
			for ( int i = 0; i <= 3; i++) {
				if (debug == 1)
				System.out.println("\t\t NW:: row - i = " + (row - i) + ", col - i = " + (col - i));
				if ( game[row-i][col-i] != player ) { NW_FlagSet = false; }				
			}			
		} else { NW_FlagSet = false; }
		
		
		if ( NE_FlagSet & !SE_FlagSet & !SW_FlagSet & !NW_FlagSet ) { flag = true; log += "| [[NE_FlagSet]]"; }
		if ( !NE_FlagSet & SE_FlagSet & !SW_FlagSet & !NW_FlagSet ) { flag = true; log += "| [[SE_FlagSet]]"; }
		if ( !NE_FlagSet & !SE_FlagSet & SW_FlagSet & !NW_FlagSet ) { flag = true; log += "| [[SW_FlagSet]]"; }
		if ( !NE_FlagSet & !SE_FlagSet & !SW_FlagSet & NW_FlagSet ) { flag = true; log += "| [[NW_FlagSet]]"; }
		
		if (debug == 1)
		System.out.println( "NE_FlagSet = " + NE_FlagSet + ", SE_FlagSet = " + SE_FlagSet + ", SW_FlagSet = " + SW_FlagSet + ", NW_FlagSet = " + NW_FlagSet  );
		return flag;			
	}
	
	// runs the play loop
 	static void play() {
		
		boolean doPlay = true;
		
		playing: while( doPlay ) {

			// -- show map
			// p( game );						
			
			// -- P1 ------------------------------------------------------
			System.out.println( "player 1 : " );
			int inp1 = getIn();
			if (inp1 == -1) { break playing; }
			setInput( inp1, P1 );
			
			//p( game );	// debug	
			
			if (checkWin( P1 )) {
				log += "| congratulations!"; break playing;
			}
			
			// -- show map
			p( game );			
			
			// -- P2 ------------------------------------------------------
			System.out.println( "player 2 : " );
			int inp2 = getIn();
			if (inp2 == -1) { break playing; }
			setInput( inp2, P2 );			
			
			//p( game );	// debug
			
			if (checkWin( P2 )) {
				log += "| congratulations!"; break playing;
			}			
			
			// -- show map
			p( game );
			
			// -- proceed?
//			System.out.println("next (0 = no, 1 = yes)? ");
//			int i = getIn();
//			if (i == 0) {
//				log += "| game canceled";
//				break playing;
//			}
		}
		
		
		
		
		log += "| games has ended.";
		System.out.println( log );
		System.out.println("---------------------------------");
		p( game );
	}
	
 	// get user input
	static int getIn() {
		
		int n = -1;

		boolean validInput = false;
		
		while(!validInput ) {
			
			n = sc.nextInt();
			if (n >= 0 & n < COLS) {
				validInput = true;
			} else {
				System.out.println("sorry, try again (98 = cancel game): ");
			}
			if ( n == 98 ) {
				log += "| game canceled"; return -1;
			}
		}
		
		return n;
	}

	// -----------------------------------
	// debug 
	// -----------------------------------
	
	static int getR( int min, int max ) {
		if (r == null) {
			r = new java.util.Random();
		}
		
		int v = 0;
		while (true) {  
			v = r.nextInt(max);
			if ( v >= min ) {
				break;
			}
		}
		return v;
	}	
	
	// check diagonal SE
	static void setDebugSE() {
		game[3][1] = 2;
		game[4][2] = 2;
		game[5][3] = 2;
		
		//game[2][0] = 2;
		game[3][0] = 2;
		game[4][0] = 2;
		game[5][0] = 2;
	}
	// check diagonal SW
	static void setDebugSW() {
		game[5][1] = 2;
		game[4][3] = 2;
		game[3][4] = 2;
		
		game[5][5] = 2;
		game[4][5] = 2;
		game[3][5] = 2;
		//game[5][0] = 2;
	}	
	// check diagonal NW ;-)
	static void setDebugNW() {
		game[5][5] = 2;
		game[4][4] = 2;
		game[3][3] = 2;
		
		game[5][2] = 2;
		game[4][2] = 2;
		game[3][2] = 2;
		//game[5][0] = 2;
	}	




}
