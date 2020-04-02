package pkg_2;
public class BS2_Q {


	public static void main(String[] args){
		do11();
	}

	static void do11(){
	
		double d1 = 5f;

		//int i1 = 10L;			// DNC incompat lossy
		
		short s1 = 10;			// auto narrowing for integer litarals
		
		//short s2 = 10L;		// DNC incomap lossy
		
		//float f1 = 12.5;		// DNC incomat lossy

		byte b1 = -128;

		int Short = 42;			// complex types are legal identifiers

		//Short double = 42;		// DNC not a stmt

		Integer intO1 = Integer.valueOf("12");		// returns Wrapper

		int int1 = Integer.valueOf("12");			// unboxing

		//Integer intO2 = Integer.valueOf("12.5f");	// DC RTE NFE	 

		Integer intO3 = Integer.parseInt("42");		// autoboxing

	}


}
