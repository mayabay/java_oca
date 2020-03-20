package pkg_6;

class MyShitException extends Exception {			// DNC w/o class : class, interface, or enum expected
	MyShitException(){} 
	MyShitException(String s){ super(s); } 
}

public class CheckedInCatch {

	public static void main(String[] args){

		//new CheckedInCatch().shit();

		CheckedInCatch cic = new CheckedInCatch();

		try {
			cic.m1();
		}
		catch(MyShitException mse ){
			cic.m1();
		}
		finally{
			//throw new RuntimeException();		// LOC 20 is ok, because it is never thrown
			cic.m2();							// LOC 20 error: unreported exception MyShitException; must be caught
												//	or declared to be thrown (method might not throw the exception)
		}

	}

	void shit(){
		
		try {
			m1();
		}
		catch(MyShitException mse ){
			m1();
		}
		finally{
			throw new RuntimeException();
			//m2();
		}

	}


	void m1() throws MyShitException {
		throw new MyShitException("oh shit");
	}


	void m2()  {
		throw new RuntimeException("runtime shit");
	}

}
