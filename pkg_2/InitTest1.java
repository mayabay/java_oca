package pkg_2;
import java.util.*;
class InitTest1 {

	static { 
		//i++;
		System.out.println( "i = " + i );
		i = 14;
	}

	static int i = 10;


	public static void main(String[] args){

	}

	static void m(){
		try{
		}
		catch( IOException | NullPointerException e ){
		//catch( NullPointerException | Exception e ){	
			// 20: error: Alternatives in a multi-catch statement cannot be related by subclassing
		}
	}


}
