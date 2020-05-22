package hanu_3;

class Bird{

	//Bird bird = new Bird();		// RTE Exception in thread "main" java.lang.StackOverflowError
	Bird bird;

	int wingCount;	
	float bloodPressure;
	static String species;
	static final boolean canTalk = false;
	double weight;

	void fly (){
		
		System.out.println( "Bird is flying ..." );
	
		//System.out.println( bird.bloodPressure );
		//System.out.println( bird.species );
		//System.out.println( bird.canTalk );
		//System.out.println( bird.weight );
	
		System.out.println( "this is flying ..." );

		System.out.println( this.bloodPressure );
		System.out.println( this.species );
		System.out.println( this.canTalk );
		System.out.println( this.weight );

	}

	int getField(){
		return (int)bloodPressure;
	}


}
