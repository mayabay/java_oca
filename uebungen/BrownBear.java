package uebungen;
import hanu_8.Bear;

public class BrownBear extends Bear {

	public BrownBear(String name){
		super(name);		
	}

	public static void main(String[] args){

		BrownBear brown = new BrownBear("Charlie");
		System.out.println( brown.getName() );

		Bear brown2 = new BrownBear("Bert");
		//System.out.println( brown2.getName() ); // DNC 16: error: getName() has protected access in Bear

		//brown2.printName();		// DNC 18: error: cannot find symbol
	}

	void printName(  ){
		System.out.println( getName() );
	}
}
