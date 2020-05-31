package hanu_10;
import java.io.*;
class NestedTCFTest1{

	void foo() throws EOFException{
		if (true)
			throw new EOFException("shoot");
	}

	void bar() throws IOException {
		try{
			foo();
		}
		catch( Exception exc ){
			throw exc;
		}
		finally{
			throw new IOException(); 
		}
	}

	public static void main(String[] args) throws Exception {
		new NestedTCFTest1().bar();
	}
}
