package pkg_3;
class ArrayTest1{
	
	private int id = 0;

	ArrayTest1(int id){
		this.id = id;
	}

	public static void main(String[] args){

		//ArrayTest1[]  arr = new ArrayTest1[2];

		ArrayTest1 at1 = new ArrayTest1(42);

		Object o = go(at1);

		ArrayTest1[]  arr = (ArrayTest1[])o; 

		System.out.println( arr[0] );
	

	}


	static ArrayTest1[] go ( ArrayTest1 o ){
		return new ArrayTest1[] { o };
	}

	public String toString(){
		return "[id="+ this.id +"]";
	}


}



