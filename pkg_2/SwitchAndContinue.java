package pkg_2;
public class SwitchAndContinue{

	public static void main(String[] args){
		//do1();
		
		int i = 123456789;
		float f = i;
	
		int i2 = f;

		long l = 1234567890L;

		double d = l;

		//long l2 = d;

	}

	static void do1(){

		int s = 4;
		switch(s){
			case 1: 	break;
			default:	break;
			//case 3:		continue;	13: error: continue outside of loop		
		}
	}
}
