package hanu_8;
class InitersAndExceptionsTest1{

	{

		try{
			final int a = 4, b = 0;
			final int c = a/b;		// a and b must have been initialized before
		}catch(ArithmeticException e){
			throw new ArithmeticException("division by zero");
		}
		
		//throw new ArithmeticException("division by zero");
		// 4: error: initializer must be able to complete normally

	}

	public static void main( final String[] args){
		InitersAndExceptionsTest1 init = new InitersAndExceptionsTest1();
	}
}
