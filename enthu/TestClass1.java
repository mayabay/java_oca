package enthu;
import java.io.*;
public class TestClass1 {

	public static void main(String[] args){
		try{
			//amethod();
		}
		catch( IOException ioe ){
			ioe.printStackTrace();
		}
		catch(Exception e){
			System.out.println( "exc caught" );


		}
		finally{
			System.out.println( "finally" );

		}

		System.out.println( "out" );

	

	}

	

	static void amethod() throws IOException {
	}
}
