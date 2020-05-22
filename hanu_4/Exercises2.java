package hanu_4;
class Exercises2{

	public static void main(String[] args){
		do44_10();
	}

	static void do44_7(){
		DataEx2 d = new DataEx2();

		DataEx2[] datas = new DataEx2[] { d, d, d };

		datas[0].value = 2;
		datas[1].value = 3;
		datas[2].value = 4;

		for( DataEx2 data: datas ){
			System.out.println( d.value );
		}

		System.out.println( "---" );
		System.out.println( d.value );


	}

	static void do44_8(){
		int[][] upper = new int[][]{ 
			{ 1,2,3 },
			{ 0,5,6 },
			{ 0,0,9 }
		};
		// exercise 4.4.9
		int[][] lower = new int[][]{ 
			{ 1,0,0 },
			{ 4,5,0 },
			{ 7,8,9 }
		};

	}

	static void do44_10(){
		Object[] objArr = new Object[3];
		objArr[0] = new int[] { 1,2,3 };
		objArr[1] = new int[][] { {1,2,3},{4,5,6},{7,8,9} };
		objArr[2] = new Object[0];

		Object e1 = new int[][] { {1,2,3},{4,5,6},{7,8,9} };

		System.out.println( e1.getClass().isArray() );
	


	}







}
class DataEx2 {
	public int value;
}
