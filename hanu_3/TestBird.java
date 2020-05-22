package hanu_3;
class TestBird {

	private static Bird bird;

	public static void main(String[] args){
		bird = new Bird();

		//System.out.println( bird.wingCount );

		Bird bird2 = new Bird();
		bird2.wingCount = 2;
		bird2.bloodPressure = 60.45F;
		bird2.species = "hawk";
		//bird2.canTalk = false;			// DNC
		bird2.weight = 4589.00D;

		bird.wingCount = bird2.wingCount;
		bird.bloodPressure = bird2.bloodPressure;
		bird.species = bird2.species;
		//bird.canTalk = bird2.canTalk;		// DNC 21: error: cannot assign a value to final variable canTalk
		bird.weight = bird2.weight;
	
		//printBird(bird);
		bird.fly();
		System.out.println( "------------" );
		bird2.fly();
		//printBird(bird2);

		System.out.println( "field = " + bird2.getField()  );






	}

	static void printBird(Bird bird){
		System.out.println( bird.bloodPressure );
		System.out.println( bird.species );
		System.out.println( bird.canTalk );
		System.out.println( bird.weight );
	}

}
