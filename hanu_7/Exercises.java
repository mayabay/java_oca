package hanu_7;
class Exercises {

	public static void main(String[] args){
		//do3( Integer.parseInt( args[0] ) );
		do5();
	}

	static void do1(){
		
		int [][] upperTri = new int[3][3];

		ROWS: for ( int i = 0; i < upperTri.length; i++ ){

			COLS: for ( int j = 0; j < upperTri[i].length; j++ ){
				int val = 0;
				boolean update = true;

				if (update) {
					val = i + j;
					upperTri[i][j] = val;
				}
			}

		}
		
		for ( int[] iArr : upperTri ){
			for ( int i : iArr ){
				System.out.print( i + " " );
			}
			System.out.println(  );
		}
	}

	static void do2( int n ){
		//int n = 18;
		boolean isPrime = true;	
		for ( int i = 2; i <= n/2; i++  ){
			//System.out.println( "remainder for " + n + " %  " + i + " = " + n % i  );
			if (n % i == 0){  
				//System.out.print( " " + i );
 				isPrime = false; 
			} 
		}
		
		System.out.println( "\t " + n + " is prime = " + isPrime );

	}

	static void do3( int n ){
		for ( int i = 2; i <= n; i++  ){
			System.out.println( "---" + i );
			do2(i);


		}
	}

	static void do4(){
		int[] _1D1 = new int[]{1, 2, 3};
		int[][] _2D1 = new int[][]{ _1D1 };
		int[][] _2D2 = new int[][]{ _1D1, _1D1 };
		int[][][] _3D = new int[][][]{ _2D1, _2D2 };

		for ( int i = 0; i < _3D.length; i++ ){
			for ( int j = 0; j < _3D[i].length; j++ ){
				for ( int k = 0; k < _3D[i][j].length; k++ ){
					System.out.print(  _3D[i][j][k]  );

				}
				System.out.println(  );

			}
		}

	}

	static void do5(){
		String[][] chars = new String[2][];
		chars[0] = new String[1];
		chars[1] = new String[4];
		char cha = 97;
		for(char c=0;c<chars.length; c++, new String("Andreas") ){
			for(char ch=0;ch<chars[c].length; ch++){
				chars[c][ch] = ""+cha;
				System.out.print( chars[c][ch] );

				cha++;
			}
			System.out.println(  );

		}
	}



}
