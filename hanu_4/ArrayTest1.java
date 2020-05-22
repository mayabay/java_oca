package hanu_4;
class ArrayTest1{
	
	public static void main(String[] args){
		
		Long lo = new Long(42);			// strict ctor invocation
		//Short sh = new Short(42);		// no primitive narrowing in ctor invocation ctx
		do3();
	}

	static void do1(){

		int i, ia[];
		int[] ib, ibb[];

		Object[] o, oo[], ooo[][];


		Integer[] iArr = {1,2,3,4};

		Object[] oArr = iArr;

		//oArr[0] = new Long(42);		// RTE java.lang.ArrayStoreException: java.lang.Long

	}

	static void do3(){
		int[] ia = new int[10];

		//System.out.print( ia.getClass().getName() + ", " );
		//System.out.print( ia.getClass().getSuperclass().getName() );

		// [I, java.lang.Object

		String[] strArr = new String[4];

		//printClass(strArr);
		// [Ljava.lang.String;, java.lang.Object

		boolean[] bo;
		bo = new boolean[] { true, false, true };



	}

	static void printClass( Object obj ){
		System.out.println(  );
		System.out.print( obj.getClass().getName() + ", " + obj.getClass().getSuperclass().getName() );

	}


	static void do4(){}

}
