package hanu_6;
class DuffsDevice {

	public static void main(String[] args){

		short[] from = new short[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		short[] to = new short[from.length];
		short count = (short)from.length;

		short n = (short) ( (count+7)/8 );
		switch( count%8 ){
	
			case 0: do { 			System.out.println( "0" );
			case 7: 				System.out.println( "1" );
			case 6: 				System.out.println( "2" );
			case 5: 				System.out.println( "3" );
			case 4: 				System.out.println( "4" );
			case 3: 				System.out.println( "5" );
			case 2:	 				System.out.println( "6" );
			case 1: 				System.out.println( "7" );

			} while (--n > 0);
		}

	}

}
