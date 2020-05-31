package hanu_10;
import java.io.*;
class StaticInitTest1{

	static {
		if (true){
			//throw new FileNotFoundException("not here");	
			// 7: error: unreported exception FileNotFoundException; must be caught or declared to be thrown
		}
		;
	}


	{
		if (true){
			throw new FileNotFoundException("not here");	
			// 7: error: unreported exception FileNotFoundException; must be caught or declared to be thrown
			// this initer will not compile as long as there exists an ctor w/o declaring a match for the exception thrown
		}
		;
	}

	StaticInitTest1() throws Exception 
	{
	}

	StaticInitTest1( int s ) throws IOException 
	{
	}

	StaticInitTest1( int s, int t )  
	{
	}

	public static void main(String[] args){

	}
}
