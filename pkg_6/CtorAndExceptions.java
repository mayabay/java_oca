package pkg_6;
import java.io.*;
class A1{
	A1() throws IOException {
		throw new IOException("told you!");
	}
}
class B1 extends A1 {
	B1() throws FileNotFoundException {
		// 9: error: unreported exception IOException; must be caught or declared to be thrown
		// you cannot throw a more specific exception to the caller

		/*
		try{
			//super();		// DNC 11: error: call to super must be first statement in constructor
		}
		catch( FileNotFoundException fnfe ){
			//
		}
		*/
	}


}
class CtorAndExceptions {
	
	public static void main(String[] args){

	}

}
