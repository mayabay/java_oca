package hanu_8;
class InstanceCounter{
	
	static int count;
	
	InstanceCounter(){
		count++;
	}
	
	static void printCount(){
		System.out.println(  count );

	}
	
	void reduceCount (){
		count--;
	}


	static {
		//System.out.println( b );	// DNC 21: error: illegal forward reference
		b = 10;
		//System.out.println( b );	// same

	}

	static int b;

	static {
		System.out.println( b );

	}

	
	public static void main(String[] args){

	}

}




