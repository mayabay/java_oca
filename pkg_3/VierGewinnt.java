package pkg_3;

public class VierGewinnt {
	static java.util.Scanner sc = new java.util.Scanner(System.in);
	
	static 			String 		log 	= "";
	static final 	int 	ROWS 	= 6;
	static final 	int 	COLS 	= 7;
	static final 	int 	P1 		= 1;
	static final 	int 	P2 		= 2;
	
	static int[][] game = new int[ROWS][];
	
	public static void main(String[] args) {
		
		init( game );
		//p( game );
		
		play();
		
		if ( sc != null ) {
			sc.close();	
		}
		
	}

	static void init( int[][] game ) {
		for (int i = 0; i < ROWS; i++) {
			game[i] = new int[COLS];
		}
	}
	
	static void p( int[][] arr ){
		
		for ( int i = 0; i < COLS; i++ ) {
			System.out.print( i + " " );
		}
		
		System.out.println();
		System.out.println( "- - - - - - - " );
		
		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[i].length; j++ ) {
				System.out.print( arr[i][j]  + " " );
			}
			System.out.println();
		}
		
	}
	
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
	
	static boolean checkWin( int player ) {
		rows: for( int r = 0; r < game.length; r++ ) {
			// check this row
			cols: for( int c = 0; c < game[r].length; c++ ) {
				if ( game[r][c] == player ) {
					// check winning conditions for this player
					boolean hasWon = false;
					// 1 horizontal
					if ( checkWinHor( player, r, c ) ) { log += "| player " + player + " has won!"; return true; }
					// 2 vertical
					if ( checkWinVer( player, r, c ) ) { log += "| player " + player + " has won!"; return true; }
					// 3 diagonal
					if ( checkWinDia( player, r, c ) ) { log += "| player " + player + " has won!"; return true; }
				}
			}
		}
		// no winning condtion found
		return false;
	}
	
	// horizontal winning condition
	static boolean checkWinHor( int player, int row, int col ){ 
		System.out.println(" cehcking row =  " + row + " and col = " + col);
		
		boolean flag = false;
		
		// to east
		boolean eastFlagSet = true;
		if (col + 3 <= COLS  ) {
			for( int i = 0; i < 3; i++ ) { 
				if ( game[row][col+i] != player ) { eastFlagSet = false; }
			}
		}
		
		// to west
		boolean westFlagSet = true;
		if (col - 3 >= 0  ) {
			for( int i = 0; i < 3; i++ ) { 
				if ( game[row][col-i] != player ) { westFlagSet = false; }
			}
		}		
		
		if ( eastFlagSet && !westFlagSet ) { flag = true; }
		if ( westFlagSet && !eastFlagSet ) { flag = true; }
		
		return flag;
	}
	// vertical winning condition
	static boolean checkWinVer( int player, int row, int col ){ return false; }
	// diagonal winning condition
	static boolean checkWinDia( int player, int row, int col ){ return false; }
	
 	static void play() {
		
		boolean doPlay = true;
		
		playing: while( doPlay ) {

			// -- show map
			p( game );						
			
			// -- P1
			System.out.println( "player 1 : " );
			int inp1 = getIn();
			if (inp1 == -1) { break playing; }
			setInput( inp1, P1 );

			if (checkWin( P1 )) {
				log += "| congratulations!"; break playing;
			}
			
			// -- show map
			p( game );			
			
			// -- P2
			System.out.println( "player 2 : " );
			int inp2 = getIn();
			if (inp2 == -1) { break playing; }
			setInput( inp2, P2 );			
			
			if (checkWin( P2 )) {
				log += "| congratulations!"; break playing;
			}			
			
			// -- show map
			p( game );
			
			// -- proceed?
			System.out.println("next (0 = no, 1 = yes)? ");
			int i = getIn();
			if (i == 0) {
				log += "| game canceled";
				break playing;
			}
		}
		
		log += "| games has ended.";
		System.out.println( log );
	}
	
	static int getIn() {
		int n = sc.nextInt();
		if (n < 0 || n > COLS) {
			log += "| not valid";
			return -1;
		}   
		return n;
	}
	
}
