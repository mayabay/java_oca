package hanu_8;
class MethodTest1{

	public static void main(String[] args){
		//do1();
		eatArgs(42);
		eatArgs(1);
		eatArgs(1,2,3);
	}

	static void do1(){

	}

	static int getNum( Short sh ){
		//return sh;
		//return new Float(3.14F);	// DNC incompat
		return new Byte( (byte)1 );
	}

	static void eatArgs(int n,  int ... i ){
		System.out.println("length of i is = " + i.length );
	}


}
